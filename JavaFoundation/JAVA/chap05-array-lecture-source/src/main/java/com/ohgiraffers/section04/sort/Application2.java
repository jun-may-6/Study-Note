package com.ohgiraffers.section04.sort;

public class Application2 {
    public static void main(String[] args) {
        /*
        * 순차정렬
        * 정렬 알고리즘에서 가장 간단하고 기본이 되는 알고리즘으로
        * 배열의 처음과 끝을 탐색하면서 차순대로 정렬하는 가장 기초적인 정렬 알고리즘이다.
        * */

        int[] arr = {2, 5, 4, 6, 1, 3};

        /* 오름차순 정렬 */
        for(int i = 0; i< arr.length; i++) {

            for(int j = i+1; j < arr.length; j++) {

                /* 부등호만 반대로 처리하면 내림차순 정렬이 됨 */
                if(arr[i] > arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
