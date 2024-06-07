package com.ohgiraffers.springbootjpa.menu.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tbl_menu")
@Getter /*Setter 메소드 지양 (안정성 보장)*/
@NoArgsConstructor(access = AccessLevel.PROTECTED)  /*기본생성자 접근 권한을 제한하는것이 안전하다.*/
//@ToString   /* 연관관계에서 오류를 발생시킬 수 있다. */
//@AllArgsConstructor /*모든 필드를 초기화하는 생성자도 지양한다.*/
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //AI
    private int menuCode;   // 카멜 <-> 언더스코어 매핑
    private String menuName;
    private int menuPrice;
    private int categoryCode;
    private String orderableStatus;

    public void modifyMenuName(String menuName) {
        this.menuName = menuName;
    }
}
