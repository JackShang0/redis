package com.redis.web;


import com.redis.dto.TbItem;
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

    @GetMapping("selectAll")
    public List<TbItem> selectAll(){
        return tbItemService.selectAll();
    }


    @GetMapping("selectById/{id}")
    public TbItem selectById(@PathVariable Integer id){
        return tbItemService.selectById(id);
    }

}
