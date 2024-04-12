package com.jayden.member.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

/**
 * @ClassName: MemberRegisterRequest
 * @Author: 梁金德 Jayden
 * @Date: 2024-04-11 10:19
 * @Version: V1.0
 */
@Data
public class MemberLoginRequest {
    @NotBlank(message="【手机号】不能为空")
    @Pattern(regexp = "^1\\d{10}$",message = "【手机号】格式错误")
    private String mobile;

    @NotBlank(message="【短信验证码】不能为空")
    private String code;
}
