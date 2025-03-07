package com.ohgiraffers.common;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class JDBCTemplate {

    public static Connection getConnection(){
        Connection con = null;
        Properties prop = new Properties();

        try {
            /* 파일 리더 객체와 로드 메소드를 사용하여 정보 읽어오기 */
            prop.load(new FileReader("src/main/java/com/ohgiraffers/config/connection-info.properties"));
            /* getProperty 를 사용하여 driver, url 정보 가져오기 */
            String driver = prop.getProperty("driver");
            String url = prop.getProperty("url");

            Class.forName(driver);

            con = DriverManager.getConnection(url, prop);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }
    public static void close(Connection con){
        try {
            if(con!=null && !con.isClosed()){
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void close(Statement stmt){
        try {
            if(stmt!=null && !stmt.isClosed()){
                stmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void close(ResultSet rset){
        try {
            if(rset!=null && !rset.isClosed()){
                rset.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
