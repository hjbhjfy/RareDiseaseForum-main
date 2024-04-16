package com.backend.modules.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.backend.modules.entity.mysql.ExpertsEntity;
import com.backend.modules.service.ExpertsService;
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
@RequestMapping("/experts")
public class ExpertsController {
    @Autowired
    private ExpertsService expertsService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = expertsService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{expertId}")
    public R info(@PathVariable("expertId") Integer expertId){
		ExpertsEntity experts = expertsService.getById(expertId);

        return R.ok().put("experts", experts);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ExpertsEntity experts){
		expertsService.save(experts);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody ExpertsEntity experts){
		expertsService.updateById(experts);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] expertIds){
		expertsService.removeByIds(Arrays.asList(expertIds));

        return R.ok();
    }

}
