package io.shardingsphere.example.spring.boot.mybatis.repository;

import io.shardingsphere.example.spring.boot.mybatis.entity.OrderItemEntity;
import org.springframework.stereotype.Repository;

@Repository("OrderItemEntityMapper")
public interface OrderItemEntityMapper {
    int deleteByPrimaryKey(Long orderItemId);

    int insert(OrderItemEntity record);

    int insertSelective(OrderItemEntity record);

    OrderItemEntity selectByPrimaryKey(Long orderItemId);

    int updateByPrimaryKeySelective(OrderItemEntity record);

    int updateByPrimaryKey(OrderItemEntity record);
}