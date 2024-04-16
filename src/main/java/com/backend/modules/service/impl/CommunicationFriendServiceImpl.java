package com.backend.modules.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.backend.common.utils.PageUtils;
import com.backend.common.utils.Query;

import com.backend.modules.dao.CommunicationFriendDao;
import com.backend.modules.entity.mysql.CommunicationFriendEntity;
import com.backend.modules.service.CommunicationFriendService;


@Service("communicationFriendService")
public class CommunicationFriendServiceImpl extends ServiceImpl<CommunicationFriendDao, CommunicationFriendEntity> implements CommunicationFriendService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CommunicationFriendEntity> page = this.page(
                new Query<CommunicationFriendEntity>().getPage(params),
                new QueryWrapper<CommunicationFriendEntity>()
        );

        return new PageUtils(page);
    }

}