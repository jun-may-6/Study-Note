package com.ohgiraffers.jpasubject.lecture.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Entity
@Table(name = "teacher")
@Getter /*Setter 메소드 지양 (안정성 보장)*/
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int teacherCode;
    private String name;
    private Date joinDate;
    private char status;

    public void modifyStatus(char status) {
        this.status = status;
    }
}
