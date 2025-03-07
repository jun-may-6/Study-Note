package com.ohgiraffers.springbootjpa.menu.service;

import com.ohgiraffers.springbootjpa.menu.dto.CategoryDTO;
import com.ohgiraffers.springbootjpa.menu.dto.MenuDTO;
import com.ohgiraffers.springbootjpa.menu.entity.Category;
import com.ohgiraffers.springbootjpa.menu.entity.Menu;
import com.ohgiraffers.springbootjpa.menu.repository.CategoryRepository;
import com.ohgiraffers.springbootjpa.menu.repository.MenuRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.data.domain.Pageable.ofSize;

@Service
@RequiredArgsConstructor    //생성자 의존성 주입
public class MenuService {
    private final MenuRepository menuRepository;
    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;      // DTO <-> Entity 매핑


    /* 1. findById */
    public MenuDTO findMenuByMenuCode(int menuCode) {
        /* id 조회시 값이 있을 경우 foundMenu 반환, 없을 경우 오류 발생시키기. */
        Menu foundMenu = menuRepository.findById(menuCode).orElseThrow(IllegalArgumentException::new);
        return modelMapper.map(foundMenu, MenuDTO.class);
    }
    /* 2. findAll : sort */
    public List<MenuDTO> findMenuList() {
        List<Menu> menuList = menuRepository.findAll(Sort.by("menuCode").descending()); //메뉴코드 역순 정렬
        return menuList
                .stream()   // stream 형변환
                .map(menu->modelMapper.map(menu, MenuDTO.class))    //내용물 가공
                .toList();  // 다시 List 형변환
    }

    /* 3. findAll : Pageable */
    public Page<MenuDTO> findMenuList(Pageable pageable) {
        pageable = PageRequest.of(
                pageable.getPageNumber() <=0? 0 : pageable.getPageNumber() - 1,  //요청중인 페이지.
                pageable.getPageSize(),                         //확인할 목록 수
                Sort.by("menuCode").descending()      //정렬 설정
        );
        Page<Menu> menuList = menuRepository.findAll(pageable);
        return menuList.map(menu -> modelMapper.map(menu, MenuDTO.class));  // 내부 자료형 하나씩 변경
    }

    /* 4. Query Method */
    public List<MenuDTO> findByMenuPrice(Integer menuPrice) {
//        List<Menu> menuList = menuRepository.findByMenuPriceGreaterThan(menuPrice);   //기본적인 쿼리 메소드 사용법
//        List<Menu> menuList = menuRepository.findByMenuPriceGreaterThanOrderByMenuPrice(menuPrice);   //자동 정렬
        List<Menu> menuList = menuRepository.findByMenuPriceGreaterThan(menuPrice, Sort.by("menuPrice").descending());  //정렬 기준 제시
        return menuList
                .stream()   // stream 형변환
                .map(menu->modelMapper.map(menu, MenuDTO.class))    //내용물 가공
                .toList();  // 다시 List 형변환
    }

    /**
     * 문서화 주석 대상의 요약 설명이다.
     *
     * @param a - ~~ 문자열
     * @param b - ~~ 문자열
     * @return a와 b를 더한 문자열
     * @throws 어떤 상황에서 예외가 발생!
     */
    public String doSomething(String a, String b) {
        return a + b;
    }

    /* 5. JPQL or Native Query */
    public List<CategoryDTO> findAllCategory() {
        List<Category> categoryList = categoryRepository.findAllCategory();
        return categoryList
                .stream()   // stream 형변환
                .map(category->modelMapper.map(category, CategoryDTO.class))    //내용물 가공
                .toList();  // 다시 List 형변환
    }

    /* 6. Save */
    @Transactional
    public void registMenu(MenuDTO menuDTO) {
        menuRepository.save(modelMapper.map(menuDTO, Menu.class));
    }

    /* 7. Modify */
    @Transactional
    public void modifyMenu(MenuDTO menuDTO) {
        Menu foundMenu = menuRepository.findById(menuDTO.getMenuCode()).orElseThrow(IllegalArgumentException::new);
        foundMenu.modifyMenuName(menuDTO.getMenuName());
    }

    /* 8. Delete  */
    @Transactional
    public void deleteMenu(Integer menuCode) {
        menuRepository.deleteById(menuCode);

    }
}