package com.redis.service.impl;


import com.redis.dto.TbItem;
import com.redis.mapper.TbItemMapper;
import com.redis.service.TbItemService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class TbItemServiceImpl implements TbItemService {


    @Resource
    TbItemMapper tbItemMapper;


    @Override
    public List<TbItem> selectAll() {
        return tbItemMapper.selectList(null);
    }

    @Override
    public TbItem selectById(Integer id) {
        return tbItemMapper.selectById(id);
    }
}
