package cn.hdu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.hdu.exception.CustomException;
import cn.hdu.po.Department;
import cn.hdu.po.Doctor;
import cn.hdu.po.Hospital;
import cn.hdu.po.Illness;
import cn.hdu.service.DepartmentService;
import cn.hdu.service.HospitalService;
import cn.hdu.service.IllnessService;
import cn.hdu.service.UserService;

/**
 * @author wangye 用于所有与科室有关的操作
 */

@Controller
public class DepartmentController {

	@Autowired
	@Qualifier("departmentService")
	private DepartmentService departmentService;
	
	@Autowired
	@Qualifier("illnessService")
	private IllnessService illnessService;
	
	@Autowired
	@Qualifier("userService")
	private UserService userService;
	
	@Autowired
	@Qualifier("hospitalService")
	private HospitalService hospitalService;
	
	//根据医院id查出该医院所有的科室
	@RequestMapping("/findAllDepartmentByhospitalId")
	public String findAllDepartmentByhospitalId(Model model, String hospitalId) throws Exception{
		List<Department> departments = departmentService.findAllDepartmentByhospitalId(hospitalId);
		Hospital hospital = hospitalService.findHospitalById(hospitalId);
		if(departments == null || hospital ==null){
			throw new CustomException("数据库操作异常!");
		}
		model.addAttribute("departments", departments);
		model.addAttribute("hospital", hospital);
		return "department/departments";
	}
	
	//根据科室id查出该科室所有的医生以及疾病
	@RequestMapping("/departmentDetail")
	public String departmentDetail(Model model, String departmentId) throws Exception{
		List<Doctor> doctors = userService.findDoctorsByDepartmentId(departmentId);
		List<Illness> illnesses = illnessService.findIllnessesByDepartmentId(departmentId);
		if(doctors == null || illnesses == null)
			throw new CustomException("数据库异常!");
		model.addAttribute("doctors", doctors);
		model.addAttribute("illnesses", illnesses);
		return "department/departmentDetail";
	}
}
