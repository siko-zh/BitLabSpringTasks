package com.zholdigaliev.taskmanager.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    int id;
    String name;
    String description;
    LocalDate deadline;
    Boolean isCompleted;
}
