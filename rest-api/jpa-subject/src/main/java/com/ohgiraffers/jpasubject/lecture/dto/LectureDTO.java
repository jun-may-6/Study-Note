package com.ohgiraffers.jpasubject.lecture.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;
@Getter
@Setter
@ToString
public class LectureDTO {
    private int lectureCode;
    private String name;
    private int teacherCode;
    private Date startDate;
}
