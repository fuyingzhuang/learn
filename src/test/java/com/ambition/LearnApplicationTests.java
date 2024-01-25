package com.ambition;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.annotation.Resource;

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
     */

    /**
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
     */

    /**
     * rdb和aof混合使用
     * 如果两种方式都开启了 那么redis重启时 会优先加载aof文件 aof的优先级比rdb高
     * 如果aof文件损坏了 那么会加载rdb文件
     * 如果两种方式都没有开启 那么redis重启时 会加载rdb文件
     * 如果两种方式都开启了 那么可以通过配置文件设置优先加载rdb文件还是aof文件
     */

    /**
     * 纯内存数据库
     * 关闭rdb和aof
     * 1.在配置文件中注释掉所有的save配置 save ""
     * 2.在配置文件中将appendonly设置为no
     */

    /**
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
     */

    /**
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
     */
    /**
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
     */

    /**
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
     */


    /**
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
     */
    /**
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
     */
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Test
    void test() {
        stringRedisTemplate.opsForValue().set("name", "ambition");
        System.out.println(stringRedisTemplate.opsForValue().get("name"));
    }

}
