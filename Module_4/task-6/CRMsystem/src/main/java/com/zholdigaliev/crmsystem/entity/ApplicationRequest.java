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
    private Long id;
    private String userName;
    private Course course;
    private String commentary;
    private String phone;
    private Boolean handled;

}
