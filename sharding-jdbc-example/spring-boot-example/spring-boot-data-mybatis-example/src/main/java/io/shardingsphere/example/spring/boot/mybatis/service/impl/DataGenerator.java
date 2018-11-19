package io.shardingsphere.example.spring.boot.mybatis.service.impl;

import io.shardingsphere.example.spring.boot.mybatis.entity.OrderEntity;
import io.shardingsphere.example.spring.boot.mybatis.entity.OrderItemEntity;
import io.shardingsphere.example.spring.boot.mybatis.service.IOrderService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Random;

/**
 * @Author Oliver Wang
 * @Description
 * @Created by IntelliJ IDEA 2018.
 * @Date Create at 2018/11/14 10:11
 */
@Component
public class DataGenerator {
    @Resource
    IOrderService iOrderService;

    public void generateData(int nums){
        Random random = new Random();
        while(nums-- >0){
            long orderId  = random.nextInt(10000);

            OrderEntity orderEntity = new OrderEntity();
            OrderItemEntity orderItemEntity = new OrderItemEntity();

            orderEntity.setOrderId(orderId);
            orderEntity.setUserId(100000-nums);
            orderEntity.setStatus("Waiting for paying");
            iOrderService.addOrder(orderEntity);

            orderItemEntity.setOrderItemId(random.nextLong());
            orderItemEntity.setOrderId(100000L-nums);
            orderItemEntity.setUserId(orderEntity.getUserId());
        }
    }
}
