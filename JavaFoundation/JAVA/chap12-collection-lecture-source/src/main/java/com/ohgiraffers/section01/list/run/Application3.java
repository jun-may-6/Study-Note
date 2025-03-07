package com.ohgiraffers.section01.list.run;

import java.util.LinkedList;
import java.util.List;

public class Application3 {
    public static void main(String[] args) {

        /* [ LinkedList ]
        * ArrayList가 배열을 이용해서 발생할 수 있는 성능적인 단점을 보완하고자 고안되었다.
        * 내부는 이중 연결리스트로 구현되어 있다.
        *
        * 단일 연결 리스트
        * 저장한 요소가 순서를 유지하지 않고 저장되지만 이러한 요소들 사이를 링크로 연결하여
        * 구성하며, 마치 연결된 리스트 형태인 것 처럼 만든 자료구조이다.
        * 요소의 저장과 삭제 시 다음 요소를 가리키는 참조 링크만 변경하면 되기 때문에
        * 요소의 저장과 삭제가 빈번히 일어나는 경우 ArrayList보다 성능면에서 우수하다.
        * 하지만 단일 연결 리스트는 다음 요소만 링크하기 때문에 이전 요소로 접근하기가 어렵다.
        * 이를 보완하고자 만든것이 이중 연결 리스트이다.
        *
        * 이중 연결 리스트
        * 단일 연결 리스트는 다음 요소만 링크하는 반면 이중 연결 리스트는 이전 요소도 링크하여
        * 이전 요소로 접근하기 쉽게 고안된 자료구조이다.
        * */

        List<String> linkdeList = new LinkedList<>();

        linkdeList.add("apple");
        linkdeList.add("banana");
        linkdeList.add("orange");
        linkdeList.add("mango");
        linkdeList.add("grape");

        System.out.println(linkdeList.size());

        for(int i = 0; i < linkdeList.size(); i++) {
            System.out.println(i + " : " +linkdeList.get(i));
        }

        linkdeList.remove(1);

        for(String s : linkdeList) {
            System.out.println(s);
        }

        linkdeList.set(0, "pineapple");

        System.out.println(linkdeList);

        System.out.println(linkdeList.isEmpty());

        linkdeList.clear();

        System.out.println(linkdeList.isEmpty());
    }
}
