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

}
