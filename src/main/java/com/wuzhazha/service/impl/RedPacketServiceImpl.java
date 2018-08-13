package com.wuzhazha.service.impl;

import com.wuzhazha.dao.RedPacketMapper;
import com.wuzhazha.pojo.RedPacket;
import com.wuzhazha.service.RedPacketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author:wuzhazha
 * @Date: 2018/8/12 20:56
 * @Description:
 */
@Service
public class RedPacketServiceImpl implements RedPacketService {

    @Autowired
    private RedPacketMapper redPacketMapper;

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED)
    public RedPacket getRedPacket(Integer id) {
        return redPacketMapper.selectByPrimaryKey(id);
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED)
    public int decreaseRedPacket(Integer id) {
        return redPacketMapper.decreaseRedPacket(id);
    }

}
