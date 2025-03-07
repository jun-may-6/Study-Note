package com.ohgiraffers.restapi.section01.response;

import lombok.*;

@Setter
@Getter
@ToString
@AllArgsConstructor
public class Message {
    private int httpStatusCode;
    private String message;
}
