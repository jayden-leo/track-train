package com.jayden.member.controller;

import com.jayden.common.response.CommonResponse;
import com.jayden.member.request.MemberLoginRequest;
import com.jayden.member.request.MemberRegisterRequest;
import com.jayden.member.request.MemberSendCodeRequest;
import com.jayden.member.response.MemberLoginResponse;
import com.jayden.member.service.MemberService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName: MemberController
 * @Author: 梁金德 Jayden
 * @Date: 2024-04-10 13:56
 * @Version: V1.0
 */
@RestController
@RequestMapping("/member")
public class MemberController {
    @Resource
    private MemberService memberService;

    @GetMapping("/count")
    public CommonResponse<Long> count(){
        return memberService.count();
    }

    @PostMapping("/register")
    public CommonResponse<Long> register(@Valid MemberRegisterRequest memberRegisterRequest){
        return memberService.register(memberRegisterRequest);
    }

    @PostMapping("/send-code")
    public CommonResponse<Long> sendCode(@Valid @RequestBody MemberSendCodeRequest memberSendCodeRequest){
        memberService.sendCode(memberSendCodeRequest);
        return new CommonResponse<>(); 
    }

    @PostMapping("/login")
    public CommonResponse<MemberLoginResponse> login(@Valid @RequestBody MemberLoginRequest memberLoginRequest){
        MemberLoginResponse memberLoginResponse = memberService.login(memberLoginRequest);
        return new CommonResponse<>(memberLoginResponse);
    }
}
