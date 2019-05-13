package com.tedu.service;
import java.util.List;
import org.springframework.stereotype.Service;
import com.tedu.pojo.Door;

public interface DoorService {
	/**
	 * 1.查询所有门店信息
	 * @return List<Door>
	 */
	public List<Door> findAll();
	
	/**
	 * 2.新增门店信息
	 * @param door
	 */
	public void addDoor(Door door);
	
	/**
	 * 3.根据id删除指定的门店信息
	 * @param id
	 */
	public void deleteDoorById(Integer id);
	
	/**
	 * 4.根据id查询指定的门店信息
	 * @param id
	 * @return
	 */
	public Door findDoorById(Integer id);
	
	/**
	 * 5.根据id更新指定门店信息
	 * @param door
	 */
	public void updateDoorById(Door door);
}
