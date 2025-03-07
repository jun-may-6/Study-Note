package com.ohigraffers.practice.post.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "새로운 포스트 등록")
/* Swagger 문서화 시 설명 어노테이션 작성 */
public class PostCreateRequest {

    /* Swagger 문서화 시 설명 어노테이션 작성 */
    /* 필수 값이므로 유효성 검사 어노테이션 작성 */
    @Schema(description = "제목")
    @NotNull(message = "필수 입력 사항입니다.")
    private String title;

    /* Swagger 문서화 시 설명 어노테이션 작성 */
    /* 필수 값이므로 유효성 검사 어노테이션 작성 */
    @Schema(description = "내용")
    @NotNull(message = "필수 입력 사항입니다.")
    private String content;

    /* Swagger 문서화 시 설명 어노테이션 작성 */
    /* 필수 값이므로 유효성 검사 어노테이션 작성 */
    @Schema(description = "작성자")
    @NotNull(message = "필수 입력 사항입니다.")
    private String writer;

}

