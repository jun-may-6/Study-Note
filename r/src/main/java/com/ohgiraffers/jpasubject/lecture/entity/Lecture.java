package com.ohgiraffers.jpasubject.lecture.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Entity
@Table(name = "lecture")
@Getter /*Setter 메소드 지양 (안정성 보장)*/
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Lecture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int lectureCode;
    private String name;
    private int teacherCode;
    private Date startDate;
}
