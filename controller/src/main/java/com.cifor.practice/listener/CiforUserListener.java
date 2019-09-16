package com.cifor.practice.listener;

import com.cifor.practice.pojo.CiforUser;
import com.cifor.practice.service.CiforUserService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import javax.annotation.Resource;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.List;

@WebListener
public class CiforUserListener implements ServletContextListener {

    @Resource
    private RedisTemplate<String,CiforUser> redisTemplate;

    @Resource
    private CiforUserService ciforUserService;

    private static final String ALL_USER = "allUser";

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("======================context init======================");
        //查询数据库中的用户
        List<CiforUser> all = ciforUserService.findAll();

        //清除缓存
        redisTemplate.delete(ALL_USER);

        //设置字符串的序列化类，避免在redis中存放的key 出现乱码
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        //存入缓存
        redisTemplate.opsForList().leftPushAll(ALL_USER,all);


        List<CiforUser> range = redisTemplate.opsForList().range(ALL_USER, 0, -1);
        int size = range.size();
        System.out.println("==================context init complete=== now User count is "+size+"==============");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("======================destroy======================");
    }
}
