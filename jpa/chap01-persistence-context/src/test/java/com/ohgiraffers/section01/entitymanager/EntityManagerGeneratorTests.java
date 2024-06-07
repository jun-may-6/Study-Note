package com.ohgiraffers.section01.entitymanager;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EntityManagerGeneratorTests {
    @Test
    @DisplayName("엔티티 매니저 팩토리 생성 확인")   // 한글로 설정
    void testGenerateEntityManagerFactory(){    // 테스트용, 반환값 없이 진행

        // 테스트코드는 보통 given/when/then 으로 나누어 진행
        // 해당 경우엔 given 없으므로 when/then 작성

        // when
        EntityManagerFactory factory = EntityManagerFactoryGenerator.getInstance();
        // 팩토리를 생성했을 때

        // then
        assertNotNull(factory);
        // null 이 아닌지 테스트
    }
    @Test
    @DisplayName("엔티티 매니저 팩토리 싱글톤 인스턴스 확인")
    void testIsEntityManagerFactorySingletonInstance(){
        // when
        EntityManagerFactory factory1 = EntityManagerFactoryGenerator.getInstance();
        EntityManagerFactory factory2 = EntityManagerFactoryGenerator.getInstance();
        // 팩토리 두 개를 생성했을 때

        // then
        assertEquals(factory1, factory2);
        // 인스턴스 두 개가 같은지 테스트
    }
    @Test
    @DisplayName("엔티티 매니저 생성 확인")
    void testGenerateEntityManager(){
        //given
        //when
        EntityManager entityManager = EntityManagerGenerator.getInstance();
        //then
        assertNotNull(entityManager);
    }

    @Test
    @DisplayName("엔티티 매니저 스코프 확인")
    void testEntityManagerLifeCycle(){
        //given
        //when
        EntityManager entityManager1 = EntityManagerGenerator.getInstance();
        EntityManager entityManager2 = EntityManagerGenerator.getInstance();
        //then
        assertNotEquals(entityManager1, entityManager2);
    }
}
