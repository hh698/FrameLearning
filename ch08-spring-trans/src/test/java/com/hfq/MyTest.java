package com.hfq;

import com.hfq.service.BuyGoodsService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {

    @Test
    public void test01(){
        String config = "applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        //从容器中获取service
         BuyGoodsService service = (BuyGoodsService) ac.getBean("buyService");

         //调用方法
        service.buy(1002,2);
    }
}
