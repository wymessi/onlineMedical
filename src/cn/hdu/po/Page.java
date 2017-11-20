package cn.hdu.po;

/**
 * 与分页相关的实体
 * @author wangye
 *
 */
import java.util.List;

public class Page<T> {

	// 当前页
	private int pageNum;

	// 总记录数
	private int totalRecord;

	// 页面一次显示的数目
	private int pageSize = 2;

	// 总共有多少页
	private int totalPage;

	// 从那条记录开始查询
	private int startIndex;

	// 页面最左边开始页
	private int startPage;

	// 页面最右边结束页
	private int endPage;

	// 针对某实体查询的实体集合
	private List<T> list;

	// 由于使用接口代理的方式，mybatis只能接收一个参数，故添加username，patientId,实现查询
	private String username;

	private String patientId;
	
	private String doctorId;
	
	public String getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
	}

	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Page(int pageNum, int totalRecord) {

		this.pageNum = pageNum;
		this.totalRecord = totalRecord;

		this.totalPage = (this.totalRecord + this.pageSize - 1) / this.pageSize;
		this.startIndex = (this.pageNum - 1) * this.pageSize;

		if (this.totalPage <= 10) {
			this.startPage = 1;
			this.endPage = this.totalPage;
		} else {
			this.startPage = this.pageNum - 4;
			this.endPage = this.pageNum + 5;

			if (this.startPage < 1) {
				this.startPage = 1;
				this.endPage = 10;
			}
			if (this.endPage > this.totalPage) {
				this.endPage = this.totalPage;
				this.startPage = this.totalPage - 9;
			}
		}

	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

}
