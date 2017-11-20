package cn.hdu.po;

/**
 * 疾病类实体
 * 
 * @author wangye
 *
 */
public class Illness {

	// 唯一标识符，采用UUID
	private String id;
	// 疾病名称
	private String name;
	// 疾病简介
	private String description;
	// 被查询热度指数
	private Integer heat;

	public Integer getHeat() {
		return heat;
	}

	public void setHeat(Integer heat) {
		this.heat = heat;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}