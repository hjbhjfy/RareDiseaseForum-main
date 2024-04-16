package com.backend.modules.service.impl;

import com.backend.common.utils.R;
import com.backend.modules.entity.Cookie;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.backend.common.utils.PageUtils;
import com.backend.common.utils.Query;

import com.backend.modules.dao.UsersDao;
import com.backend.modules.entity.mysql.UsersEntity;
import com.backend.modules.service.UsersService;

import javax.annotation.Resource;


@Service("usersService")
public class UsersServiceImpl extends ServiceImpl<UsersDao, UsersEntity> implements UsersService {
    @Resource
    private UsersDao usersDao;
    @Resource
    private StringRedisTemplate redis;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<UsersEntity> page = this.page(
                new Query<UsersEntity>().getPage(params),
                new QueryWrapper<UsersEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public R login(String uName, String password,Long uId) {
        if (isValidCredentials(uName, password,uId)) {
            String token = DigestUtils.md5Hex(new Date().getTime()+"");
            Cookie cookie=new Cookie();
            cookie.setToken(token);
            cookie.setUName(uName);
            redis.opsForValue().set(uName, token, 1, TimeUnit.DAYS);
            return R.ok("登录成功").put("cookie",cookie);
        } else {
            return R.error("登录失败");
        }
    }
    private boolean isValidCredentials(String uName, String password,Long uId) {
        UsersEntity user = usersDao.selectById(uId);
        if (user!=null){
            return user.getUName().equals(uName)&&user.getPassword().equals(password);
        }else {
            return false;
        }

    }
}