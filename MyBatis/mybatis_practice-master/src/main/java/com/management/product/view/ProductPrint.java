package com.management.product.view;

import com.common.SearchCondition;
import com.management.product.model.dto.ProductDTO;

import java.util.List;

public class ProductPrint {

    // * 모든 출력은 System.out.println()을 통해 콘솔에 출력하는 것을 의미합니다.
    // 주석을 지우고 다음 네 가지 메소드를 작성하세요.

    public void printAllProductList(List<ProductDTO> allProductList) {

        if(allProductList != null && allProductList.size() > 0){
            for(ProductDTO product : allProductList){
                System.out.println(product);
            }
        }
        // 1. 전체 조회한 목록 출력하는 메소드
        //    (조건) List<ProductDTO>로 받아온 데이터 목록을 전체 출력하세요.

    }

    public void printProductList(List<ProductDTO> productList, SearchCondition searchCondition) {
        System.out.println("검색 조건 : " + searchCondition.getOption());
        for(ProductDTO product : productList){
            System.out.println(product);
        }
        // 2. 조건에 따라 조회한 목록을 출력하는 메소드
        //    (조건 1) SearchCondition 객체로 검색 조건이 무엇인지 출력하세요.
        //    (조건 2) List<ProductDTO>로 받아온 데이터 목록을 전체 출력하세요.

    }

    public void printSuccessMessage(String successCode) {
        switch (successCode){
            case "selectProductByCondition" :
                System.out.println("검색에 성공하였습니다.");break;
            case "registNewProduct" :
                System.out.println("신규 상품 등록에 성공하였습니다."); break;
        }

        // 3. 성공메시지를 출력하는 메소드
        //    (조건) 성공코드를 전달받아 성공을 알리는 메시지를 출력하세요.

    }

    public void printErrorMessage(String errorCode) {
        switch (errorCode){
            case "selectProductByCondition" :
                System.out.println("검색 결과가 없습니다.");break;
            case "registNewProduct" :
                System.out.println("신규 상품 등록에 실패하였습니다."); break;
        }
        // 4. 에러메시지를 출력하는 메소드
        //    (조건) 에러코드를 전달받아 에러를 알리는 메시지를 출력하세요.

    }

}
