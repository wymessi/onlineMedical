package cn.hdu.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author wangye
 * 用来处理与预约相关的请求
 */
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.hdu.exception.CustomException;
import cn.hdu.po.Doctor;
import cn.hdu.po.Page;
import cn.hdu.po.Patient;
import cn.hdu.po.Reservation;
import cn.hdu.service.ReserveService;

@Controller
public class ReserveController {

	@Autowired
	@Qualifier("reserveService")
	private ReserveService reserveService;

	// 跳转到预约页面
	@RequestMapping("/reservePage.action")
	public String reservePage(Model model, HttpSession session, String doctorId) throws Exception {
		Patient patient = (Patient) session.getAttribute("patient");
		if (patient == null) {
			throw new CustomException(
					"未登录！！！<meta http-equiv='refresh' content='3;url=/onlineMedical/patientLoginPage.action?isPatient=isPatient'/>将在3秒后跳转到登录，如果没有跳转，请点击<a href='/onlineMedical/patientLoginPage.action?isPatient=isPatient'>去登录</a>");
		}
		model.addAttribute("doctorId", doctorId);
		return "reserve/reserve";
	}

	// 处理预约
	@RequestMapping("/reserve.action")
	public String reserve(Model model, HttpSession session, Reservation reservation) throws Exception {
		Patient patient = (Patient) session.getAttribute("patient");
		if (patient == null) {
			throw new CustomException(
					"未登录！！！<meta http-equiv='refresh' content='3;url=/onlineMedical/patientLoginPage.action?isPatient=isPatient'/>将在3秒后跳转到登录，如果没有跳转，请点击<a href='/onlineMedical/patientLoginPage.action?isPatient=isPatient'>去登录</a>");
		}
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String createTime = format.format(new Date());
		reservation.setCreate_time(createTime);
		reserveService.reserve(reservation);
		model.addAttribute("message",
				"预约单提交成功，请等候医生确认，可前往<a href='/onlineMedical/indexToPatient.action'>个人中心</a>查看预约消息");
		return "message";
	}

	// 前往预约消息页面
	@RequestMapping("/reserveMessageList.action")
	public String reserveMessageList(Model model, HttpSession session, String pageNum) throws Exception {
		Patient patient = (Patient) session.getAttribute("patient");
		Doctor doctor = (Doctor) session.getAttribute("doctor");
		if (patient == null && doctor == null) {
			throw new CustomException(
					"未登录！！！<meta http-equiv='refresh' content='3;url=/onlineMedical/patientLoginPage.action?isPatient=isPatient'/>将在3秒后跳转到登录，如果没有跳转，请点击<a href='/onlineMedical/patientLoginPage.action?isPatient=isPatient'>去登录</a>");
		}
		if (doctor == null) {
			Page<Reservation> page = reserveService.getPageByPatientId(patient.getId(), pageNum);
			if (page == null)
				throw new CustomException("未知错误");
			model.addAttribute("page", page);
		} else {
			Page<Reservation> page = reserveService.getPageByDoctorId(doctor.getId(), pageNum);
			if (page == null)
				throw new CustomException("未知错误");
			model.addAttribute("page", page);
		}

		return "reserve/reserveMessageList";
	}

	// 前往预约消息页面
	@RequestMapping("/reserveMessage.action")
	public String reserveMessage(Model model, HttpSession session, String pageNum, String reservationId)
			throws Exception {
		Patient patient = (Patient) session.getAttribute("patient");
		Doctor doctor = (Doctor) session.getAttribute("doctor");
		if (patient == null && doctor == null) {
			throw new CustomException(
					"未登录！！！<meta http-equiv='refresh' content='3;url=/onlineMedical/patientLoginPage.action?isPatient=isPatient'/>将在3秒后跳转到登录，如果没有跳转，请点击<a href='/onlineMedical/patientLoginPage.action?isPatient=isPatient'>去登录</a>");
		}
		Reservation reservation = reserveService.findReservationById(reservationId);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String reservation_time = format.format(reservation.getReservation_time());
		model.addAttribute("reservation", reservation);
		model.addAttribute("reservation_time", reservation_time);
		return "reserve/reserveMessage";
	}

	// 医生接受预约申请
	@RequestMapping("/handleReservation.action")
	public String handleReservation(Model model, String id, String success) throws Exception {
		Reservation reservation = reserveService.findReservationById(id);
		if (reservation == null) {
			throw new CustomException("未知错误");
		}
		reservation.setSuccess(Integer.parseInt(success));
		reserveService.updateReservation(reservation);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String reservation_time = format.format(reservation.getReservation_time());
		model.addAttribute("reservation", reservation);
		model.addAttribute("reservation_time", reservation_time);
		return "reserve/reserveMessage";
	}

	
}
