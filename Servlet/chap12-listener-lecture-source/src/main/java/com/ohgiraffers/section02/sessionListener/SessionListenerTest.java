package com.ohgiraffers.section02.sessionListener;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionAttributeListener;
import jakarta.servlet.http.HttpSessionBindingEvent;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;
@WebListener
public class SessionListenerTest implements HttpSessionListener, HttpSessionAttributeListener {
    public SessionListenerTest() {
        System.out.println("session listener 인스턴스 생성");
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("session 생성");
        System.out.println("생성된 session id : " + se.getSession().getId());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("session 제거");
    }


    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        System.out.println("session attribute 추가");
        System.out.println("추가된 attribute : " + event.getName() + ", " + event.getValue());
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        System.out.println("session attribute 삭제");
        System.out.println("삭제된 attribute : " + event.getName() + ", " + event.getValue());
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {
        System.out.println("session attribute 수정");
        System.out.println("수정된 attribute : " + event.getName() + ", " + event.getValue());
    }

}
