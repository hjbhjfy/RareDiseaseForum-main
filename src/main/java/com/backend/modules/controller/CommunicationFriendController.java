package com.backend.modules.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.backend.modules.entity.mysql.CommunicationFriendEntity;
import com.backend.modules.service.CommunicationFriendService;
import com.backend.common.utils.PageUtils;
import com.backend.common.utils.R;



/**
 * 
 *
 * @author hsy
 * @email 760356917@qq.com
 * @date 2024-04-08 21:35:17
 */
@RestController
@RequestMapping("/communicationfriend")
public class CommunicationFriendController {
    @Autowired
    private CommunicationFriendService communicationFriendService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = communicationFriendService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{communicationFriendId}")
    public R info(@PathVariable("communicationFriendId") Integer communicationFriendId){
		CommunicationFriendEntity communicationFriend = communicationFriendService.getById(communicationFriendId);

        return R.ok().put("communicationFriend", communicationFriend);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody CommunicationFriendEntity communicationFriend){
		communicationFriendService.save(communicationFriend);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody CommunicationFriendEntity communicationFriend){
		communicationFriendService.updateById(communicationFriend);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] communicationFriendIds){
		communicationFriendService.removeByIds(Arrays.asList(communicationFriendIds));

        return R.ok();
    }

}
