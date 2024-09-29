package com.ohgiraffers.section01.contextListener;

import jakarta.servlet.ServletContextAttributeEvent;
import jakarta.servlet.ServletContextAttributeListener;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.annotation.WebServlet;

@WebListener
public class ContextListenerTest implements ServletContextListener, ServletContextAttributeListener {


    /*
    * 1. context(-> 톰캣 컨테이너 자체에 리스너 연결)
    *   1. ServletContextListener : 웹 애플리케이션의 시작/종료에 대한 이벤트 리스너
    *   2. ServletContextAttributeListener : context 에 attribute 추가/수정/삭제에 대한 이벤트 리스너*/
    public ContextListenerTest() {
        System.out.println("context listener 인스턴스 생성");
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContextListener.super.contextInitialized(sce);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContextListener.super.contextDestroyed(sce);
    }

}
