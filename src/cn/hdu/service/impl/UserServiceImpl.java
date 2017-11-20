package cn.hdu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import cn.hdu.mapper.UserMapper;
import cn.hdu.po.Doctor;
import cn.hdu.po.Page;
import cn.hdu.po.Patient;
import cn.hdu.service.UserService;

public class UserServiceImpl implements UserService {

	@Autowired
	@Qualifier("userMapper")
	private UserMapper userMapper;

	// 医生注册
	@Override
	public void doctorRegister(Doctor doctor) throws Exception {

		userMapper.doctorRegister(doctor);
	}

	// 患者注册
	@Override
	public void patientRegister(Patient patient) throws Exception {

		userMapper.patientRegister(patient);
	}

	// 医生登录
	@Override
	public Doctor doctorLogin(Doctor d) throws Exception {
		Doctor doctor = userMapper.doctorLogin(d);
		if (doctor != null) {
			return doctor;
		}
		return null;
	}

	// 患者登录
	@Override
	public Patient patientLogin(Patient p) throws Exception {
		Patient patient = userMapper.patientLogin(p);
		if (patient != null) {
			return patient;
		}
		return null;
	}

	// 更新患者信息
	@Override
	public void updatePatient(Patient patient) throws Exception {
		userMapper.updatePatient(patient);

	}

	// 根据id查找患者
	@Override
	public Patient findPatientById(String id) throws Exception {
		Patient patient = userMapper.findPatientById(id);
		if (patient != null) {
			return patient;
		}
		return null;
	}

	// 更新医生信息
	@Override
	public void updateDoctor(Doctor doctor) throws Exception {
		userMapper.updateDoctor(doctor);
	}

	// 根据id查找医生
	@Override
	public Doctor findDoctorById(String id) throws Exception {
		Doctor doctor = userMapper.findDoctorById(id);
		if (doctor != null) {
			return doctor;
		}
		return null;
	}

	// 根据科室id查找医生
	@Override
	public List<Doctor> findDoctorsByDepartmentId(String departmentId) throws Exception {
		List<Doctor> doctors = userMapper.findDoctorsByDepartmentId(departmentId);
		if (doctors != null) {
			return doctors;
		}
		return null;
	}

	// 根据医生姓名查找医生
	@Override
	public Page<Doctor> findDoctorsByName(String username, String pageNum) throws Exception {
		
		int totalRecord=userMapper.getTotalRecord(username);
		Page<Doctor> page = null;
		if(pageNum==null){
			page = new Page<Doctor>(1,totalRecord);
		}else{
			page = new Page<Doctor>(Integer.parseInt(pageNum),totalRecord);
		}
		page.setUsername(username);
		List<Doctor> doctors = userMapper.findDoctorsByName(page);
		page.setList(doctors);
		if (doctors != null) {
			return page;
		}
		return null;
	}

	//每次查询医生时，将热度+1
	@Override
	public void updateHeat(Doctor doctor) throws Exception {
		
		userMapper.updateHeat(doctor);
		
	}

	//根据热度查找热门医生
	@Override
	public List<Doctor> findHotDoctors() throws Exception {
		List<Doctor> hotDoctors = userMapper.findHotDoctors();
		if(hotDoctors != null){
			return hotDoctors;
		}
		return null;
	}

}
