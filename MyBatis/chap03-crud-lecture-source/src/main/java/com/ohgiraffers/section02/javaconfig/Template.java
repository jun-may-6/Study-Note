package com.ohgiraffers.section02.javaconfig;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import java.io.IOException;
import java.io.InputStream;

public class Template {


    private static String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static String URL = "jdbc:mysql://localhost/menudb";
    private static String USER = "ohgiraffers";
    private static String PASSWORD = "ohgiraffers";

    private static SqlSessionFactory sqlSessionFactory;
    public static SqlSession getSqlSession(){
        if(sqlSessionFactory == null){
            Environment environment =           //환경 설정
                    new Environment("dev"
                            , new JdbcTransactionFactory()
                            , new PooledDataSource(DRIVER,URL,USER,PASSWORD));

            Configuration configuration = new Configuration(environment);       //환경으로 구성

            configuration.addMapper(MenuMapper.class);      //MenuMapper 의 메타 정보 추가

            sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);        //1. 팩토리 빌더로 팩토리 생성
        }
        return sqlSessionFactory.openSession(false);
    }
}
