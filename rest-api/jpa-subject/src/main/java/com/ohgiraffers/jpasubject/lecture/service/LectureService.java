package com.ohgiraffers.jpasubject.lecture.service;

import com.ohgiraffers.jpasubject.lecture.dto.LectureDTO;
import com.ohgiraffers.jpasubject.lecture.dto.TeacherDTO;
import com.ohgiraffers.jpasubject.lecture.entity.Lecture;
import com.ohgiraffers.jpasubject.lecture.entity.Teacher;
import com.ohgiraffers.jpasubject.lecture.repository.LectureRepository;
import com.ohgiraffers.jpasubject.lecture.repository.TeacherRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LectureService {
    private final LectureRepository lectureRepository;
    private final TeacherRepository teacherRepository;
    private final ModelMapper modelMapper;


    public List<LectureDTO> findAllLecture() {
        List<Lecture> lectureList = lectureRepository.findAll();
        return lectureList.stream().map(menu->modelMapper.map(menu, LectureDTO.class)).toList();
    }

    public LectureDTO findById(int lectureCode) {
        Lecture lecture = lectureRepository.findById(lectureCode).orElseThrow(IllegalArgumentException::new);
        return modelMapper.map(lecture, LectureDTO.class);
    }

    public Page<LectureDTO> findAll(Pageable pageable) {
        pageable = PageRequest.of(
                pageable.getPageNumber() <=0? 0 : pageable.getPageNumber() - 1,  //요청중인 페이지.
                pageable.getPageSize(),                         //확인할 목록 수
                Sort.by("lectureCode").descending()      //정렬 설정
        );
        Page<Lecture> lectureList = lectureRepository.findAll(pageable);
        return lectureList.map(lecture -> modelMapper.map(lecture, LectureDTO.class));
    }

    public List<TeacherDTO> findAllTeacher() {
        List<Teacher> teacherList = teacherRepository.findAll();
        return teacherList.stream().map(teacher->modelMapper.map(teacher, TeacherDTO.class)).toList();
    }

    public List<LectureDTO> findLectureByTeacher(int teacherCode) {
        List<Lecture> lectureList = lectureRepository.findByTeacherCode(teacherCode);
        return lectureList.stream().map(lecture -> modelMapper.map(lecture, LectureDTO.class)).toList();
    }

    public List<TeacherDTO> findTeacherByStatus() {
        List<Teacher> teacherList = teacherRepository.findTeacherByStatus();
        return teacherList.stream().map(teacher -> modelMapper.map(teacher, TeacherDTO.class)).toList();
    }
    @Transactional
    public void registLecture(LectureDTO newLecture) {
        lectureRepository.save(modelMapper.map(newLecture, Lecture.class));
    }
    @Transactional
    public void modifyStatus(TeacherDTO teacher) {
        Teacher foundTeacher = teacherRepository.findById(teacher.getTeacherCode()).orElseThrow();
        foundTeacher.modifyStatus(teacher.getStatus());
    }
    @Transactional
    public void deleteById(int lectureCode) {
        lectureRepository.deleteById(lectureCode);
    }
}
