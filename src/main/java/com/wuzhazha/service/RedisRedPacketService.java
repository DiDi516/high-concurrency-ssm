package com.wuzhazha.service;

/**
 * Redis抢红包服务接口
 * @Author:wuzhazha
 * @Date: 2018/8/13 22:14
 * @Description:
 */
public interface RedisRedPacketService {

    /**
     * 保存redis抢红包列表
     * @param redPacketId 抢红包编号
     * @param unitAmount 红包金额
     */
    void saveUserRedPacketByRedis(Long redPacketId,Double unitAmount);
}
