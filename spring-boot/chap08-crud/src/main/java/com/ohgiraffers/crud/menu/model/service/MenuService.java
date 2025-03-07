package com.ohgiraffers.crud.menu.model.service;

import com.ohgiraffers.crud.menu.model.dao.MenuMapper;
import com.ohgiraffers.crud.menu.model.dto.CategoryDTO;
import com.ohgiraffers.crud.menu.model.dto.MenuDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MenuService {
    private final MenuMapper menuMapper;

    public MenuService(MenuMapper menuMapper) {
        this.menuMapper = menuMapper;
    }

    public List<MenuDTO> findAllMenu() {
        return menuMapper.findAllMenu();
    }

    public List<CategoryDTO> findCategoryList() {
        return menuMapper.findCategoryList();
    }
    @Transactional      // 쿼리문이 잘 실행되었을 경우 커밋, 아닐 경우 롤백해주는 어노테이션
    public void registMenu(MenuDTO menu) {
        menuMapper.registMenu(menu);
    }
}
