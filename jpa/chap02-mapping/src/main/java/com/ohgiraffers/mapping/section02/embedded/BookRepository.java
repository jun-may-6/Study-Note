package com.ohgiraffers.mapping.section02.embedded;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {
    @PersistenceContext     //EM을 빈으로 주입하는 어노테이션
    private EntityManager entityManager;


    public void save(Book book) {
        entityManager.persist(book);
    }
}