package com.ohgiraffers.jpasubject.lecture.repository;

import com.ohgiraffers.jpasubject.lecture.entity.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LectureRepository extends JpaRepository<Lecture, Integer> {
    List<Lecture> findByTeacherCode(int teacherCode);
}
