package com.tedu.dao;

import java.util.List;

import com.tedu.pojo.Order;

public interface OrderMapper {
	/**
	 * 1.查询所有订单信息
	 * @return
	 */
	List<Order> findAll();

	/**
	 * 2.根据id删除订单信息
	 * @param id
	 */
	void deleteById(Integer id);
	/**
	 * 3.新增订单信息
	 * @param order
	 */
	void addOrder(Order order);
	/**
	 * 4.1根据id查询订单
	 * @param id
	 * @return
	 */
	Order findById(Integer id);
	/**
	 * 4.2根据id修改订单
	 * @param order
	 */
	void updateById(Order order);

}
