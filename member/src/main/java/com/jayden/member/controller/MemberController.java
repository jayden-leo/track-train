package com.jayden.member.controller;

import com.jayden.member.service.MemberService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: TestController
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
    public long count(){
        return memberService.count();
    }
}
