package cn.hdu.mapper;

import java.util.List;

import cn.hdu.po.Illness;

public interface IllnessMapper {

	//根据科室id查找疾病
	public List<Illness> findIllnessesByDepartmentId(String departmentId) throws Exception;

	//根据疾病ID查找illness
	public Illness findIllnessById(String illnessId) throws Exception;

	//根据疾病名称查找illness
	public Illness findillnessByName(String name) throws Exception;

	//查找热门疾病
	public List<Illness> findHotIllnesses();

	//每次查询医院时，将热度+1
	public void updateHeat(Illness illness);

}
