package com.jayden.member.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jayden.member.dao.Member;
import org.apache.ibatis.annotations.Mapper;

/**
 * @ClassName: MemberMapper
 * @Author: 梁金德 Jayden
 * @Date: 2024-04-11 3:00
 * @Version: V1.0
 */
@Mapper
public interface MemberMapper extends BaseMapper<Member> {

    int count();
}
