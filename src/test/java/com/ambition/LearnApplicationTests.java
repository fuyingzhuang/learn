package com.ambition;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.annotation.Resource;
import java.util.Map;

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
     * <p>
     * <p>
     * <p>
     * <p>
     * set 命令
     * 参数 ex seconds 设置过期时间 单位是秒
     * 参数 px milliseconds 设置过期时间 单位是毫秒
     * 参数 nx 只有key不存在的时候才会设置key
     * 参数 xx 只有key存在的时候才会设置key
     * 参数 exat timestamp 设置过期时间 单位是秒 Unix时间戳
     * 参数 pxat timestamp 设置过期时间 单位是毫秒 Unix时间戳
     * 参数 keepttl 如果key已经存在 那么设置key的过期时间为之前的过期时间 无论你传递的过期时间是多少 都保留之前的过期时间
     * <p>
     * <p>
     * <p>
     * getrange key start end 获取key的value的子字符串
     * setrange key offset value 用value覆盖key的value 从offset开始
     * incr key 将key的value加1 应用场景 比如 抖音的点赞数 能够点一下增加1 无限增加
     * incrby key increment 将key的value加increment
     * decr key 将key的value减1
     * decrby key decrement 将key的value减decrement
     * <p>
     * <p>
     * <p>
     * <p>
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
     * <p>
     * <p>
     * <p>
     * <p>
     * hash 类似java的 Map<String, Map<String,String>>
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
     * <p>
     * <p>
     * <p>
     * <p>
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
     * <p>
     * <p>
     * <p>
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
     * <p>
     * <p>
     * <p>
     * bitmap 位图 由0和1状态表现的二进制位的bit数组
     * setbit key offset value 设置key的offset的bit位为value
     * getbit key offset 获取key的offset的bit位的值
     * strlen key 统计字节长度 安装字节进行统计 每个字节8位 每次申请的内存是8位
     * bitcount key [start end] 获取key的start到end的bit位中值为1的数量
     * bitop operation  operation是and or xor not  destination key [key ...] 将key的bit位和其他key的bit位进行operation运算 并且将结果保存到destination中
     * 应用场景 用户签到 一个用户一年365天 365个bit位 0表示未签到 1表示签到
     * <p>
     * <p>
     * <p>
     * hyperloglog 用来做基数统计的算法
     * 什么是基数?
     * 一个集合中不重复元素的个数 每一个元素都是唯一的 不能重复
     * 去重脱水之后的真实数量
     * pfadd key element [element ...] 向key中添加element
     * pfcount key 获取key中的基数
     * pfmerge destination key [key ...] 将key中的基数和其他key中的基数进行合并 并且将结果保存到destination中
     * 应用场景 统计网站的UV 统计每天的UV 统计每个月的UV 统计每年的UV
     * <p>
     * <p>
     * <p>
     * geo 地理位置
     * geoadd key longitude latitude member [longitude latitude member ...] 向key中添加member
     * geopos key member [member ...] 获取key中的member的经纬度
     * geohash key member [member ...] 获取key中的member的geohash
     * geodist key member1 member2 [unit] 获取key中的member1和member2的距离 unit是m km mi ft
     * georadius key longitude latitude radius m|km|mi|ft [withcoord] [withdist] [withhash] [count count] [asc|desc] [store key] [storedist key] 获取key中的member的经纬度
     * georadiusbymember key member radius m|km|mi|ft [withcoord] [withdist] [withhash] [count count] [asc|desc] [store key] [storedist key] 获取key中的member的经纬度
     * 应用场景 附近的人 附近的商家 附近的车位
     * <p>
     * <p>
     * <p>
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
     * <p>
     * <p>
     * <p>
     * bitfield key [get type offset] [set type offset value] [incrby type offset increment] [overflow wrap|sat|fail] 对key中的二进制位进行操作
     * 应用场景 用来做计数器
     * 一个用户一年365天 365个bit位 0表示未签到 1表示签到 一个用户一年最多签到365次
     * <p>
     * <p>
     * <p>
     * redis 持久化 将内存中的数据保存到硬盘中 通过rdb和aof两种方式实现
     * RDB Redis DataBase 持久性的保存数据 快照 在指定的时间间隔内将内存中的数据保存到硬盘中 保存的是内存中的数据的快照 这个快件文件为dump.rdb 默认是关闭的 可以通过配置文件开启 也可以通过命令开启
     * 如果重启了redis 会自动加载dump.rdb文件 会将dump.rdb文件中的数据加载到内存中
     * AOF Append Only File 以日志的形式来记录每个写操作 以文本的形式记录 通过追加的方式写入文件 默认是开启的 可以通过配置文件关闭 也可以通过命令关闭
     * 如果重启了redis 会自动读取aof文件 会将aof文件中的命令重新执行一遍
     * <p>
     * RDB的优点
     * 1.适合大规模的数据恢复
     * 2.按照业务定时备份
     * 3.对数据完整性和一致性要求不高
     * 4.RDB文件在内存中的加载速度比AOF快
     * <p>
     * RDB的缺点
     * 1.如果redis意外宕机 会丢失最后一次快照后的所有数据
     * 2.如果数据比较大 保存快照的时间会比较长
     * <p>
     * 修复RDB文件
     * redis-check-dump --fix dump.rdb
     * 触发RDB快照
     * 1. save 阻塞redis服务器 会阻塞所有的客户端
     * 2. bgsave 在后台执行 快照期间可以处理客户端的请求
     * 3. save 900 1 900秒内如果有一个key发生了变化 那么就会触发快照
     * 4. flushall flushdb
     * 5. 执行shutdown 但是没有开启aof的话 会自动执行bgsave
     * 6. 主从复制时 主节点自动触发
     * 如何禁用快照
     * 1. redis-cli config set save "" 命令行禁用
     * 2. 在配置文件中注释掉所有的save配置
     * <p>
     * <p>
     * <p>
     * redis持久化
     * AOF 需要在配置文件中打开AOF的配置
     * AOF 以日志的形式记录每个写操作 以文本的形式记录 将redis执行过的所有写命令记录下来 不记录读命令 只许追加文件 不可以改写文件
     * 1.每一个写命令都会追加到aof文件中
     * 2.文件的写入是顺序的 不需要随机访问硬盘
     * 三种写回策略
     * 1.每秒钟写一次
     * 2.每执行一条命令就写一次
     * 3.不主动写入 由操作系统决定什么时候写入
     * AOF重写机制
     * 触发条件
     * 1.手动执行bgrewriteaof命令
     * 2.自动触发
     * 2.1 当aof文件的大小超过了配置文件中的aof-file-size配置的值时
     * 2.2 当aof文件的大小超过了上一次重写的aof文件的大小时
     * 2.3 当aof文件的大小超过了上一次重写的aof文件的大小的一倍时
     * 2.4 当aof文件的大小超过了64M时
     * 重写过程
     * 1.创建一个新的aof文件
     * 2.遍历旧的aof文件中的所有命令
     * 3.将旧的aof文件中的命令写入到新的aof文件中
     * 4.将新的aof文件替换旧的aof文件
     * 5.删除旧的aof文件
     * 6.将新的aof文件重命名为旧的aof文件
     * AOF的优点
     * 1.数据完整性和一致性比RDB好
     * 2.每秒钟同步一次 不会丢失太多数据
     * AOF的缺点
     * 1.文件比较大
     * 2.恢复速度比RDB慢
     * 3.如果硬盘损坏 可能会丢失最后一次AOF文件更新的数据
     * 4.对于相同的数据集来说 AOF文件的体积通常要大于RDB文件的体积
     * 5.启动时恢复速度慢
     * <p>
     * 可以设置aof文件超过多少字节时重写
     * <p>
     * <p>
     * <p>
     * rdb和aof混合使用
     * 如果两种方式都开启了 那么redis重启时 会优先加载aof文件 aof的优先级比rdb高
     * 如果aof文件损坏了 那么会加载rdb文件
     * 如果两种方式都没有开启 那么redis重启时 会加载rdb文件
     * 如果两种方式都开启了 那么可以通过配置文件设置优先加载rdb文件还是aof文件
     * <p>
     * <p>
     * <p>
     * 纯内存数据库
     * 关闭rdb和aof
     * 1.在配置文件中注释掉所有的save配置 save ""
     * 2.在配置文件中将appendonly设置为no
     * <p>
     * <p>
     * <p>
     * redis事务
     * 事务的本质是一组命令的集合 一个事务中的所有命令都会被序列化 然后按顺序执行
     * 单独的隔离操作
     * 1.事务是一个隔离操作 事务中的所有命令都会序列化 一个事务中的所有命令在执行过程中 不会被其他客户端发送来的命令请求所打断
     * 2.事务在执行的过程中 不会被其他事务所打断
     * 3.事务在队列中的执行是连续的 事务在执行过程中 不会被其他客户端发送来的命令请求所打断
     * 没有隔离级别的概念
     * 不保证原子性
     * redis事务的三个阶段
     * 1.开始事务
     * 2.命令入队
     * 3.执行事务
     * redis事务的三个命令
     * 1.multi 开启事务
     * 2.exec 执行事务
     * 3.discard 取消事务
     * redis事务的三个特性
     * 1.单独的隔离操作
     * 2.没有隔离级别的概念
     * 3.不保证原子性
     * 4.排它性
     * 常用命令
     * 1. watch key 监视key 如果在事务执行之前key被其他命令所改动 那么事务将被打断
     * 2. unwatch 取消监视
     * 3. multi 开启事务
     * 4. exec 执行事务
     * 5. discard 取消事务
     * <p>
     * 采用乐观锁的方式实现watch
     * 1.在执行watch命令时 记录被监视的key的值
     * 2.在执行exec命令时 检查被监视的key是否发生了改变 如果是 则放弃执行事务 否则执行事务
     * 不支持回滚
     * 1.如果事务中的某个命令执行失败 那么其后的命令仍然会被执行
     * 2.在执行exec命令时 如果事务中的某个命令执行失败 那么其后的命令仍然会被执行
     * 3.在执行exec命令时 如果事务中的某个命令执行失败 那么其后的命令不会被执行
     * <p>
     * <p>
     * <p>
     * redis管道 pipeline 可以一次性发送多个命令给服务端 执行完毕后一次性返回结果 不是原子性的
     * 1.减少网络开销
     * 2.批量执行命令
     * 3.减少客户端的压力
     * 4.管道中的命令没有被打断
     * 例子: cmd.txt
     * redis-cli --pipe < cmd.txt
     * redis-cli --pipe < cmd.txt > result.txt
     * redis-cli --pipe < cmd.txt | redis-cli --pipe > result.txt
     * pipeline与原生批量操作的区别
     * 1. 原生批量操作是将多个命令一次性发送给redis服务端，然后服务端一次性返回结果
     * 2. pipeline是将多个命令一次性发送给redis服务端，但是服务端并不是一次性返回结果，而是将命令的执行结果一次性返回给客户端 需要结合linux的管道符号才能一次性返回结果
     * 3. 原生批量操作是原子性的，pipeline不是原子性的
     * pipeline与事物的区别
     * 1. 事物具有原子性，pipeline不具有原子性
     * 2. 事物可以保证事物中的命令被连续执行，pipeline不能保证被连续执行
     * 3. 事物可以保证事物中的命令不会被其他命令打断，pipeline不能保证不会被其他命令打断
     * 注意事项
     * 1. pipeline中的命令不会被打断
     * 2. pipeline中的命令不会被事物所影响
     * 3. pipeline中的命令不会被watch所影响
     * <p>
     * <p>
     * redis发布订阅
     * Redis 的发布/订阅是一种消息传递模式，其中发布者将消息发送到特定的频道，而订阅者则通过订阅这些频道来接收消息。这种模式允许多个订阅者同时接收相同的消息，从而实现了消息的广播。
     * <p>
     * 下面是 Redis 发布/订阅的基本步骤：
     * <p>
     * 订阅者通过执行 SUBSCRIBE 命令来订阅一个或多个频道。例如，订阅者可以执行 SUBSCRIBE channel1 channel2 来同时订阅 channel1 和 channel2 两个频道。
     * <p>
     * 发布者使用 PUBLISH 命令将消息发送到一个或多个频道。例如，发布者可以执行 PUBLISH channel1 "Hello, World!" 将消息 "Hello, World!" 发送到 channel1 频道。
     * <p>
     * 订阅者会在后台持续监听所订阅的频道。一旦有消息发布到已经订阅的频道上，订阅者就会收到消息。
     * <p>
     * 订阅者可以通过执行 UNSUBSCRIBE 命令来取消对某个或所有频道的订阅。例如，订阅者可以执行 UNSUBSCRIBE channel1 来取消对 channel1 频道的订阅。
     * <p>
     * 需要注意的是，Redis 的发布/订阅模式是异步的，发布者和订阅者之间没有直接的交互。发布者只需将消息发送到频道，而不需要知道哪些订阅者正在监听该频道。同样地，订阅者也不需要知道消息来自于哪个发布者。
     * <p>
     * 此外，Redis 还提供了其他一些相关命令和功能，例如：
     * <p>
     * PSUBSCRIBE 和 PUNSUBSCRIBE 命令：用于支持通配符模式的订阅和取消订阅。
     * PUBLISH 命令支持向多个频道同时发布消息。
     * 订阅者可以通过使用 SUBSCRIBE 命令的阻塞模式来等待消息，从而避免了频繁的轮询操作。
     * 总结起来，Redis 的发布/订阅功能允许发布者将消息发送到指定的频道，而订阅者可以选择性地订阅这些频道以接收消息。这种模式可以在分布式系统中实现事件通知、实时消息推送等功能，非常灵活和高效。
     * <p>
     * <p>
     * <p>
     * redis主从复制
     * Redis的主从复制（Master-Slave Replication）是指将一个 Redis 服务器复制到多个 Redis 从服务器上。主服务器会将自己的数据变化同步给从服务器，从服务器一旦接收到数据变化就会立即同步更新自己的数据。
     * <p>
     * 主从复制的流程大致如下：
     * <p>
     * 从服务器连接主服务器并发送SYNC命令请求全量复制（psync命令请求部分复制）；
     * 主服务器接收到SYNC命令后执行BGSAVE操作生成RDB文件，并继续将所有新的写命令发送给从服务器；
     * BGSAVE操作完成后，主服务器将生成的RDB文件发送给从服务器；
     * 从服务器接收到RDB文件后，执行LOAD操作载入数据；
     * 主服务器继续将新的写命令发送给从服务器，从服务器执行这些写命令来保持数据同步。
     * 在主从复制中，主服务器是唯一的写入节点，而从服务器只能被动地接受主服务器的数据更新。主从复制的实现可以提高Redis的性能和可靠性，防止单点故障，同时也可以用于横向扩展Redis服务器的读取性能。
     * <p>
     * 作用
     * 1. 读写分离
     * 2. 容灾恢复
     * 3. 数据备份
     * 4. 水平扩展支撑高并发
     * 如何配置？
     * 配从库不配主库
     * 权限细节: master如果配置了requirepass参数 需要密码登陆
     * 那么salve也需要配置masterauth参数 否则master不允许slave连接
     * 基础配置
     * info replication 查看主从信息
     * replcaof ip port 设置主从关系 主库ip 主库端口 配置文件中配置
     * slaveof ip port 设置主从关系 从库ip 从库端口 命令行配置
     * slaveof no one 取消主从关系
     * <p>
     * <p>
     * <p>
     * <p>
     * redis哨兵
     * Redis Sentinel（哨兵）是 Redis 的高可用性解决方案，它能为 Redis 提供监控、通知以及自动故障迁移等功能。
     * 吹哨人 巡查redis 主机是否正常 根据投票数将主机切换 俗称 无人值守的哨兵机制
     * 作用:
     * 监控redis的运行状态 包括master和slave
     * 当master宕机时 自动将slave切换为master
     * 当master重新启动后 将其作为slave加入到集群中
     * 优点:
     * 哨兵模式是一种无中心化的模式，不存在单点故障，任何一个哨兵出现故障，其他哨兵和Redis实例都能正常工作。
     * 哨兵模式可以实现自动故障转移，当主服务器出现故障时，可以自动将一个从服务器转换为新的主服务器，实现Redis高可用性。
     * 哨兵模式可以实现监控，通过向被监控的Redis实例发送命令，哨兵可以获取Redis实例的信息和状态，以及整个哨兵集群的信息和状态。
     * 哨兵模式可以实现通知，当被监控的Redis实例出现故障时，哨兵可以通过API向管理员或者其他应用程序发送通知。
     * 哨兵模式可以实现配置中心，通过哨兵，管理员可以集中管理多个Redis实例的配置，包括每个实例的数据库数量、每个实例是否持久化以及是否开启只读等。
     * <p>
     * Redis Sentinel 是 Redis 的高可用性解决方案，它可以监控 Redis 服务器的状态，并在主服务器发生故障时自动将一个从服务器提升为新的主服务器。Redis Sentinel 可以对单个 Redis 服务器进行监控，也可以对 Redis 集群进行监控。
     * <p>
     * Sentinel 是一个独立的进程，它通过向 Redis 服务器发送命令来检查服务器是否在线，并及时发现主服务器故障、从服务器故障、网络分区等情况。当发现故障时，Sentinel 会根据预设的规则自动进行故障转移操作，使集群保持高可用性。
     * <p>
     * Redis Sentinel 依赖于 Redis 的发布-订阅功能实现消息通知和故障转移操作，因此 Sentinel 和 Redis 是密切相关的两个组件。Sentinel 可以通过订阅 Redis 发布的消息，实时获取 Redis 服务器的状态信息，并及时做出相应的反应。同时，Redis 服务器也可以通过向 Sentinel 发布消息，告知 Sentinel 其状态信息，以及请求 Sentinel 执行某些操作，如故障转移等。
     * <p>
     * 因此，Sentinel 和 Redis 是互相依赖、紧密配合的两个组件，共同构建了 Redis 的高可用性解决方案。
     * 配置:
     * 哨兵的端口号默认是26379 哨兵一般是单独部署的 一般是奇数个
     * sentinel.conf
     * <p>
     * sentinel monitor mymaster ip port quorum
     * quorum:投票数 一般为哨兵数量的一半加1
     * <p>
     * <p>
     * <p>
     * 哨兵的运行流程和选举机制
     * 哨兵集群部署：在一个Redis Sentinel集群中，通常由多个哨兵节点组成。这些哨兵节点通过互相通信来共同管理一个或多个Redis主服务器和从服务器。
     * <p>
     * 哨兵监控：每个哨兵节点会周期性地向被监控的Redis服务器发送PING命令，以检查服务器是否正常。如果服务器无响应或超过一定时间没有收到PONG回复，哨兵节点会将该服务器标记为下线。
     * <p>
     * 主服务器故障检测：当哨兵节点检测到主服务器不可用时，它们会进入故障检测状态。哨兵节点会通过选举机制决定负责执行故障转移操作的哨兵领导者。
     * <p>
     * 领导者选举：在故障检测状态下，哨兵节点通过使用Raft算法（一种一致性选举算法）进行领导者选举。各个哨兵节点通过相互通信，比较自己的配置版本号和最后一次报告的时间戳，选出一个节点作为领导者。
     * <p>
     * 故障转移：领导者哨兵节点负责执行故障转移操作。它会从可用的从服务器中选择一个作为新的主服务器，并将该信息广播给其他哨兵节点和客户端，使其更新配置。
     * <p>
     * 高可用性恢复：一旦故障转移完成，Redis系统将恢复正常运行。哨兵节点会持续监控主服务器和从服务器的状态，并在必要时进行新一轮的故障检测和故障转移。
     * <p>
     * 总结起来，Redis Sentinel的运行流程是哨兵节点周期性地监控Redis服务器状态，当主服务器故障时，通过选举机制选出领导者哨兵节点，并由其执行故障转移操作，将一个从服务器提升为新的主服务器，从而实现高可用性和自动故障切换。
     * <p>
     * 选取新master的条件
     * 1.优先级最高的slave
     * 2.如果优先级相同，复制偏移量最大的slave
     * 3.如果复制偏移量相同，runid最小的slave
     * 使用建议
     * 1.哨兵的数量最好是奇数个
     * 2.各个哨兵之间的服务器配置要保持一致
     * 3.哨兵集群+主从集群 不一定能保证数据零丢失
     * <p>
     * <p>
     * redis 集群
     * redis 集群是一个分布式的集群，它内置了分片技术，可以将数据分散到多个节点上，每个节点只存储一部分数据，这样每个节点就可以使用较低的内存来存储数据，从而降低了单个节点的内存压力。
     * 集群分片
     * 集群分片是指将数据分散到多个节点上，每个节点只存储一部分数据。Redis 集群使用哈希槽（hash slot）来实现分片，一共有 16384 个哈希槽，每个键通过 CRC16 校验后对 16384 取模来决定放置哪个槽。
     * 槽位最大16384
     * 官方推荐槽位不要超过1000
     * 一致性hash算法
     * 一致性hash算法是一种特殊的哈希算法，它可以将同一个键映射到同一个哈希槽中，从而保证同一个键总是由同一个节点来处理。
     * 将节点映射到哈希环上 0-2^32-1
     * 将键映射到哈希环上
     * key落到的节点就是顺时针找到离key最近的节点
     * 顺时针找到离键最近的节点
     * 优点:
     * 1.增加或删除节点时，只会影响到相邻的节点，对其他节点没有影响
     * 2.当节点数量较少时，数据分布不均匀，但是随着节点数量的增加，数据分布会越来越均匀
     * 缺点:
     * 1.当节点数量较少时，数据分布不均匀
     * <p>
     * 哈希槽分区
     * Redis 集群使用哈希槽（hash slot）来实现分片，一共有 16384 个哈希槽，每个键通过 CRC16 校验后对 16384 取模来决定放置哪个槽。
     * 面试题
     * 为啥redis哈希槽是16384个？
     * 16384 = 2^14
     * 1. 如果槽位是2^16，那么每个节点需要维护一个2^16的槽位数组，占用内存太大 每次发送心跳包会占用大量的带宽 2^16 = 65536  65536/8/1024 = 8KB
     * 如果槽位是2^14，那么每个节点需要维护一个2^14的槽位数组，占用内存太大 每次发送心跳包会占用大量的带宽 2^14 = 16384  16384/8/1024 = 2KB
     * 2. redis的集群节点不会超过1000个，16384个槽位可以保证数据分布均匀
     * 3. 槽位越小 节点越少的情况下 压缩比越高 容易传输
     * <p>
     * 集群扩容
     * 扩容指的是向 Redis Cluster 中增加新的节点。当业务需求增加，集群中的节点无法满足负载时，我们可以通过扩容来增加集群的处理能力。
     * Redis Cluster 的扩容操作相对简单，大致步骤如下：
     * 部署新的 Redis 节点，并设置好节点的端口号和密码等信息。
     * 使用 cluster meet 命令将新节点添加到集群中，并指定其他已有节点的地址和端口号。例如：
     * $ redis-cli -c -p 6379 cluster meet <new_node_ip> <new_node_port>
     * 使用 cluster addslots 命令将新节点负责的槽位分配给新节点。例如：
     * $ redis-cli -c -p 6379 cluster addslots <start_slot> <end_slot>
     * 当新节点接收到数据时，它会向其他节点请求数据，并将其复制到自己的机器上，完成数据迁移。
     * 将新节点添加到业务的负载均衡器中，使其能够参与业务处理。
     * 集群缩容
     * 缩容指的是从 Redis Cluster 中移除一个或多个节点。当业务需求减少，集群中的节点过多时，我们可以通过缩容来降低集群的成本和复杂度。
     * Redis Cluster 的缩容操作相对复杂，需要注意数据迁移和槽位重分配等问题，大致步骤如下：
     * 使用 cluster forget 命令将要移除的节点从集群中删除。例如：
     * $ redis-cli -c -p 6379 cluster forget <node_id>
     * 使用 cluster rebalance 命令重新分配所有槽位的负责节点。例如：
     * $ redis-cli -c -p 6379 cluster rebalance
     * 当某个节点被移除后，如果它负责的槽位没有被合理分配给其他节点，则会导致数据不可用。为了避免这种情况，我们需要在移除节点之前，使用 cluster reshard 命令将节点负责的槽位进行迁移。例如：
     * $ redis-cli -c -p 6379 cluster reshard --cluster-from <node_id> --cluster-to <new_node_id> --cluster-slots <num_slots>
     * 其中，--cluster-from 指定要移除的节点，--cluster-to 指定一个新节点作为迁移目标，--cluster-slots 指定要迁移的槽位数量。
     * 等待数据迁移完成，并确保集群中的每个节点都能正常处理业务请求。
     * 更新业务的负载均衡器配置，确保所有请求都发送到集群中仍然存在的节点上。
     * 需要注意的是，Redis Cluster 的缩容操作需要谨慎处理，否则可能会导致数据丢失或不可用。在进行缩容操作时，建议先备份数据并进行测试，确保整个过程能够成功完成。
     * <p>
     * 面试题
     * 1.redis是单线程还是多线程？
     * redis4.0之前是单线程的，redis4.0之后是支持多线程的 直到redis6.0/7.0之后多线程才是稳定版
     * Redis是单线程 主要是指Redis的网站IO和键值对读写是由一个线程来完成的 Redis在处理客户端的请求时包括获取(socket读) 解析 执行 内容返回(socket写)等过程都是由一个顺序串行的主线程
     * 处理，这就是所谓的单线程。 这也是Redis对外提供的键值存储服务的主要流程
     * 但Redis的其他功能 比如持久化RDB AOF 异步删除 集群数据同步等等 其实是由额外的线程执行的
     * Redis命令工作线程是单线程的 但是整个Redis进程是多线程的
     * 2.redis快的主要原因是什么？
     * 2.1.纯内存操作
     * 2.2.单线程操作，避免了频繁的上下文切换
     * 2.3.采用了非阻塞I/O多路复用机制
     * 2.4.数据结构简单
     * 内存操作速度快：由于 Redis 主要进行内存操作，而内存的读写速度远远快于磁盘操作，因此单线程在这种场景下能够充分利用内存的高速性能。
     * 避免竞争条件：使用单线程可以避免多线程并发访问共享数据时可能出现的竞争条件和锁的开销，简化了并发控制。
     * 原子性操作：Redis 的单线程能够保证每个操作的原子性，这对于实现高效的事务处理和避免并发冲突非常重要。
     * 简化设计和调试：单线程模型使得 Redis 的设计和调试相对简单，降低了复杂性和错误的可能性。
     * 尽管 Redis 主进程是单线程的，但它通过多路复用技术来支持并发处理多个客户端请求，以及通过多个子进程来处理一些耗时的任务，比如持久化和复制。因此，虽然 Redis 是单线程的，但在实际应用中仍然能够达到较高的并发处理能力。
     * 3.主线程和IO线程是如何协作完成请求处理的？
     * 阶段一 服务端和客户端建立Socket链接 并分配处理线程
     * 首先 主线程负责建立连接请求 当有客户端请求和实例建立Socket连接时 主线程会创建和客户端的连接 并把Socket放入全局等待队列中 紧接着主线程会从全局等待队列中取出一个Socket连接分配给IO线程
     * 阶段二 IO线程读取并处理Socket请求
     * 主线程一旦把Socket分配给IO线程 就会进入阻塞状态 等待IO线程完成客户端请求读取和解析 因为有多个IO线程在并行处理 所以这个过程很快就能完成
     * 阶段三 主线程执行请求操作
     * 等到IO线程解析完请求，主线程还是会以单线程的方式执行这些命令操作
     * 阶段四 IO线程回写Socket和主线程清空全局队列
     * 当主线程执行完请求操作后 会把需要返回的结果写入缓冲区 然后主线程会阻塞等待IO线程 把这些结果回写到Socket中 并且返回给客户端 和IO线程读取和解析请求一样 IO线程回写Socket时
     * 也是有多个线程在并发执行，所以 回写Socket的速度也很快 等到IO线程回写完Socket后 主线程会从全局队列中清除这个Socket连接 等待客户端的后续请求
     * 4.Unix网络编程中五大IO模型
     * 4.1 阻塞IO Blocking IO
     * 4.2 非阻塞IO Non-blocking IO
     * 4.3 IO复用 IO multiplexing
     * 4.3.1 FileDescriptor 文件描述符 用来标识一个打开的文件  Linux的世界 一切皆文件
     * 什么是IO多路复用
     * IO多路复用就是通过一种机制 一个进程能同时等待多个文件描述符 一旦某个文件描述符就绪（一般是读就绪或者写就绪）能够通知程序进行相应的读写操作
     * I/O 网络I/O  尤其在操作系统层面指数据在内核态和用户态之间的读写操作
     * 多路 多个客户端连接(连接就是套接字描述符 即socket或者channel)
     * 复用 复用一个或几个线程处理多个客户端连接
     * IO多路复用 一个或一组线程处理多个TCP连接 使用单线程或者少数线程就可以同时处理多个客户端请求 无需创建和维护多个线程
     * 一个服务端线程可以同时处理多个套接字描述符
     * 实现IO多路复用的模型有三种 select poll epoll
     * 4.4 信号驱动IO signal driven IO
     * 4.5 异步IO Asynchronous IO
     * Redis为什么这么快的主要原因是什么？
     * IO多路复用 + epoll的使用 才是Redis快的直接原因
     * 安全相关的问题
     * 禁用危险命令 在redis.conf中设置rename-command CONFIG "" 禁用CONFIG命令
     * 禁用keys *     在redis.conf中设置rename-command KEYS "" 禁用KEYS命令
     * 禁用flushall 在redis.conf中设置rename-command FLUSHALL "" 禁用FLUSHALL命令
     * 禁用flushdb 在redis.conf中设置rename-command FLUSHDB "" 禁用FLUSHDB命令
     * BigKey问题
     * 1.什么是BigKey
     * 阿里巴巴Redis开发规范中定义BigKey是指一个value的大小大于10KB的key 如果是string类型的value 控制在10KB以内 hash list set zset类型的value 控制在5000个元素以内
     * 2.BigKey的危害
     * 内存不均匀 集群迁移时会很慢 造成Redis阻塞 删除超时key时会很慢 造成Redis阻塞 网络流量阻塞
     * 3.如何产生BigKey
     * 社交类 粉丝列表 关注列表
     * 汇总统计 类 产品销售排行榜
     * 4.如何发现BigKey
     * --bigkeys选项
     * redis-cli --bigkeys
     * memory usage key 查看具体的key的内存占用情况
     * 5.如何处理BigKey
     * 非字符串类型的BigKey 不要使用del命令删除 可以使用hscan lscan sscan zscan命令分批次删除
     * SCAN命令
     * SCAN 命令是一个基于游标的迭代器 从指定位置开始遍历集合元素
     * 获取所有键名
     * SCAN 0 会返回下次开始的游标和所有键名
     * 第一个返回值是下次开始的游标  第二个返回值是所有键名
     * 获取所有以“user:”开头的键名
     * SCAN 0 MATCH user:*
     * 每次返回5个键名
     * SCAN 0 COUNT 5
     * 组合使用
     * SCAN 0 MATCH user:* COUNT 5
     * HSCAN命令
     * HSCAN key cursor [MATCH pattern] [COUNT count]
     * LSCAN命令
     * LSCAN key cursor [MATCH pattern] [COUNT count]
     * SSCAN命令
     * SSCAN key cursor [MATCH pattern] [COUNT count]
     * ZSCAN命令
     * ZSCAN key cursor [MATCH pattern] [COUNT count]
     * 6.如何预防BigKey
     * 限制value的大小 控制在10KB以内
     * 控制hash list set zset类型的value的元素个数 控制在5000个元素以内
     * 7.删除BigKey
     * 删除字符串类型的BigKey：使用DEL命令，将键名作为参数传递给该命令。例如，删除键名为mykey的字符串类型BigKey：
     * DEL mykey
     * 删除哈希类型的BigKey：使用HDEL命令，将哈希键和字段名作为参数传递给该命令。例如，删除哈希键为myhash的字段field1和field2：
     * HDEL myhash field1 field2
     * 删除列表类型的BigKey：使用LREM命令，将列表键、要删除的元素个数以及要删除的元素值作为参数传递给该命令。例如，从列表键mylist中删除前10个值为value的元素：
     * LREM mylist 10 value
     * 删除集合类型的BigKey：使用SREM命令，将集合键和要删除的成员值作为参数传递给该命令。例如，从集合键myset中删除值为member1和member2的成员：
     * SREM myset member1 member2
     * 删除有序集合类型的BigKey：使用ZREM命令，将有序集合键和要删除的成员值作为参数传递给该命令。例如，从有序集合键myzset中删除值为member1和member2的成员：
     * ZREM myzset member1 member2
     * 删除字典类型的BigKey：使用DEL命令，将字典键名作为参数传递给该命令。例如，删除字典键名为mydict的字典类型BigKey：
     * DEL mydict
     * 总结 先将BigKey变成小Key 再删除 尽量不要使用DEL命令删除BigKey 先将BigKey变成小Key 再删除
     * BigKey的生产调优
     * 1. redis.conf配置文件中设置lazyfree-lazy-deletes yes  & replica-lazy-flush yes & lazyfree-lazy-user-del yes
     * <p>
     * Redis的缓存双写一致性问题
     * 1.缓存双写一致性问题
     * 先更新数据库 再更新缓存 所有写操作都是以mysql为准 读操作先读缓存 如果缓存没有再读数据库
     * <p>
     * 常见名词
     * UV unique visitor 独立访客
     * PV page view 页面浏览量
     * DAU daily active user 日活跃用户
     * MAU monthly active user 月活跃用户
     * <p>
     * 布隆过滤器
     * 1.什么是布隆过滤器
     * 布隆过滤器是一个占用空间小 且效率高的数据结构 它可以用来判断一个元素是否存在于一个集合中
     * Redis的布隆过滤器是一种用于快速判断某个元素是否可能存在于一个集合中的数据结构。它基于哈希函数和位数组实现，用于解决传统哈希表在处理大量数据时产生的冲突问题。
     * 通过使用布隆过滤器，可以大幅度减少查询大型集合的时间和资源消耗。但需要注意，由于布隆过滤器的特性，它有一定的误判率，即可能会将不存在的元素误认为存在于集合中。因此，在使用布隆过滤器时，需要权衡其优缺点，并根据实际业务需求进行调整。
     * 在Redis中，可以通过使用BITFIELD命令来实现对布隆过滤器的操作，例如设置、查询等。同时，Redis还提供了BF.ADD、BF.EXISTS等命令，用于更方便地操作布隆过滤器。
     * 2.布隆过滤器的原理
     * 布隆过滤器由一个bit数组和一组hash函数组成
     * 3.布隆过滤器的优缺点
     * 优点：空间效率高 查询效率高 高效的插入和查询 内存占用少
     * 缺点：有一定的误判率 不能删除元素 因为删除元素会影响其他元素的判断 不能精确的知道元素是否存在 只能知道元素可能存在
     * 4.布隆过滤器的应用场景
     * 网页爬虫对URL的去重
     * 邮件服务器的垃圾邮件过滤
     * <p>
     * 缓存预热： 缓存预热是指系统上线后，将相关的缓存数据直接加载到缓存系统。这样就可以避免在用户请求时，先查询数据库，然后再将数据缓存的问题。
     * 解决方案： 缓存预热一般在系统上线后进行，将相关的数据直接加载到缓存中，用户直接访问缓存数据。这样就可以避免在用户请求时，先查询数据库，然后再将数据缓存的问题。
     * <p>
     * 缓存穿透： 缓存穿透是指查询一个不存在的数据，由于缓存不命中并且查询也没有命中数据库，导致每次请求都到数据库中查询，这样会对数据库造成很大压力。
     * 解决方案： 缓存穿透的解决方案主要从以下几个方面入手：
     * 1. 空对象缓存或者缺省值：当存储层不存在这个key对应的数据时，仍然将这个空结果进行缓存，但可以设置较短的过期时间。
     * 2. Google 布隆过滤器 Guava Cache 中的实现
     * 示例:
     * public class BloomFilterDemo {
     * public static void main(String[] args) {
     * // 创建布隆过滤器
     * BloomFilter<Integer> filter = BloomFilter.create(Funnels.integerFunnel(), 1000000, 0.01);
     * // 插入数据
     * for (int i = 0; i < 1000000; i++) {
     * filter.put(i);
     * }
     * // 查询数据
     * int count = 0;
     * for (int i = 1000000; i < 2000000; i++) {
     * if (filter.mightContain(i)) {
     * count++;
     * }
     * }
     *
     * <p>
     * 在应用层增加校验，如在查询条件不合法时直接返回错误信息，而不是继续查询。
     * 使用布隆过滤器，在查询缓存和数据库之前对参数进行校验，如果该参数根据布隆过滤器的判断一定不存在，直接返回。
     * 缓存击穿： 缓存击穿是指某个热点数据过期或者被删除了，此时大量并发请求同时涌入，这些请求发现缓存失效后，就会去数据库中查询数据，这样会对数据库造成很大压力。
     * 解决方案：
     * <p>
     * 设置热点数据永久缓存或设置合理的过期时间，防止过期时间集中过快导致缓存击穿。
     * 使用互斥锁避免并发请求同时更新缓存，可以使用 Redis 的 setnx 和 Redisson 等工具实现。
     * 缓存雪崩： 缓存雪崩是指缓存中大量数据同时失效，导致所有请求都落到数据库上，从而导致数据库宕机或瘫痪。
     * 解决方案：
     * <p>
     * 使用多级缓存架构，如本地缓存和分布式缓存结合使用，并设置不同的过期时间，缓解缓存失效风险。
     * 使用限流和熔断等机制，当大量请求涌入时，及时拦截一部分请求，避免对数据库造成过大压力。
     * 在 Redis 中设置数据过期时间时，可以添加一个随机值，减少缓存同时失效的风险。
     * 缓存击穿
     * 缓存击穿是指某个热点数据过期或者被删除了，此时大量并发请求同时涌入，这些请求发现缓存失效后，就会去数据库中查询数据，这样会对数据库造成很大压力。
     * 解决方案：
     * 设置热点数据永久缓存或设置合理的过期时间，防止过期时间集中过快导致缓存击穿。
     * 使用互斥锁避免并发请求同时更新缓存，可以使用 Redis 的 setnx 和 Redisson 等工具实现。
     * 缓存雪崩
     * 缓存雪崩是指缓存中大量数据同时失效，导致所有请求都落到数据库上，从而导致数据库宕机或瘫痪。
     * 解决方案：
     * 使用多级缓存架构，如本地缓存和分布式缓存结合使用，并设置不同的过期时间，缓解缓存失效风险。
     * 使用限流和熔断等机制，当大量请求涌入时，及时拦截一部分请求，避免对数据库造成过大压力。
     * 在 Redis 中设置数据过期时间时，可以添加一个随机值，减少缓存同时失效的风险。
     * 缓存击穿
     * 缓存击穿是指某个热点数据过期或者被删除了，此时大量并发请求同时涌入，这些请求发现缓存失效后，就会去数据库中查询数据，这样会对数据库造成很大压力。
     * 解决方案：
     * 设置热点数据永久缓存或设置合理的过期时间，防止过期时间集中过快导致缓存击穿。
     * 使用互斥锁避免并发请求同时更新缓存，可以使用 Redis 的 setnx 和 Redisson 等工具实现。
     * 差异失效时间 避免缓存雪崩
     * redis分布式锁
     * Redis 分布式锁是一种常见的实现分布式协同操作的技术。它通过在 Redis 中使用一个共享的锁来控制对资源的访问，从而避免多个进程同时修改同一资源而导致的数据不一致问题。下面是 Redis 分布式锁的实现步骤：
     * 使用 Redis 的 SETNX 命令获取锁：
     * SETNX 命令可以将一个键设为一个值，同时如果该键不存在，则设置成功，并返回 1；如果该键已存在，则设置失败，并返回 0。因此我们可以使用 SETNX 命令来尝试获取锁。如果 SETNX 命令返回 1，则表示获取锁成功；否则表示获取锁失败。
     * 设置锁超时时间：
     * 获取锁成功后，可以为这个锁设置一个过期时间（即锁的持有时间）。这样即使分布式系统中的其他线程或进程出现故障或死锁，也可以保证锁自动释放。
     * 释放锁：
     * 当需要释放锁时，可以使用 Redis 的 DEL 命令将锁删除，以便其他进程可以获取该锁。
     * 需要注意的是，Redis 分布式锁并不是万无一失的，也存在着一些问题和限制。例如，如果使用不当，可能会导致死锁或误解锁等问题。因此，在使用 Redis 分布式锁时，需要仔细考虑各种情况，并根据实际应用场景进行调整和优化。
     * 一个靠谱的分布式锁需要具备以下特性：
     * 1. 独占性：在任意时刻，只有一个客户端能持有锁。
     * 2. 高可用性：即使持有锁的客户端崩溃或者网络异常，锁仍然能够被释放。
     * 3. 避免死锁：在任何时刻，只有一个客户端能够获取锁。
     * 4. 不重入：客户端不能获取自己已经持有的锁。
     * 5. 不乱抢锁：客户端不能获取其他客户端已经持有的锁。
     */
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Test
    void test() {
        stringRedisTemplate.opsForValue().set("name", "ambition");
        System.out.println(stringRedisTemplate.opsForValue().get("name"));
    }

}
