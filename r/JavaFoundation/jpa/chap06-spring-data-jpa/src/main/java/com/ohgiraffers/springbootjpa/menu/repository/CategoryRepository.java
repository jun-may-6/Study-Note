package com.ohgiraffers.springbootjpa.menu.repository;

import com.ohgiraffers.springbootjpa.menu.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.lang.annotation.Native;
import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    /* JPQL 설정 테스트 */
//    @Query("SELECT c FROM Category c ORDER BY c.categoryCode")  //메소드 동작시 해당 쿼리 실행
    @Query(value = "SELECT category_code, category_name, ref_category_code FROM tbl_category ORDER BY category_code",
    nativeQuery = true)  //네이티브 쿼리 명시
    List<Category> findAllCategory();
}
