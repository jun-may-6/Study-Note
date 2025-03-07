package com.ohgiraffers.jpql.section05.groupfunction;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
public class GroupFunctionRepository {
    @PersistenceContext
    private EntityManager entityManager;
    public long countMenuOfCategory(int categoryCode){
        String jpql = "SELECT COUNT(m.menuCode) FROM Section05Menu m WHERE m.categoryCode = :categoryCode";
        long countOfMenu = entityManager.createQuery(jpql, Long.class).setParameter("categoryCode", categoryCode)
                .getSingleResult();
        return countOfMenu;
    }

    public Long otherWithNoResult(int categoryCode){    // COUNT 외의 그룹 함수는 결과값이 NULL 이 가능하기 때문에 래퍼클래스 사용
        String jpql = "SELECT SUM(m.menuPrice) FROM Section05Menu m WHERE m.categoryCode = :categoryCode";
        Long sumOfMenu = entityManager.createQuery(jpql, Long.class).setParameter("categoryCode", categoryCode)
                .getSingleResult();
        return sumOfMenu;
    }

    public List<Object[]> selectByGroupByHaving(long minPrice){
        String jpql = "SELECT m.categoryCode, SUM(m.menuPrice) FROM Section05Menu m " +
                "GROUP BY m.categoryCode HAVING SUM(m.menuPrice) > :minPrice";
        List<Object[]> sumPriceOfCategoryList = entityManager.createQuery(jpql)
                .setParameter("minPrice", minPrice).getResultList();
        return sumPriceOfCategoryList;
    }
}
