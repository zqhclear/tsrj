package org.tsrj.api.swagger;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tsrj.common.domain.ResultBody;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;


@Api(value="testSwagger", description = "测试第一次")  
@RestController  
@RequestMapping(value="/test")  
public class SwaggerController {  
  
    @RequestMapping(value = "/testOne")
    @ApiOperation(value="根据ID获取用户信息",httpMethod="POST",notes="get user by id")  
    public ResultBody<List<SwaggerDto>> getUser(@ApiParam(required = true, value = "用户信息(id,name)") @RequestBody SwaggerVo vo) {  
    	ResultBody<List<SwaggerDto>> index = new ResultBody<>();
    	SwaggerDto dto = new SwaggerDto();
		dto.setAge(23);
		dto.setDesc("这里是用户的描述");
		dto.setGrade(99);
		dto.setSex(0);
		List<SwaggerDto> list = initList();
		index.setData(list);
    	return index;
    }  
    
    private List<SwaggerDto> initList(){
    	List<SwaggerDto> list = new ArrayList<>();
    	for(int i = 0; i <= 10; i++){
    		SwaggerDto dto = new SwaggerDto();
    		dto.setAge(i);
    		dto.setDesc("第" + i + "个描述");
    		dto.setGrade(100 * i);
    		dto.setSex(i % 2);
    		list.add(dto);
    	}
    	return list;
    }
}  

