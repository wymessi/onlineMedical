package cn.hdu.service;

import java.util.List;

import cn.hdu.po.Doctor;
import cn.hdu.po.Page;
import cn.hdu.po.Patient;

public interface UserService {

	// 医生注册
	void doctorRegister(Doctor doctor) throws Exception;

	// 患者注册
	void patientRegister(Patient patient) throws Exception;

	// 医生登录
	Doctor doctorLogin(Doctor doctor) throws Exception;

	// 患者登录
	Patient patientLogin(Patient patient) throws Exception;

	// 更新患者信息
	void updatePatient(Patient patient) throws Exception;

	// 根据id查找患者
	Patient findPatientById(String id) throws Exception;

	// 更新医生信息
	void updateDoctor(Doctor doctor) throws Exception;

	// 根据id查找医生
	Doctor findDoctorById(String id) throws Exception;

	// 根据科室id查找医生
	List<Doctor> findDoctorsByDepartmentId(String departmentId) throws Exception;

	// 根据医生姓名查找医生
	Page<Doctor> findDoctorsByName(String username, String pageNum) throws Exception;

	//每次查询医生时，将热度+1
	void updateHeat(Doctor doctor) throws Exception;

	//根据热度查找热门医生
	List<Doctor> findHotDoctors() throws Exception;

}
