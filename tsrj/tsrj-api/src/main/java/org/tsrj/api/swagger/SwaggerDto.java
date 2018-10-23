package org.tsrj.api.swagger;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by zhongqionghua on 2018/03/07.
 *
 * @author zhongqionghua
 * @version V2.0
 */
@ApiModel(value = "用户个人信息")
public class SwaggerDto implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = -2776541093173846242L;
	@ApiModelProperty(value = "用户等级")
    private Integer grade;
    @ApiModelProperty(value = "用户年龄")
    private Integer age;
    @ApiModelProperty(value = "用户性别")
    private Integer sex;
    @ApiModelProperty(value = "用户描述")
    private String desc;
    @ApiModelProperty(value = "是否认证")
    private boolean isReal;
	public boolean isReal() {
		return isReal;
	}
	public void setReal(boolean isReal) {
		this.isReal = isReal;
	}
	public Integer getGrade() {
		return grade;
	}
	public void setGrade(Integer grade) {
		this.grade = grade;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}

}