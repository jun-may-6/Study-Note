package com.ohgiraffers.restapi.section03.valid;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class ErrorResponse {
    private String code;
    private String description;
    private String detail;
}
