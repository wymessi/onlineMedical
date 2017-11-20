package cn.hdu.mapper;

import java.util.List;

import cn.hdu.po.Page;
import cn.hdu.po.Reservation;

public interface ReserveMapper {

	// 向数据库保存订单
	public void reserve(Reservation reservation) throws Exception;

	//根据患者id得到其相关订单的总数
	public int getTotalRecordByPatientId(String patientId) throws Exception;

	//根据患者id分页查询订单信息
	public List<Reservation> findReservationsByPatientId(Page<Reservation> page) throws Exception;

	//根据id查找预约单详细信息
	public Reservation findReservationById(String reservationId) throws Exception;

	// 根据医生id得到与预约单页面分页相关数据
	public int getTotalRecordByDoctorId(String doctorId) throws Exception;

	//根据医生id分页查询订单信息
	public List<Reservation> findReservationsByDoctorId(Page<Reservation> page) throws Exception;

	//更新预约单状态
	public void updateReservation(Reservation reservation) throws Exception;
}
