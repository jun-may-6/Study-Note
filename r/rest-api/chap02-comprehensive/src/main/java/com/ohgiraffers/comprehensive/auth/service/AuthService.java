package com.ohgiraffers.comprehensive.auth.service;

import com.ohgiraffers.comprehensive.auth.dto.LoginDto;
import com.ohgiraffers.comprehensive.auth.dto.TokenDto;
import com.ohgiraffers.comprehensive.auth.type.CustomUser;
import com.ohgiraffers.comprehensive.auth.util.TokenUtils;
import com.ohgiraffers.comprehensive.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class AuthService implements UserDetailsService {

    private final MemberService memberService;

    @Override
    public UserDetails loadUserByUsername(String memberId) throws UsernameNotFoundException {

        LoginDto loginDto = memberService.findByMemberId(memberId);

        return User.builder()
                .username(loginDto.getMemberId())
                .password(loginDto.getMemberPassword())
                .roles(loginDto.getMemberRole().name())
                .build();
    }

    public void updateRefreshToken(String memberId, String refreshToken) {
        memberService.updateRefreshToken(memberId, refreshToken);
    }

    public TokenDto checkRefreshTokenAndReIssueToken(String refreshToken) {

        LoginDto loginDto = memberService.findByRefreshToken(refreshToken);
        String reIssuedRefreshToken = TokenUtils.createRefreshToken();
        String reIssuedAccessToken = TokenUtils.createAccessToken(getMemberInfo(loginDto));
        memberService.updateRefreshToken(loginDto.getMemberId(), reIssuedRefreshToken);
        return TokenDto.of(reIssuedAccessToken, reIssuedRefreshToken);
    }

    private Map<String,Object> getMemberInfo(LoginDto loginDto) {
        return Map.of(
                "memberId", loginDto.getMemberId(),
                "memberRole", "ROLE_" + loginDto.getMemberRole()
        );
    }

    public void saveAuthentication(String memberId) {

        LoginDto loginDto = memberService.findByMemberId(memberId);

        UserDetails user = User.builder()
            .username(loginDto.getMemberId())
            .password(loginDto.getMemberPassword())
            .roles(loginDto.getMemberRole().name())
            .build();

        CustomUser customUser = new CustomUser(loginDto.getMemberCode(), user);

        Authentication authentication
                = new UsernamePasswordAuthenticationToken(customUser, null, customUser.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }








}
