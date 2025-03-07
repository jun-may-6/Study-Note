package com.ohgiraffers.section01.entitymanager;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class EntityManagerGenerator {
    public static EntityManager getInstance(){  // 싱글톤 팩토리로 매니저 생성
        EntityManagerFactory factory = EntityManagerFactoryGenerator.getInstance();
        return factory.createEntityManager();
    }
}
