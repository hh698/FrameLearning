package com.hfq.dao;

import com.hfq.entity.Goods;

public interface GoodsDao {
    //更新库存
    //goods表示本次顾客购买的商品的信息 id 购买数量
    int updateGoods(Goods goods);

    //查询商品信息
    Goods selectGoods(Integer id);
}
