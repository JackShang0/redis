package com.redis.web;


import com.github.benmanes.caffeine.cache.Cache;
import com.redis.dto.TbItem;
import com.redis.dto.TbItemStock;
import com.redis.service.TbItemService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class TbItemController {

    @Resource
    TbItemService tbItemService;

    @Resource
    Cache<Integer, TbItemStock> itemStockCache;
    @Resource
    Cache<Integer,TbItem> itemCache;

    @Resource
    Cache<String,List<TbItem>> itemCacheAll;


    @GetMapping("selectAll")
    public List<TbItem> selectAll(){
        //return tbItemService.selectAll();
        return itemCacheAll.get("item-all", s -> tbItemService.selectAll());
    }


    @GetMapping("selectById/{id}")
    public TbItem selectById(@PathVariable Integer id){
        //return tbItemService.selectById(id);
        return itemCache.get(id, integer -> tbItemService.selectById(integer));
    }

}
