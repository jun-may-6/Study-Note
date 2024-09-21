package com.ohgiraffers.handlermethod;


import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

@Controller
@RequestMapping("/first/*")
@SessionAttributes("id")
/* 이렇게 저장된 세션은 invalidate 로 삭제가 불가능하다.
 * SessionAttributes 로 등록된 값은 session 의 상태를 관리하는
 * SessionStatus 의 setComplete() 메소드를 호출해야 사용이 만료된다.
 * 여러개를 사용할 경우 중괄호로 묶어 사용한다. */
public class FirstController {
    @GetMapping("regist")
    public void regist(){   // 반환값이 없을 경우 요청 주소는 view 의 이름이 된다(/first/regist)

    }


    @PostMapping
    public String registMenu(Model model, WebRequest request){

        String name = request.getParameter("name");
        int price = Integer.parseInt(request.getParameter("price"));
        int categoryCode = Integer.parseInt(request.getParameter("categoryCode"));

        String message = name + "을(를) 신규 목록 메뉴의 " + categoryCode + "번 카테고리에 " + price + "원으로 등록 하셨습니다!";

        model.addAttribute("message", message);

        return "first/messagePrinter";
    }
    @GetMapping("modify")
    public void modify(){}



    /* @RequestParam
    * @RequestParam 타입 변수명  을 통하여 파라미터를 넘겨받을 수 있다.
    * name 속성값을 명시하여 다른 변수명을 사용할 수 있고, 같은 변수명을 사용할 경우 어노테이션 자체를 생략할 수 있다. (권장X)
    * defaultValue 를 설정하여 공백일 경우 적용할 파라미터를 설정할 수 있다.
    * */
    @PostMapping("modify")
    public String modifyMenuPrice(Model model, @RequestParam String modifyName,
                                  @RequestParam(value = "modifyPrice", defaultValue = "0") int price){
        String message = modifyName + " 메뉴의 가격을 " + price + "원으로 변경하였습니다.";

        model.addAttribute("message", message);

        return "first/messagePrinter";
    }

    /* 파라미터가 여러개 인 경우 맵을 사용하여 한번에 처리할 수 있다.
    * 맵의 키는 form 의 name 속성값이 된다.*/
    @PostMapping("modifyAll")
    public String modifyMenu(Model model, @RequestParam Map<String ,String > parameters){
        String modifyName = parameters.get("modifyName2");      // 키값은 name 속성값
        int price = Integer.parseInt(parameters.get("modifyPrice2"));

        String message = modifyName + " 메뉴의 가격을 " + price + "원으로 변경하였습니다.";

        model.addAttribute("message", message);

        return "first/messagePrinter";
    }

    @GetMapping("search")
    public void search(){}

    /* @ModelAttribute
    * DTO 같은 모델을 커맨드 객체를 생성하여 매개변수로 전달해 준 뒤 해당 인스턴스를 model 에 담는다.
    * 경우에 따라 폼에서 입력한 값을 당므 화면으로 바로 전달해야 하는 경우 유용하게 사용할 수 있다.
    *
    * @ModelAttribute("모델 KEY") 를 지정할 수 있다. 지정하지 않을 경우 타입의 앞글자로 소문자로 하여 지정된다.*/
    @PostMapping("search")
    public String searchMenu(@ModelAttribute("menu") MenuDTO menu){
        System.out.println(menu);
        return "first/searchResult";
    }

    @GetMapping("login")
    public void login(){}

    /* HttpSession 을 매개변수로 선언하면 핸들러 메소드 호출 시 세션 객체를 넣어서 호출한다. */
    @PostMapping("login1")
    public String sessionTest1(HttpSession session, @RequestParam String id){
        session.setAttribute("id", id);
        return "first/loginResult";
    }

    /* HttpSession 을 매개변수로 선언하면 핸들러 메소드 호출 시 세션 객체를 넣어서 호출한다. */
    @PostMapping("login2")
    public String sessionTest2(Model model, @RequestParam String id){
        model.addAttribute("id", id);       // 세션에 자동으로 등록된다.
        return "first/loginResult";
    }

    @GetMapping("logout1")
    public String logoutTest1(HttpSession session){

        session.invalidate();
        return "first/loginResult";
    }

    /* SessionAttributes 로 등록된 값은 session 의 상태를 관리하는
    * SessionStatus 의 setComplete() 메소드를 호출해야 사용이 만료된다.*/
    @GetMapping("logout2")
    public String logoutTest2(SessionStatus sessionStatus){
        sessionStatus.setComplete();
        return "first/loginResult";
    }
}
