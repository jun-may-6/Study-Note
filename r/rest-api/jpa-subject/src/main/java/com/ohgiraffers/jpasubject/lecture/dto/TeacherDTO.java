package com.ohgiraffers.jpasubject.lecture.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;
@Getter
@Setter
@ToString
public class TeacherDTO {
    private int teacherCode;
    private String name;
    private Date joinDate;
    private char status;
}
