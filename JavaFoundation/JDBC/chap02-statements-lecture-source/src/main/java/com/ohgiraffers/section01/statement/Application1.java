package com.ohgiraffers.section01.statement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class Application1 {
    public static void main(String[] args) {

        Connection con = getConnection();
        Statement stmt = null;      //쿼리를 운반하고 결과를 반환하는 객체
        ResultSet rset = null;      //조회의 결과가 반환되는 객체 SELECT 결과집합을 받아 올 용도의 인터페이스

        try {
            stmt = con.createStatement();       //connection 을 이용한 statement 인스턴스 생성
            rset = stmt.executeQuery("SELECT EMP_ID, EMP_NAME FROM EMPLOYEE");  //statement 의 e.c 메소드를 사용하여 rest에 담기

            while(rset.next()){
                /* next() : ResultSet 의 커서 위치를 내리면서 행이 존재하면 true 아니면 false 리턴 */
                System.out.println(rset.getString("EMP_ID") + ", " + rset.getString("EMP_NAME"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rset);
            close(stmt);
            close(con);
        }
    }
}
