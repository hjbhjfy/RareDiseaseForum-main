package com.backend.modules.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.backend.modules.entity.mysql.ForumDiscoverEntity;
import com.backend.modules.service.ForumDiscoverService;
import com.backend.common.utils.PageUtils;
import com.backend.common.utils.R;



/**
 * 
 *
 * @author hsy
 * @email 760356917@qq.com
 * @date 2024-04-08 21:35:17
 */
@RestController
@RequestMapping("/forumdiscover")
public class ForumDiscoverController {
    @Autowired
    private ForumDiscoverService forumDiscoverService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = forumDiscoverService.queryPage(params);

        return R.ok().put("page", page);
    }

    /**
     * 推文
     * @return
     */

    @GetMapping("/tweets")
    public R getTweets() {
        try {
            List<ForumDiscoverEntity> data = forumDiscoverService.getTweets();
            return R.ok().put("data", data);
        } catch (Exception e) {
            return R.error(e.getMessage());
        }
    }

    /**
     * 推荐内容
     * @return
     */
    @GetMapping("/recommendations")
    public R getRecommendations() {
        try {
            List<ForumDiscoverEntity> data = forumDiscoverService.getRecommendations();
            return R.ok().put("data", data);
        } catch (Exception e) {
            return R.error(e.getMessage());
        }
    }

    /**
     * 中间框
     * @return
     */

    @GetMapping("/middle-box")
    public R getMiddleBoxContents() {
        try {
            List<ForumDiscoverEntity> data = forumDiscoverService.getMiddleBoxContents();
            return R.ok().put("data", data);
        } catch (Exception e) {
            return R.error(e.getMessage());
        }
    }

}
