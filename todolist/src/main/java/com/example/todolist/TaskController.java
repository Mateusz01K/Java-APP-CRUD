package com.example.todolist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    TaskRepository taskRepository;


    @GetMapping("/get")
    public List<Task> getAll(){
        return taskRepository.getAll();
    }

    @GetMapping("/list")
    public ModelAndView getIndex(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("index");
        mav.addObject("tasks", taskRepository.getAll());
        return mav;
    }

    @GetMapping("/add/task")
    public ModelAndView getAdd(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("addTask");
        mav.addObject("tasks", taskRepository.getAll());
        return mav;
    }

    @GetMapping("/update/task")
    public ModelAndView getUpdate(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("updateTask");
        mav.addObject("tasks", taskRepository.getAll());
        return mav;
    }

    @GetMapping("/delete/task")
    public ModelAndView getDelete(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("deleteTask");
        mav.addObject("tasks", taskRepository.getAll());
        return mav;
    }

    @GetMapping("/get/{id}")
    public Task getById(@PathVariable("id") int id){
        return taskRepository.getById(id);
    }

    @PostMapping(path = "/add", consumes = "application/x-www-form-urlencoded")
    public RedirectView addTask(@RequestParam("task") String task, @RequestParam("days") int days) {
        Task newTask = new Task(task, days);
        taskRepository.save(newTask);
        return new RedirectView("/tasks/list");
    }

    @PutMapping("/update/{id}")
    public int update(@PathVariable("id") int id, @RequestBody Task updatedTask){
        Task task = taskRepository.getById(id);
        if(task != null){
            task.setTask(updatedTask.getTask());
            task.setDays(updatedTask.getDays());

            taskRepository.update(task);

            return 1;
        }else {
            return -1;
        }
    }

    @PostMapping(path="/partiallyUpdate/{id}", consumes = "application/x-www-form-urlencoded;charset=UTF-8")
    public RedirectView partiallyUpdate(@RequestParam("id") int id, @RequestParam("task") String task, @RequestParam("days") int days){
        Task taskUpdate = taskRepository.getById(id);
        if(taskUpdate != null){
            if(taskUpdate.getTask() != null) taskUpdate.setTask(task);
            if(taskUpdate.getDays() > 0) taskUpdate.setDays(days);
            taskRepository.update(taskUpdate);
            return new RedirectView("/tasks/list");
        }else{
            return new RedirectView("/tasks/list");
        }
    }

    @PostMapping("/delete/{id}")
    public RedirectView delete(@RequestParam("id") int id){
        taskRepository.delete(id);
        return new RedirectView("/tasks/list");
    }
}