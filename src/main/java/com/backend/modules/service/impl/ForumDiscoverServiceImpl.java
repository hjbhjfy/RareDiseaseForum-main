package com.backend.modules.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.backend.common.utils.PageUtils;
import com.backend.common.utils.Query;

import com.backend.modules.dao.ForumDiscoverDao;
import com.backend.modules.entity.mysql.ForumDiscoverEntity;
import com.backend.modules.service.ForumDiscoverService;


@Service("forumDiscoverService")
public class ForumDiscoverServiceImpl extends ServiceImpl<ForumDiscoverDao, ForumDiscoverEntity> implements ForumDiscoverService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ForumDiscoverEntity> page = this.page(
                new Query<ForumDiscoverEntity>().getPage(params),
                new QueryWrapper<ForumDiscoverEntity>()
        );

        return new PageUtils(page);
    }

    @Autowired
    private ForumDiscoverDao forumDiscoverDao;

    /**
     * 推文
     * @return
     */
    @Override
    public List<ForumDiscoverEntity> getTweets() {
        return forumDiscoverDao.selectTweets();
    }

    /**
     * 推荐内容
     * @return
     */
    @Override
    public List<ForumDiscoverEntity> getRecommendations() {
        return forumDiscoverDao.selectRecommendations();
    }

    /**
     * 中间框
     * @return
     */
    @Override
    public List<ForumDiscoverEntity> getMiddleBoxContents() {
        return forumDiscoverDao.selectMiddleBoxContents();
    }


}