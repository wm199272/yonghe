package com.tedu.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tedu.dao.DoorMapper;
import com.tedu.pojo.Door;

@Service
public class DoorServiceImpl implements DoorService {
	@Autowired //自动注入(由spring创建当前对象)
	private DoorMapper doorMapper;
	
	@Override
	public List<Door> findAll() {
		//调用DoorMapper的findAll方法，查询所有门店信息
		List<Door> list = doorMapper.findAll();
		//将所有门店信息的List集合返回
		return list;
	}

	@Override
	public void addDoor(Door door) {
		//调用DoorMapper的addDoor方法，新增门店信息
		doorMapper.addDoor(door);
	}
	
	@Override
	public void deleteDoorById(Integer id) {
		//调用DoorMapper的deleteDoorById方法，根据id删除指定的门店信息
		doorMapper.deleteDoorById(id);
	}

	@Override
	public Door findDoorById(Integer id) {
		//调用DoorMapper的findDoorById方法，根据id查询门店信息
		Door door = doorMapper.findDoorById(id);
		return door;
	}

	@Override
	public void updateDoorById(Door door) {
		//调用DoorMapper的updateDoorById方法，根据id更新门店信息
		doorMapper.updateDoorById(door);
	}
}
