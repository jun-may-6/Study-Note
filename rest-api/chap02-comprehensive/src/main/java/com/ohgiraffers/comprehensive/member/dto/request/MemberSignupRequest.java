package com.ohgiraffers.comprehensive.member.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class MemberSignupRequest {

    @NotBlank
    private final String memberId;
    @NotBlank
    private final String memberPassword;
    @NotBlank
    private final String memberName;
    private final String memberEmail;
}
