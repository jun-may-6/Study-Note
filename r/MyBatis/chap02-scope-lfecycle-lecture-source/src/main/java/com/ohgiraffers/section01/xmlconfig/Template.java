package com.ohgiraffers.section01.xmlconfig;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class Template {

    /* SqlSessionFactory 는 애플리케이션이 실행하는 동안 존재해야 하며,
    *  여러 차례 SqlSessionFactory 를 다시 빌드하지 않는 것이 가장 좋은 형태이다.
    *  애플리케이션 스코프로 관리하기 위한 가장 간단한 방법은 싱글톤 패턴을 이용하는 것이다.
    * */

    private static SqlSessionFactory sqlSessionFactory;
    public static SqlSession getSqlSession() {
        /* SqlSessionFactoryBuilder 를 SqlSession 을 생성한 후에도 유지할 필요는 없다.
        * 따라서 메소드 스코프로 만든다.
        * 여러 개의 SqlSessionFactoryBuilder 를 빌드하기 위해 재사용할 수도 있지만 유지하지 않는 것이 가장 좋다.
        * */
        if(sqlSessionFactory == null){
            String resource = "mybatis-config.xml";
            try {
                InputStream inputStream = Resources.getResourceAsStream(resource);
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        /* SqlSession 은 Thread 에 안전하지 않고, 공유되지 않아야 하므로 요청 시마다 생성해야 한다. */
        SqlSession sqlSession = sqlSessionFactory.openSession(false);

        System.out.println(sqlSessionFactory.hashCode());
        System.out.println(sqlSession.hashCode());
        return sqlSession;
    }
}
