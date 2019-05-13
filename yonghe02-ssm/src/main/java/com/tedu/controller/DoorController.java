package com.tedu.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.tedu.pojo.Door;
import com.tedu.service.DoorService;

/* @Controller作用1： 将当前对象的创建交给spring管理
 * 作用2：作为控制层代码的标识
 */
@Controller
public class DoorController {
	
	@Autowired	//自动注入(由spring创建当前对象)
	private DoorService doorService;
	/** 1.添加门店信息 */
	@RequestMapping("/doorList")
	public String doorList(Model model){
		//调用service层的findAll方法，查询所有的门店信息
		List<Door> list = doorService.findAll();
		
		//将所有门店信息的list集合存入model中，带到JSP显示
		model.addAttribute("list", list);
		
		return "door_list";
	}
	
	/** 2.新增门店信息 */
	@RequestMapping("/doorAdd")
	public String doorAdd(Door door){
		//1.调用service层的addDoor方法，新增门店信息
		doorService.addDoor(door);
		//2.重定向到门店列表页面, 显示所有门店信息
		return "redirect:/doorList";
	}
	
	/** 3.删除门店信息 */
	@RequestMapping("/doorDelete")
	public String doorDelete(Integer id){
		//1.调用service层的deleteDoorById方法，删除指定id的门店信息
		doorService.deleteDoorById(id);
		//2.重定向到门店列表页面, 显示所有门店信息
		return "redirect:/doorList";
	}
	
	/** 4.根据id查询门店信息 */
	@RequestMapping("/doorInfo")
	public String doorInfo(Integer id, Model model){
		//1.调用service层的findDoorById方法，根据id查询门店信息
		Door door = doorService.findDoorById(id);
		//2.将门店信息保存到Model中
		model.addAttribute("door", door);
		//3.将门店信息带到door_update.jsp进行回显
		return "door_update";
	}
	
	/** 5.根据id更新门店信息 */
	@RequestMapping("/doorUpdate")
	public String doorUpdate(Door door){
		//1.调用service层的updateDoorById方法，根据id跟新门店信息
		doorService.updateDoorById(door);
		//2.重定向到门店列表页面, 显示所有门店信息
		return "redirect:/doorList";
	}
}
