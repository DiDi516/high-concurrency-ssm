package com.wuzhazha.service;

/**
 * @Author:wuzhazha
 * @Date: 2018/8/12 20:51
 * @Description:
 */
public interface UserRedPacketService {

    /**
     * 保存抢红包信息
     * @param redPacketId 红包编号
     * @param userId 抢红包用户编号
     * @return
     */
    int grapRedPacket(Integer redPacketId,Integer userId);

    /**
     * 保存抢红包信息（添加乐观锁），添加重试次数提高成功率
     * @param redPacketId
     * @param userId
     * @return
     */
    int grapRedPacketForVersion(Integer redPacketId,Integer userId);

}
