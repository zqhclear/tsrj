package org.tsrj.api.swagger;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by zhongqionghua on 2018/03/07.
 *
 * @author zhongqionghua
 * @version V2.0
 */
@ApiModel(value = "用户信息")
public class SwaggerVo {

    @ApiModelProperty(value = "用户id", required = true)
    private Long userId;
    @ApiModelProperty(value = "昵称", required = true)
    private String userName;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}