package com.jayden.common.util;

import cn.hutool.core.util.IdUtil;

/**
 * 封装雪花算法
 * @ClassName: SnowUtil
 * @Author: 梁金德 Jayden
 * @Date: 2024-04-11 13:22
 * @Version: V1.0
 */
public class SnowUtil {
    // NOTE: 之后从数据库获取ID
    private static long dataCenterId = 1; //数据中心
    private static long workerId = 1; // 机器标识

    public static long getSnowflakeNextId(){
        return IdUtil.getSnowflake(workerId,dataCenterId).nextId();
    }

    public static String getSnowflakeNextIdStr(){
        return IdUtil.getSnowflake(workerId,dataCenterId).nextIdStr();
    }
}
