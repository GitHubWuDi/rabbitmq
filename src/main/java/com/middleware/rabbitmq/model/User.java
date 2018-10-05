package com.middleware.rabbitmq.model;
/**
* @author wudi
* @version 创建时间：2018年10月5日 下午9:23:43
* @ClassName 类名称
* @Description 实体对象
*/
public class User {

	private String id;
	private String name;
	private String sex;
	private Integer age;
	
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
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	
	
}
