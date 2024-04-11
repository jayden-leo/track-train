package com.jayden.member.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * @ClassName: MemberRegisterRequest
 * @Author: 梁金德 Jayden
 * @Date: 2024-04-11 10:19
 * @Version: V1.0
 */
@Data
public class MemberRegisterRequest {
    @NotBlank(message="【手机号】不能为空")
    private String mobile;
}
