package com.backend.modules.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.backend.modules.entity.mysql.InformationbaseEntity;
import com.backend.modules.service.InformationbaseService;
import com.backend.common.utils.PageUtils;
import com.backend.common.utils.R;



/**
 * 
 *
 * @author hsy
 * @email 760356917@qq.com
 * @date 2024-04-08 21:35:18
 */
@RestController
@RequestMapping("/informationbase")
public class InformationbaseController {
    @Autowired
    private InformationbaseService informationbaseService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = informationbaseService.queryPage(params);

        return R.ok().put("page", page);
    }


    // 获取信息库主页面的文章列表
    @GetMapping("/articles")
    public R getAllArticles() {
        try {
            List<InformationbaseEntity> articles = informationbaseService.getAllArticles();
            return R.ok().put("articles", articles);
        } catch (Exception e) {
            return R.error("Failed to retrieve articles: " + e.getMessage());
        }
    }

    // 搜索功能：根据疾病关键词搜索相关文章
    @GetMapping("/search")
    public R searchArticles(@RequestParam("keyword") String keyword) {
        try {
            List<InformationbaseEntity> results = informationbaseService.searchByKeyword(keyword);
            return R.ok().put("articles", results);
        } catch (Exception e) {
            return R.error("Search failed: " + e.getMessage());
        }
    }

    // 允许用户提交疾病相关的文章
    @PostMapping("/submit")
    public R submitArticle(@RequestBody InformationbaseEntity article) {
        try {
            boolean saved = informationbaseService.saveArticle(article);
            return saved ? R.ok("Article submitted successfully") : R.error("Failed to submit article");
        } catch (Exception e) {
            return R.error("Submission failed: " + e.getMessage());
        }
    }

}
