package com.ohgiraffers.section02.crud;

import com.ohgiraffers.section02.crud.EntityManagerGenerator;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class EntityManagerCRUD {

    private EntityManager entityManager;

    /* 1. 특정 메뉴 코드로 메뉴 조회하는 기능 */
    public Menu findMenuByMenuCode(int menuCode) {
        entityManager = EntityManagerGenerator.getInstance();
        return entityManager.find(Menu.class, menuCode);    // PK 기준 조회에 사용하는 메소드
    }

    /* 2. 새로운 메뉴 저장하는 기능 */
    public Long saveAndReturnAllCount(Menu newMenu) {
        entityManager = EntityManagerGenerator.getInstance();

        EntityTransaction entityTransaction = entityManager.getTransaction();   // 엔티티 트랜젝션 반환
        entityTransaction.begin();  // 트랜젝션 시작 명시

        entityManager.persist(newMenu); // 새로운 로우 저장하는 메소드

        entityTransaction.commit(); // 트랜젝션 실행 명시

        return getCount(entityManager);
    }

    /* 3. 메뉴 개수 조회하는 기능 */
    private Long getCount(EntityManager entityManager) {
        // JPQL 문법 -> 나중에 별도의 챕터에서 다룸
        return entityManager.createQuery("SELECT COUNT(*) FROM Section02Menu", Long.class).getSingleResult();
    }

    /* 4. 메뉴 이름 수정하는 기능 */
    public Menu modifyMenuName(int menuCode, String menuName) {
        entityManager = EntityManagerGenerator.getInstance();       // 인스턴스 불러오기
        Menu foundMenu = entityManager.find(Menu.class, menuCode);  // 메뉴 코드에 맞는 정보 불러오기

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        foundMenu.setMenuName(menuName);    // persistence context 안의 정보를 수정하고

        transaction.commit();               // 수정된 정보 커밋하기

        return foundMenu;
    }

    /* 5. 특정 메뉴 코드로 메뉴 삭제하는 기능 */
    public Long removeAndReturnAllCount(int menuCode) {
        entityManager = EntityManagerGenerator.getInstance();       // 매니저 활성화
        Menu foundMenu = entityManager.find(Menu.class, menuCode);  // 메뉴 코드에 맞는 정보 불러오기

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();                                        //트랜젝션 시작

        entityManager.remove(foundMenu);

        transaction.commit();                                       //트랜젝션 커밋

        return getCount(entityManager);
    }
}
