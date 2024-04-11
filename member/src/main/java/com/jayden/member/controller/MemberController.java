package com.jayden.member.controller;

import com.jayden.common.response.CommonResponse;
import com.jayden.member.request.MemberRegisterRequest;
import com.jayden.member.service.MemberService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
