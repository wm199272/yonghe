package com.tedu.dao;

import java.util.List;

import com.tedu.pojo.Door;

public interface DoorMapper {
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
	 * 4.根据id查询门店信息
	 * @param id
	 */
	public Door findDoorById(Integer id);
	
	/**
	 * 5.根据id更新门店信息
	 * @param door
	 */
	public void updateDoorById(Door door);
	
}
