package cn.hdu.service;

import cn.hdu.po.Page;
import cn.hdu.po.Reservation;

public interface ReserveService {

	// 向数据库保存订单
	public void reserve(Reservation reservation) throws Exception;

	// 根据患者id得到与预约单页面分页相关数据
	public Page<Reservation> getPageByPatientId(String patientId, String pageNum) throws Exception;

	// 根据医生id得到与预约单页面分页相关数据
	public Page<Reservation> getPageByDoctorId(String patientId, String pageNum) throws Exception;

	// 根据id查找预约单详细信息
	public Reservation findReservationById(String reservationId) throws Exception;

	//更新预约单状态
	public void updateReservation(Reservation reservation) throws Exception;

}
