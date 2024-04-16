package com.backend.modules.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.backend.common.utils.PageUtils;
import com.backend.common.utils.Query;

import com.backend.modules.dao.ExpertsDao;
import com.backend.modules.entity.mysql.ExpertsEntity;
import com.backend.modules.service.ExpertsService;


@Service("expertsService")
public class ExpertsServiceImpl extends ServiceImpl<ExpertsDao, ExpertsEntity> implements ExpertsService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ExpertsEntity> page = this.page(
                new Query<ExpertsEntity>().getPage(params),
                new QueryWrapper<ExpertsEntity>()
        );

        return new PageUtils(page);
    }

}