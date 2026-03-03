package com.zholdigaliev.crmsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApplicationRequest {
    Long id;
    String userName;
    String courseName;
    String commentary;
    String phone;
    Boolean handled;

}
