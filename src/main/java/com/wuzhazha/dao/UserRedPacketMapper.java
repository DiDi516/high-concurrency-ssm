package com.wuzhazha.dao;

import com.wuzhazha.pojo.UserRedPacket;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRedPacketMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserRedPacket record);

    int insertSelective(UserRedPacket record);

    UserRedPacket selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserRedPacket record);

    int updateByPrimaryKey(UserRedPacket record);
}