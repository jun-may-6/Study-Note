package com.ohgiraffers.requestmapping;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/order/*") // Controller 어노테이션에만 달 수 있는 어노테이션으로, 상위 경로를 미리 명시할 수 있다.
public class ClassMappingTestController {

    /* Class 레벨 매핑 */
    @GetMapping("/regist")
    public String registOrder(Model model){
        model.addAttribute("message", "GET 방식의 주문 등록용 핸들러 메소드 호출");
        return "mappingResult";
    }

    @RequestMapping(value = {"modify", "delete"}, method = RequestMethod.POST)
    public String modifyAndDelete(Model model){
        model.addAttribute("message", "POST 방식의 주문 수정/삭제 핸들러 메소드 호출");
        return "mappingResult";
    }


    /* @PathVariable("변수명") 어노테이션을 통하여 인자를 가져올 수 있다.
     * 변수명을 명시하지 않을 경우 인자와 변수명은 반드시 동일해야 한다. */
    @GetMapping("/detail/{orderNo}")
    public String selectOrderDetail(Model model, @PathVariable("orderNo") int order){

        /* 데이터 타입 등의 이유로 파싱 불가능한 인자가 전달되면 400번 에러가 발생한다.
        * PathVariable 이 없으면 해당 핸들러 메소드를 찾지 못한다.
        * */
        model.addAttribute("message", order + "번 주문 상세 내용 조회용 핸들러 메소드 호출");

        return "mappingResult";
    }

    @RequestMapping // orderNo 에 아무것도 없을 경우 이곳으로 연결
    public String otherRequest(Model model){
        model.addAttribute("message", "order 요청이긴 하지만 다른 기능은 준비중");

        return "mappingResult";
    }
}
