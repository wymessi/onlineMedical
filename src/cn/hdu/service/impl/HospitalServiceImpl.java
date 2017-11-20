package cn.hdu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import cn.hdu.mapper.HospitalMapper;
import cn.hdu.po.Hospital;
import cn.hdu.service.HospitalService;

public class HospitalServiceImpl implements HospitalService {

	@Autowired
	@Qualifier("hospitalMapper")
	private HospitalMapper hospitalMapper;

	// 查出所有医院
	@Override
	public List<Hospital> findAllHospital() throws Exception {
		List<Hospital> hospitals = hospitalMapper.findAllHospital();
		if (hospitals != null) {
			return hospitals;
		}
		return null;
	}

	// 根据姓名查找医院
	@Override
	public Hospital findHospitalByName(String hospitalName) throws Exception {
		Hospital hospital = hospitalMapper.findHospitalByName(hospitalName);
		if (hospital != null) {
			return hospital;
		}
		return null;
	}

	// 根据id查找医院
	@Override
	public Hospital findHospitalById(String id) throws Exception {
		Hospital hospital = hospitalMapper.findHospitalById(id);
		if (hospital != null) {
			return hospital;
		}
		return null;
	}

	//根据热度查找医院
	@Override
	public List<Hospital> findHotHospitals() throws Exception {
		List<Hospital> hotHospitals = hospitalMapper.findHotHospitals();
		if (hotHospitals != null) {
			return hotHospitals;
		}
		return null;
	}

	//每次查询时将热度+1
	@Override
	public void updateHeat(Hospital hospital) {
		hospitalMapper.updateHeat(hospital);
	}
}
