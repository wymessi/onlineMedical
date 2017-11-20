package cn.hdu.mapper;

import java.util.List;

import cn.hdu.po.Hospital;

public interface HospitalMapper {

	// 查出所有医院
	List<Hospital> findAllHospital() throws Exception;

	// 根据姓名查找医院
	Hospital findHospitalByName(String hospitalName) throws Exception;

	// 根据id查找医院
	Hospital findHospitalById(String id) throws Exception;

	//根据热度查找医院
	List<Hospital> findHotHospitals() throws Exception;

	//每次查询时将热度+1
	void updateHeat(Hospital hospital);

}
