package com.jayden.member.service;

import com.jayden.member.dao.Member;
import com.jayden.member.mapper.MemberMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: MemberService
 * @Author: 梁金德 Jayden
 * @Date: 2024-04-11 3:12
 * @Version: V1.0
 */
@Service
public class MemberService {
    @Resource
    private MemberMapper memberMapper;

    public int count() {
        List<Member> members = memberMapper.selectList(null);
        return members.size();
    }
}
