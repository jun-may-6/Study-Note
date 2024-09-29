package com.ohgiraffers.section02.formdata;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@WebServlet("/formdata")
public class FormDataTestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
//        System.out.println("name : " + name);

        Map<String,String[]> requestMap = request.getParameterMap();
        Set<String> keySet = requestMap.keySet();
        Iterator<String> keyIter = keySet.iterator();
        /* Iterator & Enumeration
        * Iterator 반복자 :" 인터페이스로 자료를 얻기 위해 사용
        *       - hasNext() : 다음 데이터 있으면 true 없으면 false
        *       - next() : 자료 구조 다음 데이터 반환
        *       - remove() : 현재 조회하는 객체의 레퍼런스 삭제
        *
        * Enumeration 반복자 : Iterator 와 유사한 반복자 역할을 함
        *       - hasMoreElements() : 다음 데이터가 있으면 true 없으면 false
        *       - nextElement() : 자료 구조의 다음 데이터를 반환
        * */

        while (keyIter.hasNext()){
            String key = keyIter.next();
            String[] value = requestMap.get(key);
            System.out.print("[key : " + key + "]");
            for (int i = 0; i < value.length; i++){
                System.out.print("[value" + "[" +  i + "]] : " + value[i] + " ");
            }
            System.out.println();
        }

        Enumeration<String > names = request.getParameterNames();

        while (names.hasMoreElements()){
            String key = names.nextElement();
            String [] value = requestMap.get(key);
            for (String str : value){
                System.out.println(str);
            }
        }

    }
}
