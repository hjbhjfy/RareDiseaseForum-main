package com.backend.modules.controller;

import java.util.Arrays;
import java.util.Map;

import com.backend.modules.entity.UserLoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import com.backend.modules.entity.mysql.UsersEntity;
import com.backend.modules.service.UsersService;
import com.backend.common.utils.PageUtils;
import com.backend.common.utils.R;

import javax.annotation.Resource;


/**
 * 
 *
 * @author hsy
 * @email 760356917@qq.com
 * @date 2024-04-08 21:35:18
 */
@RestController
@RequestMapping("/users")
public class UsersController {
    @Resource
    private UsersService usersService;


    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = usersService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{uId}")
    public R info(@PathVariable("uId") Integer uId){
		UsersEntity users = usersService.getById(uId);

        return R.ok().put("users", users);
    }

    /**
     * 保存
     */
    @RequestMapping("/regist")
    public R save(@RequestBody UsersEntity users){
		usersService.save(users);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody UsersEntity users){
		usersService.updateById(users);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] uIds){
		usersService.removeByIds(Arrays.asList(uIds));

        return R.ok();
    }
    @PostMapping("/login")
    public R login(@RequestBody UserLoginRequest request) {
        R loginSuccess = usersService.login(request.getUName(),request.getPassword(),request.getUId());
        return loginSuccess;
    }
}
