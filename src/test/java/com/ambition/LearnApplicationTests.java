package com.ambition;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootTest
class LearnApplicationTests {
    /**
     * keys * 查询所有的key
     * keys *name 查询所有以name结尾的key
     * exists key 判断key是否存在
     * del key 删除key 阻塞 也就是说会等待删除完成
     * unlink key 删除key 但是不阻塞 也就是说不会等待删除完成
     * type key 查询key的类型
     * ttl key 查询key的过期时间 如果是-1 说明永不过期 如果是-2 说明已经过期
     * expire key seconds 设置key的过期时间
     * select index 选择数据库 默认是0-15
     * move key dbindex 将key移动到指定的数据库
     * flushdb 清空当前数据库
     * flushall 清空所有数据库
     * redis key是区分大小写的 命令不区分大小写
     * help 查看帮助
     */


    /**
     * set 命令
     * 参数 ex seconds 设置过期时间 单位是秒
     * 参数 px milliseconds 设置过期时间 单位是毫秒
     * 参数 nx 只有key不存在的时候才会设置key
     * 参数 xx 只有key存在的时候才会设置key
     * 参数 exat timestamp 设置过期时间 单位是秒 Unix时间戳
     * 参数 pxat timestamp 设置过期时间 单位是毫秒 Unix时间戳
     * 参数 keepttl 如果key已经存在 那么设置key的过期时间为之前的过期时间 无论你传递的过期时间是多少 都保留之前的过期时间
     */

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Test
    void test() {
        stringRedisTemplate.opsForValue().set("name", "ambition");
        System.out.println(stringRedisTemplate.opsForValue().get("name"));
    }

}
