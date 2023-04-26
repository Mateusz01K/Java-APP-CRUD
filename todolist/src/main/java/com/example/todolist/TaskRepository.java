package com.example.todolist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TaskRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Task> getAll(){
        return jdbcTemplate.query("SELECT id, task, days FROM task",
                BeanPropertyRowMapper.newInstance(Task.class));
    }

    public Task getById(int id){
        return jdbcTemplate.queryForObject("SELECT id, task, days FROM task WHERE id=?",
                BeanPropertyRowMapper.newInstance(Task.class), id);
    }

    public int save(Task task) {
        return jdbcTemplate.update("INSERT INTO task(task, days) VALUES (?, ?)", task.getTask(), task.getDays());
    }

    public int update(Task task){
        return jdbcTemplate.update("UPDATE task SET task=?, days=? WHERE id=?",
                task.getTask(), task.getDays(), task.getId());
    }

    public void delete(int id){
        jdbcTemplate.update("DELETE FROM task WHERE id=?", id);
        jdbcTemplate.update("ALTER TABLE task AUTO_INCREMENT = 1");
    }
}
