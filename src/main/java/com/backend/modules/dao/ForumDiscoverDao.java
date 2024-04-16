package com.backend.modules.dao;

import com.backend.modules.entity.mysql.ForumDiscoverEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 
 * 
 * @author hsy
 * @email 760356917@qq.com
 * @date 2024-04-08 21:35:17
 */
@Mapper
public interface ForumDiscoverDao extends BaseMapper<ForumDiscoverEntity> {


    List<ForumDiscoverEntity> selectTweets();

    List<ForumDiscoverEntity> selectRecommendations();

    List<ForumDiscoverEntity> selectMiddleBoxContents();
}
