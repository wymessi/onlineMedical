package cn.hdu.po;

/**
 * 
 * @author wangye 医生实体
 *
 */
public class Doctor {

	// 唯一标识符，采用UUID
	private String id;
	// 用户名
	private String dusername;
	// 年龄
	private Integer age;
	// 密码
	private String password;
	// 手机号
	private String phone;
	// 邮箱地址
	private String mail;
	// 被查询热度指数
	private Integer heat;
	// 所属医院的实体
	private Hospital Hospital;
	// 所属科室的实体
	private Department department;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDusername() {
		return dusername;
	}

	public void setDusername(String dusername) {
		this.dusername = dusername;
	}


	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getHeat() {
		return heat;
	}

	public void setHeat(Integer heat) {
		this.heat = heat;
	}

	public Hospital getHospital() {
		return Hospital;
	}

	public void setHospital(Hospital hospital) {
		Hospital = hospital;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
}
