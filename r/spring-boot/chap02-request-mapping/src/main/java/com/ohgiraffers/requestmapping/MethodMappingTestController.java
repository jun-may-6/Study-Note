package com.ohgiraffers.requestmapping;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/* DispatcherServlet 은 웹 요청을 받는 즉시 @Controller 가 달린 컨트롤러 클래스에 처리를 위임한다.
* 그 과정은 컨트롤러 클래스의 핸들러 메서드에 선언된 다양한 @RequestMapping 설정 내용에 따른다.
* */
@Controller
public class MethodMappingTestController {

    @RequestMapping("/menu/regist")     // 메소드 속성을 명시하지 않을 경우 GET 과 POST 모두 반응한다.
    public String registMenu(Model model){

        /* Model 객체에  addAttribute 메소드를 이용해 key, value 를 추가하면  view 에서 사용할 수 있다.
        * view-resolver 에서 다시 다룬다. */
        model.addAttribute("message", "신규 메뉴 등록용 핸들러 메소드 호출");

        /* 반환하려는 view 의 경로를 포함한 이름 작성
        * resources/templates 하위부터의 경로 작성 */
        return "mappingResult";
    }

    @RequestMapping(value = "/menu/modify", method = RequestMethod.GET) // 메소드 속성을 명시할 경우 다른 타입이 오면 오류 발생
    public String modifyMenu(Model model){
        model.addAttribute("message", "GET 방식의 메뉴 수정용 핸들러 메소드 호출");

        return "mappingResult";
    }

    @GetMapping("/menu/delete")
    public String getDeleteMenu(Model model){
        model.addAttribute("message", "GET 방식의 삭제용 핸들러 메소드 호출");
        return "mappingResult";
    }
    @PostMapping("/menu/delete")
    public String postDeleteMenu(Model model){
        model.addAttribute("message", "POST 방식의 삭제용 핸들러 메소드 호출");
        return "mappingResult";
    }


}
