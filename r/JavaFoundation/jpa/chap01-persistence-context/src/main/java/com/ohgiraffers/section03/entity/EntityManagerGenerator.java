package com.ohgiraffers.section03.entity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerGenerator {

    private static EntityManagerFactory factory
            = Persistence.createEntityManagerFactory("jpatest");

    public static EntityManager getInstance(){  // 싱글톤 팩토리로 매니저 생성
        return factory.createEntityManager();
    }

    private EntityManagerGenerator(){}
}


