package com.tedu.service;

import java.util.List;

import org.springframework.stereotype.Controller;

import com.tedu.pojo.Order;
/**
 * @Controller
 * 作用(1):标识当前类属于Controller层
 * 作用(2):spring会扫描Controller包下
 * @author 000
 *
 */
@Controller
public interface OrderService {
	/**
	 * 1.查询所有门店信息
	 * @return
	 */
	List<Order> findAll();
	/**
	 * 2.根据id删除订单信息
	 */
	void deleteById(Integer id);
	/**
	 * 3.添加订单信息
	 * @param order
	 */
	void addOrder(Order order);
	/**
	 * 4.1.根据id查询信息
	 * @param id
	 * @return
	 */
	Order findById(Integer id);
	/**
	 * 4.2.根据id修改订单
	 * @param order
	 */
	void updateById(Order order);

}
