package com.ohgiraffers.chap00autoconfiguration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@Configuration
public class SpringConfiguration {
    @Value("${test.value}")
    public String value;

    @Value("${test.list}")
//    public List<String> list;
    public String[] list;

    @Value("${test.greeting}")
    public String greeting;

    @Value("${test.array}")
    public Set<String> array;

    @Value("${username}")
    public String name;


    @Bean
    public Object propertyReadTest(){
        System.out.println("value : " + value);
        for (String a : list){
            System.out.println(a);
        }
        System.out.println(greeting);

        Iterator<String> iter = array.iterator();
        while (iter.hasNext()){
            System.out.println(iter.next());
        }

        System.out.println("username : " + name);

        return new Object();
    }
}
