package com.backend.modules.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.backend.common.utils.PageUtils;
import com.backend.common.utils.Query;

import com.backend.modules.dao.CommunicationExpertDao;
import com.backend.modules.entity.mysql.CommunicationExpertEntity;
import com.backend.modules.service.CommunicationExpertService;


@Service("communicationExpertService")
public class CommunicationExpertServiceImpl extends ServiceImpl<CommunicationExpertDao, CommunicationExpertEntity> implements CommunicationExpertService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CommunicationExpertEntity> page = this.page(
                new Query<CommunicationExpertEntity>().getPage(params),
                new QueryWrapper<CommunicationExpertEntity>()
        );

        return new PageUtils(page);
    }

}