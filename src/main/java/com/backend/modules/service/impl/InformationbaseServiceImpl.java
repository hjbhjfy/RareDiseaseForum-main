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

import com.backend.modules.dao.InformationbaseDao;
import com.backend.modules.entity.mysql.InformationbaseEntity;
import com.backend.modules.service.InformationbaseService;


@Service("informationbaseService")
public class InformationbaseServiceImpl extends ServiceImpl<InformationbaseDao, InformationbaseEntity> implements InformationbaseService {


    @Autowired
    private InformationbaseDao informationbaseDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<InformationbaseEntity> page = this.page(
                new Query<InformationbaseEntity>().getPage(params),
                new QueryWrapper<InformationbaseEntity>()
        );

        return new PageUtils(page);
    }

    /**
     * 信息库主页面
     * @return
     */
    @Override
    public List<InformationbaseEntity> getAllArticles() {
        return informationbaseDao.selectAllArticles();
    }

    /**
     * 搜索框查询
     * @param keyword
     * @return
     */
    @Override
    public List<InformationbaseEntity> searchByKeyword(String keyword) {
        return informationbaseDao.searchByKeyword(keyword);
    }

    /**
     * 添加文章
     * @param article
     * @return
     */
    @Override
    public boolean saveArticle(InformationbaseEntity article) {
        return informationbaseDao.insert(article) > 0;
    }

}