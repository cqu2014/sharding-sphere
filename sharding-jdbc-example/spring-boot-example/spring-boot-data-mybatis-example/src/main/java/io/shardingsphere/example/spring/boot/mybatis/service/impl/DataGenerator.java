package io.shardingsphere.example.spring.boot.mybatis.service.impl;

import io.shardingsphere.example.spring.boot.mybatis.entity.OrderEntity;
import io.shardingsphere.example.spring.boot.mybatis.entity.OrderItemEntity;
import io.shardingsphere.example.spring.boot.mybatis.service.IOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Random;

/**
 * @Author Oliver Wang
 * @Description
 * @Created by IntelliJ IDEA 2018.
 * @Date Create at 2018/11/14 10:11
 */
@Slf4j
@Component
public class DataGenerator {
    @Resource
    IOrderService iOrderService;

    public void generateData(int nums){
        while(nums-- >0){
            long orderId = generateTaskId();
            OrderEntity orderEntity = new OrderEntity();
            OrderItemEntity orderItemEntity = new OrderItemEntity();

            orderEntity.setOrderId(orderId);
            orderEntity.setUserId(100000-nums);
            orderEntity.setStatus("Waiting for paying");
            iOrderService.addOrder(orderEntity);

            orderItemEntity.setOrderId(orderId);
            orderItemEntity.setOrderId(orderId);
            orderItemEntity.setUserId(orderEntity.getUserId());
            iOrderService.addOrderItem(orderItemEntity);
        }
    }

    /**
     * 生成taskid 系统当前时间毫秒+""+四位随机数
     *
     * @return
     */
    private long generateTaskId(){
        try {
            Long now = System.currentTimeMillis();
            Random random = new Random();
            int randNum = random.nextInt(9999)+10000;
            String randStr = String.valueOf(now)+String.valueOf(randNum);
            return Long.parseLong(randStr);
        }catch (Exception e){
            log.error("生成随机的taskId失败");
            return System.currentTimeMillis();
        }
    }

}
