package com.redis.config;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.redis.dto.TbItem;
import com.redis.dto.TbItemStock;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class CaffeineConfig {
    /**
     * 创建 TbItem的缓存
     * @return caffeine对象
     */
    @Bean
    public Cache<Integer, TbItem> itemCache(){

        return Caffeine.newBuilder()
                .initialCapacity(10_000)    //缓存上限大小为10_000 _是为了方便读取数据
                .maximumSize(100) //最大容量100
                .build();
    }


    @Bean
    public Cache<String, List<TbItem>> itemCacheAll(){

        return Caffeine.newBuilder()
                .initialCapacity(10_000)    //缓存上限大小为10_000 _是为了方便读取数据
                .maximumSize(100) //最大容量100
                .build();
    }

    /**
     * 创建  TbItemStock 对象的缓存
     * @return 缓存
     */
    @Bean
    public Cache<Integer, TbItemStock> itemStockCache(){

        return Caffeine.newBuilder()
                .initialCapacity(10_000)    //缓存上限大小为10_000 _是为了方便读取数据
                .maximumSize(100) //最大容量100
                .build();
    }
}
