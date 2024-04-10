package com.jayden.track_tix.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: TestController
 * @Author: 梁金德 Jayden
 * @Date: 2024-04-10 13:56
 * @Version: V1.0
 */
@RestController
public class TestController {
    @GetMapping("/test")
    public String hello(){
        return "hello track_tix";
    }
}
