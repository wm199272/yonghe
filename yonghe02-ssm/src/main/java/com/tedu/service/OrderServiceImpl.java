package com.tedu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tedu.dao.OrderMapper;
import com.tedu.pojo.Order;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired	//有spring创建对象并为变量赋值
	OrderMapper orderMapper;
	@Override
	public List<Order> findAll() {
		// 1.调用orderMapper的findAll方法查询所有订单
		List<Order> list = orderMapper.findAll();
		return list;
	}
	@Override
	public void deleteById(Integer id) {
		// 1.调用orderMapper的deleteById方法
		orderMapper.deleteById(id);

	}
	@Override
	public void addOrder(Order order) {
		// 1.调用orderMapper的addOrder方法
		orderMapper.addOrder(order);
	}
	@Override
	public Order findById(Integer id) {
		// 1.调用orderMapper的findById方法
		Order order = orderMapper.findById(id);
		return order;
	}
	@Override
	public void updateById(Order order) {
		// 1.调用orderMapper的updateById方法
		orderMapper.updateById(order);
		
	}

}
