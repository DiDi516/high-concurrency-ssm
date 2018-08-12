package com.wuzhazha.dao;

import com.wuzhazha.pojo.RedPacket;
import org.springframework.stereotype.Repository;

@Repository
public interface RedPacketMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RedPacket record);

    int insertSelective(RedPacket record);

    RedPacket selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RedPacket record);

    int updateByPrimaryKey(RedPacket record);

    int decreaseRedPacket(Integer id);
}