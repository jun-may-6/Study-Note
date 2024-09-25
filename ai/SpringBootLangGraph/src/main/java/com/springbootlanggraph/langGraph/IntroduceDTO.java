package com.springbootlanggraph.langGraph;

import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Setter
@Getter
@ToString

public class IntroduceDTO {
    @JsonPropertyDescription("사용자의 이름")
    private String name;
    @JsonPropertyDescription("사용자의 나이")
    private int age;
    @JsonPropertyDescription("사용자의 생일")
    private LocalDate birthday;
    @JsonPropertyDescription("사용자의 주소")
    private String location;
}
