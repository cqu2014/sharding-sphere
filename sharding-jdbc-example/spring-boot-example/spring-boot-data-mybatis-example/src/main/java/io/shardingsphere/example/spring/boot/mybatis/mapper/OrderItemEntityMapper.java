package io.shardingsphere.example.spring.boot.mybatis.mapper;

import io.shardingsphere.example.spring.boot.mybatis.entity.OrderItemEntity;
import org.apache.ibatis.annotations.Mapper;
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