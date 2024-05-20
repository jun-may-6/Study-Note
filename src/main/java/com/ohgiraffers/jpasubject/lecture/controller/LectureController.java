package com.ohgiraffers.jpasubject.lecture.controller;

import com.ohgiraffers.jpasubject.common.Pagination;
import com.ohgiraffers.jpasubject.common.PagingButton;
import com.ohgiraffers.jpasubject.lecture.dto.LectureDTO;
import com.ohgiraffers.jpasubject.lecture.dto.TeacherDTO;
import com.ohgiraffers.jpasubject.lecture.entity.Lecture;
import com.ohgiraffers.jpasubject.lecture.service.LectureService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class LectureController {
    private final LectureService lectureService;
    @GetMapping("search")
    public String search(Model model) {
        List<LectureDTO> lectureList = lectureService.findAllLecture();
        model.addAttribute("lectureList", lectureList);
        return "search/search";
    }

    /* 강좌 코드로 조회 */
    @GetMapping("search-lecture")
    public String searchLecture(Model model, @RequestParam int lectureCode) {
        LectureDTO lecture = lectureService.findById(lectureCode);
        model.addAttribute("lecture", lecture);
        return "search/result";
    }
    /* 모든 강의 조회 */
    @GetMapping("search-all")
    public String searchALlLecture(Model model, @PageableDefault Pageable pageable){
        Page<LectureDTO> lectureList = lectureService.findAll(pageable);
        PagingButton paging = Pagination.getPagingButtonInfo(lectureList);
        model.addAttribute("lectureList", lectureList);
        model.addAttribute("paging", paging);
        return "search/resultList";
    }
    /* 강사 기준 조회 (queryMethod) */
    @GetMapping("find-by-teacher-select")
    public String selectTeacher(Model model){
        List<TeacherDTO> teacherList = lectureService.findAllTeacher();
        model.addAttribute("teacherList", teacherList);
        return "search/findByTeacher";
    }
    @GetMapping("find-by-teacher")
    public String searchLectureByTeacher(Model model, @RequestParam int teacherCode){
        List<LectureDTO> lectureList = lectureService.findLectureByTeacher(teacherCode);
        model.addAttribute("lectureList", lectureList);
        return "search/resultListNonPaging";
    }
    /* 퇴사하지 않은 강사 조회 (jpql)*/
    @GetMapping("find-by-status")
    public String searchTeacherByStatus(Model model){
        List<TeacherDTO> teacherList = lectureService.findTeacherByStatus();
        model.addAttribute("teacherList", teacherList);
        return "search/teacherList";
    }
    /* 새로운 강의 등록 (save) */
    @GetMapping("regist")
    public void regist(Model model){
        List<TeacherDTO> teacherList = lectureService.findAllTeacher();
        model.addAttribute("teacherList", teacherList);
    }
    @PostMapping("regist")
    public String registLecture(Model model, LectureDTO newLecture){
        lectureService.registLecture(newLecture);
        return "redirect:/search-all";
    }
    /* 강사 정보 수정 (modify) */
    @GetMapping("modify")
    public void modify(Model model){
        List<TeacherDTO> teacherList = lectureService.findAllTeacher();
        model.addAttribute("teacherList", teacherList);
    }
    @PostMapping("modify")
    public String modifyStatus(Model model, TeacherDTO teacher){
        lectureService.modifyStatus(teacher);
        List<TeacherDTO> teacherList = lectureService.findAllTeacher();
        model.addAttribute("teacherList", teacherList);
        return "search/teacherList";
    }
    /* 강의 삭제 (delete) */
    @GetMapping("delete")
    public void delete(Model model){
        List<LectureDTO> lectureList = lectureService.findAllLecture();
        model.addAttribute("lectureList", lectureList);
    }
    @PostMapping("delete")
    public String deleteLecture(int lectureCode){
        lectureService.deleteById(lectureCode);
        return "redirect:/search-all";
    }
}
