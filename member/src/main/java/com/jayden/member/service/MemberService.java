package com.jayden.member.service;

import cn.hutool.core.collection.CollUtil;
import com.jayden.common.response.CommonResponse;
import com.jayden.member.dao.Member;
import com.jayden.member.dao.MemberExample;
import com.jayden.member.mapper.MemberMapper;
import com.jayden.member.request.MemberRegisterRequest;
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

    public CommonResponse<Long> count() {
        long count = memberMapper.countByExample(null);
        CommonResponse<Long> commonResponse = new CommonResponse<>();
        commonResponse.setContent(count);
        return commonResponse;
    }

    public CommonResponse<Long> register(MemberRegisterRequest memberRegisterRequest){
        String mobile = memberRegisterRequest.getMobile();
        MemberExample memberExample = new MemberExample();
        memberExample.createCriteria().andMobileEqualTo(mobile);
        List<Member> list = memberMapper.selectByExample(memberExample);
        if (CollUtil.isNotEmpty(list)){
//            return list.get(0).getId();
            throw new RuntimeException("手机号已经注册了");
        }

        Member member = new Member();
        member.setId(System.currentTimeMillis());
        member.setMobile(mobile);
        memberMapper.insert(member);
        CommonResponse<Long> commonResponse = new CommonResponse<>();
        commonResponse.setContent(member.getId());
        return commonResponse;
    }
}
