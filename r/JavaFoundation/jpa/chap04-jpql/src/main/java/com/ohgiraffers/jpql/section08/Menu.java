package com.ohgiraffers.jpql.section08;

import jakarta.persistence.*;

@Entity(name = "Section08Menu")
@Table(name = "tbl_menu")
@NamedQueries({
        @NamedQuery(name = "Section08Menu.selectMenuList",
                query = "SELECT m FROM Section08Menu m")
})
public class Menu {
    @Id
    private int menuCode;
    private String menuName;
    private int menuPrice;
    private int categoryCode;
    private String orderableStatus;



    public Menu() {}
}
