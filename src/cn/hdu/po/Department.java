package cn.hdu.po;

/**
 * 
 * @author wangye 科室实体
 *
 */
public class Department {

	// 唯一标识符，采用UUID
	private String id;
	// 科室名
	private String departmentName;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDepartmentName() {
		return departmentName;
	}


	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	
}
