package com.wuzhazha.dao;

import com.wuzhazha.pojo.RedPacket;
import org.apache.ibatis.annotations.Param;
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

    /**
     * 扣减红包数量，使用乐观锁
     * @param id
     * @param version
     * @return
     */
    int decreaseRedPacketForVersion(@Param("id") Integer id, @Param("version") Integer version);
}