package com.ohgiraffers.springbootjpa.menu.repository;

import com.ohgiraffers.springbootjpa.menu.entity.Menu;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/* <Entity, IdType> 설정 */
public interface MenuRepository extends JpaRepository<Menu, Integer>{
    List<Menu> findByMenuPriceGreaterThan(Integer menuPrice);   // 문법에 맞춰 작성하면 SQL 자동 생성
    List<Menu> findByMenuPriceGreaterThanOrderByMenuPrice(Integer menuPrice);   // 자동 정렬
    List<Menu> findByMenuPriceGreaterThan(Integer menuPrice, Sort sort);   // 정렬 기준 제시
}
