package com.backend.modules.dao;

import com.backend.modules.entity.mysql.InformationbaseEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 
 * 
 * @author hsy
 * @email 760356917@qq.com
 * @date 2024-04-08 21:35:18
 */
@Mapper
public interface InformationbaseDao extends BaseMapper<InformationbaseEntity> {


    List<InformationbaseEntity> selectAllArticles();

    List<InformationbaseEntity> searchByKeyword(String keyword);
}

