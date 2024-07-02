package com.redis.config;

import io.lettuce.core.ReadFrom;
import org.springframework.boot.autoconfigure.data.redis.LettuceClientConfigurationBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description:
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
