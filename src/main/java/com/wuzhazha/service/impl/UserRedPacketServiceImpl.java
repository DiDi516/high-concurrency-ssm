package com.wuzhazha.service.impl;

import com.wuzhazha.dao.RedPacketMapper;
import com.wuzhazha.dao.UserRedPacketMapper;
import com.wuzhazha.pojo.RedPacket;
import com.wuzhazha.pojo.UserRedPacket;
import com.wuzhazha.service.UserRedPacketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author:wuzhazha
 * @Date: 2018/8/12 20:55
 * @Description:
 */
@Service
public class UserRedPacketServiceImpl implements UserRedPacketService {

    @Autowired
    private UserRedPacketMapper userRedPacketMapper;

    @Autowired
    private RedPacketMapper redPacketMapper;

    private static final int FAILED = 0;

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED)
    public int grapRedPacket(Integer redPacketId, Integer userId) {
        //获取红包信息
        RedPacket redPacket = redPacketMapper.selectByPrimaryKey(redPacketId);
        //当前小红包库存大于0
        if (redPacket.getStock() > 0){
            //扣减红包库存
            redPacketMapper.decreaseRedPacket(redPacketId);
            UserRedPacket userRedPacket = new UserRedPacket();
            userRedPacket.setRedPacketId(redPacketId);
            userRedPacket.setUserId(userId);
            userRedPacket.setAmount(redPacket.getUnitAmount());
            userRedPacket.setNote("抢红包：" + redPacketId);
            //插入抢红包信息
            int rowCount = userRedPacketMapper.insert(userRedPacket);
            return rowCount;
        }
        return FAILED;
    }
}
