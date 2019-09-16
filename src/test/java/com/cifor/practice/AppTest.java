package com.cifor.practice;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Unit test for simple App.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class AppTest {

    @Autowired
    private RedisTemplate redisTemplate;
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        redisTemplate.opsForValue().set("a","b");
        Object a = redisTemplate.opsForValue().get("a");
        System.out.println("a");
        assertTrue( true );
    }
}
