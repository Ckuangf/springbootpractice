package com.cifor.practice.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.cifor.practice.pojo.CiforUser;
import com.cifor.practice.service.CiforUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/cifor")
public class CiforController {

    @Reference(version = "1.0.0")
    private CiforUserService ciforUserService;

    @Autowired
    private RedisTemplate redisTemplate;

    private static final String ALL_USER = "allUser";

    @RequestMapping(value = "/getCiforUserById",method = RequestMethod.GET)
    public CiforUser getCiforUserById(@RequestParam("id") String Id){
        List<CiforUser> range = redisTemplate.opsForList().range(ALL_USER, 0, -1);
        for(CiforUser user : range){
            if(user.getId() == Id){
                return user;
            }
        }
        return ciforUserService.findById(Id);
    }

    @PostMapping
    public CiforUser saveCiforUser(@RequestBody CiforUser ciforUser){
        System.out.println(ciforUser.toString());
        return ciforUserService.save(ciforUser);
    }

    @DeleteMapping
    public String deleteCiforUserById(@RequestHeader("id") String Id){
        ciforUserService.delete(Id);
        return "delete successed";
    }

}
