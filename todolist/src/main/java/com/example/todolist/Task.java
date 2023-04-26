package com.example.todolist;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    private int id;
    private String task;
    private int days;

    public Task(String task, int days){
        this.task = task;
        this.days = days;
    }
}
