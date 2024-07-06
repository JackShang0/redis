package com.redis.config;

import io.lettuce.core.ReadFrom;
import org.springframework.boot.autoconfigure.data.redis.LettuceClientConfigurationBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description: 配置sentinel/redis集群分片情况下的读写分离：主节点负责写入，从节点负责读取
 * @author: shangqj
 * @date: 2024/7/2
 * @version: 1.0
 */
@Configuration
public class LettuceConfig {


    /**
     * 配置redis的sentinel的读取方式 ：向从节点读取数据
     * @return 读取方式
     */
    @Bean
    public LettuceClientConfigurationBuilderCustomizer clientConfigurationBuilderCustomizer(){
        return clientConfigurationBuilder -> clientConfigurationBuilder.readFrom(ReadFrom.REPLICA_PREFERRED);
    }
}
