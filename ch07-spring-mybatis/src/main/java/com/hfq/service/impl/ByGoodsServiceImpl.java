package com.hfq.service.impl;

import com.hfq.dao.GoodsDao;
import com.hfq.dao.SaleDao;
import com.hfq.entity.Goods;
import com.hfq.entity.Sale;
import com.hfq.excep.NotEnoughException;
import com.hfq.service.BuyGoodsService;

public class ByGoodsServiceImpl implements BuyGoodsService {
    private SaleDao saleDao;
    private GoodsDao goodsDao;

    public void setSaleDao(SaleDao saleDao) {
        this.saleDao = saleDao;
    }

    public void setGoodsDao(GoodsDao goodsDao) {
        this.goodsDao = goodsDao;
    }

    @Override
    public void buy(Integer goodsId, Integer nums) {
        System.out.println("***buy方法的开始***");
        //记录销售信息
        Sale sale = new Sale();
        sale.setGid(goodsId);
        sale.setNums(nums);
        saleDao.insetSale(sale);

        //更新库存
        Goods goods = goodsDao.selectGoods(goodsId);
        if(goodsId == null ){
            //商品不存在
            throw  new NullPointerException("编号"+goodsId+",商品不存在");
        }else if(goods.getAmount() < nums){
            //商品库存不足
            throw new NotEnoughException("编号"+goodsId+",商品不足");
        }
            //修改库存
        Goods buyGoods =new Goods();
        buyGoods.setId(goodsId);
        buyGoods.setAmount(nums);
        goodsDao.updateGoods(buyGoods);
        System.out.println("***buy方法的结束***");
    }
}
