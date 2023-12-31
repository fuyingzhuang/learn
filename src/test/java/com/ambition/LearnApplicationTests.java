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

    /**
     * hash 类似java的 Map<String,Map<String,String>>
     * hset key field value 设置key的field的value
     * hget key field 获取key的field的value
     * hmset key field value [field value ...] 设置key的多个field的value
     * hmget key field [field ...] 获取key的多个field的value
     * hgetall key 获取key的所有field和value
     * hdel key field [field ...] 删除key的多个field
     * hlen key 获取key的field的数量
     * hexists key field 判断key的field是否存在
     * hkrys key 获取key的所有field
     * hvals key 获取key的所有value
     * hincrby key field increment 将key的field的value加increment
     * hincrbyfloat key field increment 将key的field的value加increment
     * hsetnx key field value 只有key的field不存在的时候才会设置key的field的value
     * 购物车的场景
     * hset cart:1 product:1 1 product:2 2 product:3 3
     * 添加数量
     * hincrby cart:1 product:1 1
     * 删除商品
     * hdel cart:1 product:1
     * 查询商品数量
     * hget cart:1 product:1
     */


    /**
     * set 类似java的 Set<String> 无序 不重复
     * sadd key member [member ...] 向key中添加member
     * smembers key 获取key中的所有member
     * sismember key member 判断key中是否存在member
     * scard key 获取key中的member的数量
     * spop key 随机删除key中的一个member
     * srandmember key [count] 随机获取key中的一个member 如果count大于0 那么获取count个member
     * srem key member [member ...] 删除key中的member
     * smove source destination member 将source中的member移动到destination中
     * sdiff key [key ...] 获取key中的member和其他key中的member的差集
     * sdiffstore destination key [key ...] 获取key中的member和其他key中的member的差集 并且将差集保存到destination中
     * sinter key [key ...] 获取key中的member和其他key中的member的交集
     * sinterstore destination key [key ...] 获取key中的member和其他key中的member的交集 并且将交集保存到destination中
     * sunion key [key ...] 获取key中的member和其他key中的member的并集
     * sunionstore destination key [key ...] 获取key中的member和其他key中的member的并集 并且将并集保存到destination中
     * 应用场景 共同好友 交集 两个人的好友列表并集 你可能认识的人 差集 你的好友列表和你可能认识的人的列表的差集
     * 微信朋友圈的点赞列表 交集 你的好友列表和你的朋友圈的点赞列表的交集
     */

    /**
     * zset 类似java的 SortedSet<String> 有序 不重复 每个元素都有一个分数 通过分数进行排序 也可以通过分数进行范围查询
     * zadd key score member [score member ...] 向key中添加member
     * zrange key start stop [withscores] 获取key中的member 从start到stop 如果withscores为true 那么获取member和分数 从小到大排序
     * zrevrange key start stop [withscores] 获取key中的member 从start到stop 如果withscores为true 那么获取member和分数 从大到小排序
     * zrangebyscore key min max [withscores] 获取key中的member 从min到max 如果withscores为true 那么获取member和分数 从小到大排序
     * zscore key member 获取key中member的分数
     * zcard key 获取key中的member的数量
     * zrem  key member [member ...] 删除key中的member
     * zincrby key increment member 将key中member的分数加increment
     * zcount key min max 获取key中member的分数在min和max之间的数量
     * zrank key member 获取key中member的排名 从小到大排序
     * zrevrank key member 获取key中member的排名 从大到小排序
     * 应用场景 排行榜 根据商品的销量进行排行
     */

    /**
     * bitmap 位图 由0和1状态表现的二进制位的bit数组
     * setbit key offset value 设置key的offset的bit位为value
     * getbit key offset 获取key的offset的bit位的值
     * strlen key 统计字节长度 安装字节进行统计 每个字节8位 每次申请的内存是8位
     * bitcount key [start end] 获取key的start到end的bit位中值为1的数量
     * bitop operation  operation是and or xor not  destination key [key ...] 将key的bit位和其他key的bit位进行operation运算 并且将结果保存到destination中
     * 应用场景 用户签到 一个用户一年365天 365个bit位 0表示未签到 1表示签到
     */

    /**
     * hyperloglog 用来做基数统计的算法
     * 什么是基数?
     * 一个集合中不重复元素的个数 每一个元素都是唯一的 不能重复
     * 去重脱水之后的真实数量
     * pfadd key element [element ...] 向key中添加element
     * pfcount key 获取key中的基数
     * pfmerge destination key [key ...] 将key中的基数和其他key中的基数进行合并 并且将结果保存到destination中
     * 应用场景 统计网站的UV 统计每天的UV 统计每个月的UV 统计每年的UV
     */

    /**
     * geo 地理位置
     * geoadd key longitude latitude member [longitude latitude member ...] 向key中添加member
     * geopos key member [member ...] 获取key中的member的经纬度
     * geohash key member [member ...] 获取key中的member的geohash
     * geodist key member1 member2 [unit] 获取key中的member1和member2的距离 unit是m km mi ft
     * georadius key longitude latitude radius m|km|mi|ft [withcoord] [withdist] [withhash] [count count] [asc|desc] [store key] [storedist key] 获取key中的member的经纬度
     * georadiusbymember key member radius m|km|mi|ft [withcoord] [withdist] [withhash] [count count] [asc|desc] [store key] [storedist key] 获取key中的member的经纬度
     * 应用场景 附近的人 附近的商家 附近的车位
     */

    /**
     * redis流 stream 用list实现消息队列 lpush 添加消息 rpop 获取消息 一对一
     * pub sub 一对多 一个消息发布者 多个消息订阅者 Message Content 每一个消息都有一个唯一的id
     * Consumer Group 消费者组 每一个消费者组都有一个唯一的名称 通过xgroup创建消费者组 同一个消费者组中的消费者不能消费同一个消息 同一个消费者组中的消费者可以消费不同的消息
     * Last Delivered ID 消费者组中每一个消费者消费的最后一个消息的id 游标 每个消费者组会有个游标 用来记录消费者组中每一个消费者消费的最后一个消息的id 任意一个消费者消费了一个消息 游标就会向前移动
     * Consumer 消费者 消费者组中的消费者
     * Pending ids 消费者会有一个状态变量 用于记录呗当前消费已读取但为ack的消息的id 如果客户端没有ack 这个变量会一直增长 一旦某个消息被ack他就开始减少
     * 这个pending ids的长度就是当前消费者还有多少消息没有被ack
     * xadd key id field value [field value ...] 向key中添加数据 消息的id是自动生成的 用*表示 也可以自己指定id 但是id必须是唯一的
     * 生成的消息id是一个64位的整数 由毫秒时间戳和序列号组成
     * xrang key start end [count count] 获取key中的消息 从start到end 如果count不为空 那么获取count条消息
     * xrevrange key end start [count count] 获取key中的消息 从end到start 如果count不为空 那么获取count条消息
     * xdel key id [id ...] 删除key中的消息
     * xlen key 获取key中的消息的数量
     * xrange key - + 获取key中的所有消息
     * xread count count streams key [key ...] id [id ...] 从key中读取count条消息
     * xgroup create key groupname id [mkstream] 创建消费者组
     * xreadgroup groupname consumer count streams key [key ...] id [id ...] 从key中读取count条消息
     * xack key groupname id [id ...] 消费者ack消息
     * xpending key groupname [start end count] [consumer] 获取消费者组中的消费者的状态
     * xclaim key groupname consumer min-idle-time id [id ...] [idle time ms] [retrycount] [force] 将消息从一个消费者组中转移到另一个消费者组中
     * 应用场景 消息队列 还是用MQ吧 redis的消息队列不太好用
     */

    /**
     * bitfield key [get type offset] [set type offset value] [incrby type offset increment] [overflow wrap|sat|fail] 对key中的二进制位进行操作
     * 应用场景 用来做计数器
     * 一个用户一年365天 365个bit位 0表示未签到 1表示签到 一个用户一年最多签到365次
     */

    /**
     * redis 持久化 将内存中的数据保存到硬盘中 通过rdb和aof两种方式实现
     * RDB Redis DataBase
     * AOF Append Only File
     */
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Test
    void test() {
        stringRedisTemplate.opsForValue().set("name", "ambition");
        System.out.println(stringRedisTemplate.opsForValue().get("name"));
    }

}
