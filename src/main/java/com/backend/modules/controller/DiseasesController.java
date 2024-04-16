package com.backend.modules.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.backend.modules.entity.mysql.DiseasesEntity;
import com.backend.modules.service.DiseasesService;
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
@RequestMapping("/diseases")
public class DiseasesController {
    @Autowired
    private DiseasesService diseasesService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = diseasesService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{diseaseId}")
    public R info(@PathVariable("diseaseId") Integer diseaseId){
		DiseasesEntity diseases = diseasesService.getById(diseaseId);

        return R.ok().put("diseases", diseases);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DiseasesEntity diseases){
		diseasesService.save(diseases);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody DiseasesEntity diseases){
		diseasesService.updateById(diseases);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] diseaseIds){
		diseasesService.removeByIds(Arrays.asList(diseaseIds));

        return R.ok();
    }

}
