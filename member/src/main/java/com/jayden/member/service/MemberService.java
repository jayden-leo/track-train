package com.jayden.member.service;

import cn.hutool.core.collection.CollUtil;
import com.jayden.common.exception.BusinessException;
import com.jayden.common.exception.BusinessExceptionEnum;
import com.jayden.common.response.CommonResponse;
import com.jayden.common.util.SnowUtil;
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
            throw new BusinessException(BusinessExceptionEnum.MEMBER_MOBILE_EXIST);
        }

        Member member = new Member();
        member.setId(SnowUtil.getSnowflakeNextId());
        member.setMobile(mobile);
        memberMapper.insert(member);
        return new CommonResponse<>(member.getId());
    }
}
