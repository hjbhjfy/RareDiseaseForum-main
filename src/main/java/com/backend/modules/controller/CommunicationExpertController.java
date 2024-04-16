package com.backend.modules.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.backend.modules.entity.mysql.CommunicationExpertEntity;
import com.backend.modules.service.CommunicationExpertService;
import com.backend.common.utils.PageUtils;
import com.backend.common.utils.R;



/**
 * 
 *
 * @author hsy
 * @email 760356917@qq.com
 * @date 2024-04-08 21:35:18
 */
@RestController
@RequestMapping("/communicationexpert")
public class CommunicationExpertController {
    @Autowired
    private CommunicationExpertService communicationExpertService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = communicationExpertService.queryPage(params);
        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{communicationExpertId}")
    public R info(@PathVariable("communicationExpertId") Integer communicationExpertId){
		CommunicationExpertEntity communicationExpert = communicationExpertService.getById(communicationExpertId);

        return R.ok().put("communicationExpert", communicationExpert);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody CommunicationExpertEntity communicationExpert){
		communicationExpertService.save(communicationExpert);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody CommunicationExpertEntity communicationExpert){
		communicationExpertService.updateById(communicationExpert);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] communicationExpertIds){
		communicationExpertService.removeByIds(Arrays.asList(communicationExpertIds));
        return R.ok();
    }

}
