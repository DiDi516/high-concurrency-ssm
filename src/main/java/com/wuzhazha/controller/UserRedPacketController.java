package com.wuzhazha.controller;

import com.google.common.collect.Maps;
import com.wuzhazha.service.UserRedPacketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @Author:wuzhazha
 * @Date: 2018/8/12 21:12
 * @Description:
 */
@Controller
@RequestMapping("/userRedPacket")
public class UserRedPacketController {


    @Autowired
    private UserRedPacketService userRedPacketService;

    /**
     * 没有使用锁机制的抢红包
     * 没有锁的保障，会出现超发现象，红包数量扣为负数的情况
     * @param redPacketId
     * @param userId
     * @return
     */
    @RequestMapping(value = "grapRedPacket")
    @ResponseBody
    public Map<String,Object> grapRedPacket(Integer redPacketId, Integer userId){
        //抢红包
        int result = userRedPacketService.grapRedPacket(redPacketId, userId);
        Map<String,Object> resMap = Maps.newHashMap();
        boolean flag = result > 0 ;
        resMap.put("success",flag);
        resMap.put("message",flag?"抢红包成功":"抢红包失败");
        return resMap;
    }

    /**
     * 使用了乐观锁的抢红包
     * 使用了乐观锁虽然保证了在多线程下数据的正确性，添加重试次数提高成功率
     * @param redPacketId
     * @param userId
     * @return
     */
    @RequestMapping(value = "grapRedPacketForVersion")
    @ResponseBody
    public Map<String,Object> grapRedPacketForVersion(Integer redPacketId, Integer userId){
        //抢红包
        int result = userRedPacketService.grapRedPacketForVersion(redPacketId, userId);
        Map<String,Object> resMap = Maps.newHashMap();
        boolean flag = result > 0 ;
        resMap.put("success",flag);
        resMap.put("message",flag?"抢红包成功":"抢红包失败");
        return resMap;
    }

}
