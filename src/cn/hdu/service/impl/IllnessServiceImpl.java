package cn.hdu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import cn.hdu.mapper.IllnessMapper;
import cn.hdu.po.Illness;
import cn.hdu.service.IllnessService;

public class IllnessServiceImpl implements IllnessService {

	@Autowired
	@Qualifier("illnessMapper")
	private IllnessMapper illnessMapper;
	
	//根据科室id查找疾病
	@Override
	public List<Illness> findIllnessesByDepartmentId(String departmentId) throws Exception {
		List<Illness> illnesses = illnessMapper.findIllnessesByDepartmentId(departmentId);
		if (illnesses != null) {
			return illnesses;
		}
		return null;
	}
	
	//根据疾病ID查找illness
	@Override
	public Illness findIllnessById(String illnessId) throws Exception{
		Illness illness = illnessMapper.findIllnessById(illnessId);
		if (illness != null) {
			return illness;
		}
		return null;
	}

	//根据疾病名称查找illness
	@Override
	public Illness findillnessByName(String name) throws Exception {
		Illness illness = illnessMapper.findillnessByName(name);
		if (illness != null) {
			return illness;
		}
		return null;
	}

	//查找热门疾病
	@Override
	public List<Illness> findHotIllnesses() throws Exception {
		List<Illness> hotIllnesses = illnessMapper.findHotIllnesses();
		if (hotIllnesses != null) {
			return hotIllnesses;
		}
		return null;
	}

	//每次查询医院时，将热度+1
	@Override
	public void updateHeat(Illness illness) {
		illnessMapper.updateHeat(illness);
		
	}

}
