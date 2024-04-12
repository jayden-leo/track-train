package com.jayden.member.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author 12633
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MemberLoginResponse {
    private Long id;

    private String mobile;

    private String token;

}