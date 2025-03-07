package com.ohgiraffers.section01.xmlmapper;

import com.ohgiraffers.common.CategoryAndMenuDTO;
import com.ohgiraffers.common.MenuAndCategoryDTO;
import com.ohgiraffers.common.MenuDTO;
import com.ohgiraffers.common.Template;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class ElementTestService {

    private ElementTestMapper mapper;
    public void selectCacheTest() {
        SqlSession sqlSession = Template.getSqlSession();       //다른 패키지의 Template  참조

        mapper = sqlSession.getMapper(ElementTestMapper.class);

        for(int i = 0 ; i < 10 ; i ++){

            Long startTime = System.currentTimeMillis();

            List<String> nameList = mapper.selectCacheTest();

            Long endTime = System.currentTimeMillis();

            System.out.println(nameList);

            Long interval = endTime - startTime;
            System.out.println("수행 시간 : " + interval + "ms");
        }
        sqlSession.close();
    }
    public void selectResultMapTest() {
        SqlSession sqlSession = Template.getSqlSession();
        mapper = sqlSession.getMapper(ElementTestMapper.class);

        List<MenuDTO> menuList = mapper.selectResultMapTest();
        for(MenuDTO menu : menuList){
            System.out.println(menu);
        }
        sqlSession.close();
    }

    public void selectResultMapConstructorTest() {
        SqlSession sqlSession = Template.getSqlSession();
        mapper = sqlSession.getMapper(ElementTestMapper.class);

        List<MenuDTO> menuList = mapper.selectResultMapConstructorTest();
        for(MenuDTO menu : menuList){
            System.out.println(menu);
        }
        sqlSession.close();
    }

    public void selectResultMapAssociationTest() {
        SqlSession sqlSession = Template.getSqlSession();
        mapper = sqlSession.getMapper(ElementTestMapper.class);

        List<MenuAndCategoryDTO> menuList = mapper.selectResultMapAssociationTest();
        for (MenuAndCategoryDTO menu : menuList){
            System.out.println(menu);
        }
        sqlSession.close();
    }

    public void selectResultMapCollectionTest() {
        SqlSession sqlSession = Template.getSqlSession();
        mapper = sqlSession.getMapper(ElementTestMapper.class);

        List<CategoryAndMenuDTO> categoryList = mapper.selectResultMapCollectionTest();
        for(CategoryAndMenuDTO category : categoryList){
            System.out.println(category);
        }
        sqlSession.close();
    }

    public void selectSqlTest() {

        SqlSession sqlSession = Template.getSqlSession();
        mapper = sqlSession.getMapper(ElementTestMapper.class);
        List<MenuDTO> menuList = mapper.selectSqlTest();
        for(MenuDTO menu : menuList){
            System.out.println(menu);
        }

        sqlSession.close();
    }

    public void insertCategoryAndMenuTest(MenuAndCategoryDTO menuAndCategory) {
        SqlSession sqlSession = Template.getSqlSession();
        mapper = sqlSession.getMapper(ElementTestMapper.class);

        int result1 = mapper.insertNewCategory(menuAndCategory);
        int result2 = mapper.insertNewMenu(menuAndCategory);

        if(result1 > 0 && result2 > 0){
            System.out.println("신규 카테고리와 메뉴 등록 성공");
            sqlSession.commit();
        }else{
            System.out.println("신규 카테고리와 메뉴 등록 실패");
            sqlSession.rollback();
        }
        sqlSession.close();
    }
}
