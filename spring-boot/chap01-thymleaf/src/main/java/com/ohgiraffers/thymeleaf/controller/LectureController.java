package com.ohgiraffers.thymeleaf.controller;

import com.ohgiraffers.thymeleaf.model.dto.MemberDTO;
import com.ohgiraffers.thymeleaf.model.dto.SelectCriteria;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("lecture")
public class LectureController {

    @GetMapping("expression")
    public ModelAndView expression(ModelAndView mv){
        mv.setViewName("/lecture/expression");

        mv.addObject("member", new MemberDTO("판다", 20, '여', "서울시 종로구"));
        mv.addObject("hello", "<h3>hello Thymeleaf!</h3>");

        return mv;
    }
    @GetMapping("conditional")
    public ModelAndView conditional(ModelAndView mv){
        mv.setViewName("/lecture/conditional");

        List<MemberDTO> memberList = new ArrayList<>();
        memberList.add(new MemberDTO("판다", 20, '여', "서울시 종로구 8강"));
        memberList.add(new MemberDTO("다람쥐", 900, '무', "종로구 10강"));
        memberList.add(new MemberDTO("양", 300, '여', "하이미디어 15층"));
        memberList.add(new MemberDTO("뱀", 100, '여', "서울시 종로구 1강"));

        mv.addObject("num", 328);
        mv.addObject("str", "바나나");
        mv.addObject("memberList", memberList);

        return mv;
    }
    @GetMapping("etc")
    public ModelAndView etc(ModelAndView mv){
        mv.setViewName("/lecture/etc");

        SelectCriteria selectCriteria = new SelectCriteria(1, 10, 7);

        mv.addObject(selectCriteria);   // 이름을 정하지 않을 경우 인스턴스 이름으로 호출 가능

        return mv;
    }

    @GetMapping("fragment")
    public ModelAndView fragment(ModelAndView mv){
        mv.setViewName("/lecture/fragment");

        mv.addObject("test1", "value1");
        mv.addObject("test2", "value2");

        return mv;
    }
}
