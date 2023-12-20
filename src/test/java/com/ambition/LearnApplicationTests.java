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

    /**
     * getrange key start end 获取key的value的子字符串
     * setrange key offset value 用value覆盖key的value 从offset开始
     * incr key 将key的value加1 应用场景 比如 抖音的点赞数 能够点一下增加1 无限增加
     * incrby key increment 将key的value加increment
     * decr key 将key的value减1
     * decrby key decrement 将key的value减decrement
     */


    /**
     * list列表
     * 底层是一个双端链表 可以从头部插入 也可以从尾部插入 也可以从头部删除 也可以从尾部删除
     * lpush key value [value ...] 从头部插入
     * rpush key value [value ...] 从尾部插入
     * lpop key 从头部删除
     * rpop key 从尾部删除
     * lrange key start stop 查询key的value的列表 只有lrange命令才能查询到列表的value 没有rrange 也就是只能从头部查询到尾部 0 -1 表示查询所有
     * lindex key index 查询key的value的列表中指定索引的value
     * llen key 查询key的value的列表的长度 也就是列表的元素个数
     * lrem key count value 从key的value的列表中删除count个value
     * ltirm key start stop 从key的value的列表中保留start到stop之间的元素 其他的全部删除
     * rpoplpush source destination 从source的value的列表中删除最后一个元素 并且将这个元素插入到destination的value的列表的头部
     * lset key index value 将key的value的列表中指定索引的value设置为value
     * linsert key before|after pivot value 在key的value的列表中的pivot的前面或者后面插入value
     * 应用场景 比如抖音的评论列表 评论列表是一个列表 从头部插入 从尾部删除 一对多的关系
     * 
     */
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Test
    void test() {
        stringRedisTemplate.opsForValue().set("name", "ambition");
        System.out.println(stringRedisTemplate.opsForValue().get("name"));
    }

}
