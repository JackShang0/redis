package com.redis.service;

import com.redis.dto.TbItem;

import java.util.List;

public interface TbItemService {

    List<TbItem> selectAll();

    TbItem selectById(Integer id);
}
