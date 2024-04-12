package com.jayden.member.service;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.RandomUtil;
import com.jayden.common.exception.BusinessException;
import com.jayden.common.exception.BusinessExceptionEnum;
import com.jayden.common.response.CommonResponse;
import com.jayden.common.util.SnowUtil;
import com.jayden.member.dao.Member;
import com.jayden.member.dao.MemberExample;
import com.jayden.member.mapper.MemberMapper;
import com.jayden.member.request.MemberLoginRequest;
import com.jayden.member.request.MemberRegisterRequest;
import com.jayden.member.request.MemberSendCodeRequest;
import com.jayden.member.response.MemberLoginResponse;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private static final Logger LOG = LoggerFactory.getLogger(MemberService.class);
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
        Member memberDB = selectByMobile(mobile);
        if (ObjectUtil.isNull(memberDB)){
            throw new BusinessException(BusinessExceptionEnum.MEMBER_MOBILE_EXIST);
        }

        Member member = new Member();
        member.setId(SnowUtil.getSnowflakeNextId());
        member.setMobile(mobile);
        memberMapper.insert(member);
        return new CommonResponse<>(member.getId());
    }

    public void sendCode(MemberSendCodeRequest memberSendCodeRequest){
        String mobile = memberSendCodeRequest.getMobile();
        Member memberDB = selectByMobile(mobile);
        // 如果手机号不存在，则插入记录
        if (ObjectUtil.isNull(memberDB)){
            LOG.info("手机号不存在，插入记录");
            Member member = new Member();
            member.setId(SnowUtil.getSnowflakeNextId());
            member.setMobile(mobile);
            memberMapper.insert(member);
        }else{
            LOG.info("手机号存在，不插入记录");
        }

        // 生成验证码
        String code = RandomUtil.randomString(4);
        LOG.info("生成短信验证码：{}", code);

        // 保存短信记录表：手机号，短信验证码，有效期，是否已使用，业务类型，发送时间，使用时间
        LOG.info("生成短信验证码");

        // 对接短信通道，发送短信
        LOG.info("对接短信验证码");
    }

    public MemberLoginResponse login(MemberLoginRequest memberLoginRequest){
        String mobile = memberLoginRequest.getMobile();
        String code = memberLoginRequest.getCode();
        Member memberDB = selectByMobile(mobile);
        // 如果手机号不存在，则插入记录
        if (ObjectUtil.isNull(memberDB)){
            throw new BusinessException(BusinessExceptionEnum.MEMBER_MOBILE_NOT_EXIST);
        }
        // 校验短信验证码
        if (!"8888".equals(code)){
            throw new BusinessException(BusinessExceptionEnum.MEMBER_MOBILE_CODE_ERROR);
        }

        return BeanUtil.copyProperties(memberDB, MemberLoginResponse.class);
    }

    private Member selectByMobile(String mobile) {
        MemberExample memberExample = new MemberExample();
        memberExample.createCriteria().andMobileEqualTo(mobile);
        List<Member> list = memberMapper.selectByExample(memberExample);
        // 如果手机号不存在，则插入记录
        if (CollUtil.isEmpty(list)){
            LOG.info("手机号不存在，则插入记录");
            return null;
        }else{
            return list.get(0);
        }
    }
}
