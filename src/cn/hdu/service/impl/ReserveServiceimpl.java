package cn.hdu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import cn.hdu.mapper.ReserveMapper;
import cn.hdu.po.Page;
import cn.hdu.po.Reservation;
import cn.hdu.service.ReserveService;

public class ReserveServiceimpl implements ReserveService {

	@Autowired
	@Qualifier("reserveMapper")
	private ReserveMapper reserveMapper;

	// 向数据库保存订单
	public void reserve(Reservation reservation) throws Exception {
		reserveMapper.reserve(reservation);
	}

	// 得到与预约单页面分页相关数据
	@Override
	public Page<Reservation> getPageByPatientId(String patientId, String pageNum) throws Exception {
		int totalRecord = reserveMapper.getTotalRecordByPatientId(patientId);
		Page<Reservation> page = null;
		if (pageNum == null) {
			page = new Page<Reservation>(1, totalRecord);
		} else {
			page = new Page<Reservation>(Integer.parseInt(pageNum), totalRecord);
		}
		page.setPatientId(patientId);
		List<Reservation> reservations = reserveMapper.findReservationsByPatientId(page);
		page.setList(reservations);
		if (reservations != null) {
			return page;
		}
		return null;
	}

	//根据id查找预约单详细信息
	@Override
	public Reservation findReservationById(String reservationId) throws Exception {
		Reservation reservation = reserveMapper.findReservationById(reservationId);
		if(reservation != null)
			return reservation;
		return null;
	}

	// 根据医生id得到与预约单页面分页相关数据
	@Override
	public Page<Reservation> getPageByDoctorId(String doctorId, String pageNum) throws Exception {
		int totalRecord = reserveMapper.getTotalRecordByDoctorId(doctorId);
		Page<Reservation> page = null;
		if (pageNum == null) {
			page = new Page<Reservation>(1, totalRecord);
		} else {
			page = new Page<Reservation>(Integer.parseInt(pageNum), totalRecord);
		}
		page.setDoctorId(doctorId);
		List<Reservation> reservations = reserveMapper.findReservationsByDoctorId(page);
		page.setList(reservations);
		if (reservations != null) {
			return page;
		}
		return null;
	}

	//更新预约单状态
	@Override
	public void updateReservation(Reservation reservation) throws Exception {
		
		reserveMapper.updateReservation(reservation);
		
	}

}
