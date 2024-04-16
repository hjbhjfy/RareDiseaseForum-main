package com.backend.interceptor;

import com.alibaba.fastjson.JSON;
import com.backend.common.utils.R;
import com.sun.istack.internal.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;
@Slf4j
public class VertifyInterceptor implements HandlerInterceptor {
    @Resource
    private StringRedisTemplate redis;

    @Override
    public boolean preHandle(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull Object handler) throws Exception {
        String uName = "";
        String token = "";
        try {
            for (Cookie ck : request.getCookies()) {
                if (Objects.equals(ck.getName(), "uName")) {
                    uName = ck.getValue();
                } else if (Objects.equals(ck.getName(), "token")) {
                    token = ck.getValue();
                }
            }
            log.info("Verify,uName:" + uName + ",token:" + token);
            if (isLogin(uName, token)) {
                return true;
            } else {
                response.setContentType("application/json;charset=UTF-8");
                response.getWriter().println(JSON.toJSONString(R.error("验证错误")));
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }
    public boolean isLogin(String uName, String token) {
        String r = redis.opsForValue().get(uName);
        log.info("Verify login,redis result:" + r);
        return Objects.equals(r, token);
    }
}
