package com.backend.modules.service;

import com.backend.modules.dao.ForumDiscoverDao;
import com.baomidou.mybatisplus.extension.service.IService;
import com.backend.common.utils.PageUtils;
import com.backend.modules.entity.mysql.ForumDiscoverEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author hsy
 * @email 760356917@qq.com
 * @date 2024-04-08 21:35:17
 */
public interface ForumDiscoverService extends IService<ForumDiscoverEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 推文
     * @return
     */
        List<ForumDiscoverEntity> getTweets();

    /**
     * 推荐内容
     * @return
     */
    List<ForumDiscoverEntity> getRecommendations();

    /**
     * 中间框
     * @return
     */
        List<ForumDiscoverEntity> getMiddleBoxContents();
    }


