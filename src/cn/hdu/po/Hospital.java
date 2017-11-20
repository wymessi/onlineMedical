package cn.hdu.po;

/**
 * 
 * @author wangye 医院实体
 *
 */
public class Hospital {

	// 唯一标识符，采用UUID
	private String id;
	// 医院姓名
	private String hospitalName;

	// 医院地址
	private String location;
	// 医院简介
	private String description;
	// 被查询热度指数
	private Integer heat;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getHeat() {
		return heat;
	}

	public void setHeat(Integer heat) {
		this.heat = heat;
	}

}
