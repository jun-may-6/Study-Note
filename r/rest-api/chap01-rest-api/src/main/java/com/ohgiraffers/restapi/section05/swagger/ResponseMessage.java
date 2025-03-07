package com.ohgiraffers.restapi.section05.swagger;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Map;
@AllArgsConstructor
@Setter
@Getter
@ToString
public class ResponseMessage {
    private int httpStatus;
    private String message;
    private Map<String, Object> results;
}
