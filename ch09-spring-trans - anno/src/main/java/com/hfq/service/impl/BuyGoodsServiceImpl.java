package com.hfq.service.impl;

import com.hfq.dao.GoodsDao;
import com.hfq.dao.SaleDao;
import com.hfq.entity.Goods;
import com.hfq.entity.Sale;
import com.hfq.excep.NotEnoughException;
import com.hfq.service.BuyGoodsService;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class BuyGoodsServiceImpl implements BuyGoodsService {
    private SaleDao saleDao;
    private GoodsDao goodsDao;

    public void setSaleDao(SaleDao saleDao) {
        this.saleDao = saleDao;
    }

    public void setGoodsDao(GoodsDao goodsDao) {
        this.goodsDao = goodsDao;
    }

    /**
     *rollbackFor:表示发生指定的异常一定回滚
     * 处理逻辑：1.spring框架会首先检查方法抛出的异常是否在rollbackFor的属性值中
     *          如果异常在rollbackFor列表中，不管是什么类型的异常，一定回滚
     *          2.如果你抛出的异常不在rollbackFor列表中，spring会判断异常是否是RuntimeException，
     *          如果是，一定回滚
     */
//    @Transactional(
//            propagation = Propagation.REQUIRED,
//            isolation = Isolation.DEFAULT,
//            readOnly = false,
//            rollbackFor = {NullPointerException.class,NotEnoughException.class}
//    )
    @Transactional//使用事务控制的默认值
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
