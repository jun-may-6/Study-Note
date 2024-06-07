package com.ohgiraffers.exceptionhandler;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/* @ControllerAdvice 어노테이션이 적용 된 클래스의 @ExceptionHandler 는 전역적으로 기능한다. */
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NullPointerException.class)
    public String nullPointExceptionHandler(NullPointerException exception){

        System.out.println("message : " + exception.getMessage());
        System.out.println("global 레벨의 exception 처리");

        return "error/nullPointer";
    }
    @ExceptionHandler(MemberRegistException.class)
    public String userExceptionHandler(MemberRegistException exception, Model model){
        model.addAttribute("exception", exception);
        System.out.println("global 레벨의 exception 처리");
        return "error/memberRegist";
    }



    /* 상위 타입의 Exception 을 통해 Handler 를 작성하면 하위 타입의 모든 Exception 을 처리할 수 있다. */
    @ExceptionHandler(Exception.class)
    public String defaultException(Exception e){


        return "error/default";
    }
}
