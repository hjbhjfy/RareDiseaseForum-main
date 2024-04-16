package com.backend.modules.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.backend.common.utils.PageUtils;
import com.backend.common.utils.Query;

import com.backend.modules.dao.DiseasesDao;
import com.backend.modules.entity.mysql.DiseasesEntity;
import com.backend.modules.service.DiseasesService;


@Service("diseasesService")
public class DiseasesServiceImpl extends ServiceImpl<DiseasesDao, DiseasesEntity> implements DiseasesService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<DiseasesEntity> page = this.page(
                new Query<DiseasesEntity>().getPage(params),
                new QueryWrapper<DiseasesEntity>()
        );

        return new PageUtils(page);
    }

}