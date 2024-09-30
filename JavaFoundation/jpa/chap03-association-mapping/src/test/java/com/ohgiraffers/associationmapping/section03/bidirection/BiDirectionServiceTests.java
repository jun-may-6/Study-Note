package com.ohgiraffers.associationmapping.section03.bidirection;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class BiDirectionServiceTests {
    @Autowired
    private BiDirectionService biDirectionService;
    @DisplayName("양방향 연관 관계 매핑 조회 테스트(연관 관계의 주인)")
    @Test
    void biDirectionFindTest1(){
        //given
        int menuCode = 15;
        //when
        //진짜 연관 관계: 처음부터 조인한 결과를 인출(즉시로딩)
        Menu foundMenu = biDirectionService.findMenu(menuCode);
        //then
        assertEquals(menuCode, foundMenu.getMenuCode());
    }
    @DisplayName("양방향 연관 관계 매핑 조회 테스트(연관 관계의 주인 아님)")
    @Test
    void biDirectionFindTest2(){
        //given
        int categoryCode = 10;
        //when
        //가짜 연관 관계: 해당 엔티티만 조회한 뒤 필요할 시 로딩해옴(지연 로딩)
        Category foundCategory = biDirectionService.findCategory(categoryCode);
        //then
        assertEquals(categoryCode, foundCategory.getCategoryCode());
    }
}