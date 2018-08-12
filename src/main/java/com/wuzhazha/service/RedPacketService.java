package com.wuzhazha.service;

import com.wuzhazha.pojo.RedPacket;

/**
 * @Author:wuzhazha
 * @Date: 2018/8/12 20:51
 * @Description:
 */
public interface RedPacketService {

    /**
     * 获取红包
     * @param id
     * @return
     */
    RedPacket getRedPacket(Integer id);

    /**
     * 扣减红包
     * @param id
     * @return
     */
    int decreaseRedPacket(Integer id);

}
