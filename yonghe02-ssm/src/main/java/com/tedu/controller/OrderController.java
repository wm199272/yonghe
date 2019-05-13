package com.tedu.controller;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
/**
 * @Controller 
 * 作用1:标识当前类属于Controller层
 * 作用2:spring会扫描Controller包下所有带有@Controller注解的类
 * 将类注册到spring容器中(即由spring容器创建实例)	
 * @author 000
 *
 */
import org.springframework.web.bind.annotation.RequestMapping;

import com.tedu.pojo.Door;
import com.tedu.pojo.Order;
import com.tedu.service.DoorService;
import com.tedu.service.OrderService;
@Controller
public class OrderController {
	@Autowired //由spring创建实例并为变量赋值
	DoorService doorService;
	@Autowired  //由spring创建实例并为变量赋值
	OrderService orderService;
	/**
	 * 1.查询所有订单信息
	 * @return
	 */
	@RequestMapping("/orderList")
	public String orderList(Model model){
		//1.调用orderService层的findAll方法,查询所有订单
		List<Order> list = orderService.findAll();
		//2.将所有订单的list集合存入model中(存入request域中)
		model.addAttribute("list",list);
		//转向订单列表页面
		return "order_list";
	}

	/**
	 * 2.根据id删除订单信息
	 */
	@RequestMapping("/orderDelete")
	public String orderDelete(Integer id){
		//1.调用orderService的deleteById方法,根据id删除订单信息
		orderService.deleteById(id);
		//转向查询所有订单的方法
		return "redirect:/orderList";
	}

	/**
	 * 3.1.查询所有门店并跳转到订单新增页面
	 */
	@RequestMapping("/findAllDoorToOrder_add")
	public String toOrder_Add(Model model){
		//1.调用doorService的findAll方法查询所有门店
		List<Door> list = doorService.findAll();
		//2.将所有门店列表存入Model中
		model.addAttribute("list",list);
		//3.转向订单新增页面
		return "order_add";
	}

	/**
	 * 3.2.新增订单
	 */
	@RequestMapping("/orderAdd")
	public String orderAdd(Order order){
		//1.调用OrderService的addOrder方法,添加订单信息
		orderService.addOrder(order);
		//转向 查询所有订单的方法
		return "redirect:/orderList";
	}

	/**
	 * 4.1.根据id查询订单信息
	 */
	@RequestMapping("/orderInfo")
	public String orderInfo(Integer id,Model model){
		//1.调用orderService方法中的findById
		Order order = orderService.findById(id);
		//2.将订单信息存入model中
		model.addAttribute("order",order);
		
		//3.调用doorService的findall方法查询所有门店信息
		List<Door> list = doorService.findAll();
		model.addAttribute("list",list);
		//4.转向订单修改页面
		return "order_update";
	}
	/**
	 * 4.2.根据id修改订单信息
	 */
	@RequestMapping("/orderUpdate")
	public String orderUpdate(Order order){
		//1.调用OrderService的updateById
		orderService.updateById(order);
		//转向查询所有订单的方法
		return "redirect:/orderList";
	}
	
	
	/* 自定义日期转换格式 
	@InitBinder
	public void InitBinder (ServletRequestDataBinder binder){
		binder.registerCustomEditor(java.util.Date.class, 
			new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true)
		);
	}*/

}
