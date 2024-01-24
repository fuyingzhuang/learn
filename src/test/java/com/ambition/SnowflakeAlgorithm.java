package com.ambition;

/**
 * Snowflake算法
 * 雪花算法的核心思想是将一个64位的整数ID划分成多个部分，每个部分代表不同的信息。以下是雪花算法ID的结构：
 * <p>
 * 符号位（1位）：始终为0，表示正数。
 * 时间戳部分（41位）：精确到毫秒级别的时间戳，可以使用系统时间或自定义起始时间。由于41位的时间戳可以支持约70年的使用期限。
 * 工作机器ID（10位）：用于标识不同的工作节点，可以分配给不同的机器或进程。在分布式系统中，每个节点需要保证唯一性。
 * 序列号部分（12位）：表示同一毫秒内生成的序列号，如果在同一毫秒内生成的ID达到了4096个（2^12），则需要等待下一毫秒再生成。
 * 通过将时间戳、工作机器ID和序列号组合在一起，就可以生成全局唯一的ID。雪花算法具有以下优点：
 * <p>
 * 唯一性：生成的ID具有全局唯一性，不同机器、进程或时间生成的ID不会重复。
 * 有序性：ID中包含了时间戳信息，因此生成的ID基本上是按照时间顺序递增的，方便数据库索引和查询。
 * 高性能：生成ID的过程非常快速，不依赖于网络等外部因素。
 * 分布式支持：可以在分布式系统中使用，不同节点可以通过工作机器ID区分。
 */
public class SnowflakeAlgorithm {
    public static void main(String[] args) {
    }
}
