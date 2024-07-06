package com.redis.dto;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("tb_item_stock")
public class TbItemStock {

    String item_id;
    String stock;
    String sold;
}
