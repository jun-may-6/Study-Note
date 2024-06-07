package com.ohgiraffers.jpasubject.lecture.repository;

import com.ohgiraffers.jpasubject.lecture.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
    @Query(value = "SELECT teacher_code, name, join_date, status FROM teacher WHERE status = 'Y'",
            nativeQuery = true)
    List<Teacher> findTeacherByStatus();
}
