package com.backend.modules.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.backend.common.utils.PageUtils;
import com.backend.modules.entity.mysql.DiseasesEntity;

import java.util.Map;

/**
 * 
 *
 * @author hsy
 * @email 760356917@qq.com
 * @date 2024-04-08 21:35:17
 */
public interface DiseasesService extends IService<DiseasesEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

