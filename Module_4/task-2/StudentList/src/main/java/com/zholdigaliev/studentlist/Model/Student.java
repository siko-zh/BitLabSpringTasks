package com.zholdigaliev.studentlist.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    Long id;
    String name;
    String surname;
    int exam;
    String mark;
}
