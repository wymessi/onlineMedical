package cn.hdu.po;

import java.util.Date;

public class Reservation {

	// 唯一id
	private String id;

	// 预约时间
	private Date reservation_time;

	// 预约单生成时间
	private String create_time;

	// 预约成功与否 0 不成功 1成功 2待医生审核
	private int success;

	// 大概症状
	private String symptom;

	// 关联医生
	private String doctorId;

	// 关联患者
	private String patientId;

	// 关联医生实体
	private Doctor doctor;

	// 关联患者实体
	private Patient patient;

	public Doctor getDoctor() {
		return doctor;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public String getDoctorId() {
		return doctorId;
	}

	public String getPatientId() {
		return patientId;
	}

	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public String getId() {
		return id;
	}

	public Date getReservation_time() {
		return reservation_time;
	}

	public int getSuccess() {
		return success;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setReservation_time(Date reservation_time) {
		this.reservation_time = reservation_time;
	}

	public void setSuccess(int success) {
		this.success = success;
	}

	public String getSymptom() {
		return symptom;
	}

	public void setSymptom(String symptom) {
		this.symptom = symptom;
	}

	public String getCreate_time() {
		return create_time;
	}

	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}

}
