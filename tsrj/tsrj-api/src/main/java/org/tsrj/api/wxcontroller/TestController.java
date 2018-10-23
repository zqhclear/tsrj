package org.tsrj.api.wxcontroller;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tsrj.api.controller.BaseController;
import org.tsrj.common.domain.ResultBody;

@RequestMapping("/test")
@RestController
public class TestController extends BaseController {
	
	private String uploadPath = "F:\fileupload";
	@RequestMapping("/test")
	public ResultBody test(HttpServletRequest request) throws Exception{
        DiskFileItemFactory factory = new DiskFileItemFactory();  

        factory.setSizeThreshold(4096); // 设置缓冲区大小，这里是4kb  
        File tempPathFile = null; 
        factory.setRepository(tempPathFile);// 设置缓冲区目录  

        ServletFileUpload upload = new ServletFileUpload(factory);  

        upload.setSizeMax(1024 * 1024 * 2); // 设置最大文件尺寸，这里是2MB  

        List<FileItem> items = upload.parseRequest(request);// 得到所有的文件  
        Iterator<FileItem> i = items.iterator();  
        while (i.hasNext()) {  
            FileItem fi = (FileItem) i.next();  
            String fileName = fi.getName();  
            if (fileName != null) {  
                File fullFile = new File(new String(fi.getName().getBytes(), "utf-8")); // 解决文件名乱码问题  
                File savedFile = new File(uploadPath, fullFile.getName());  
                fi.write(savedFile); 
            }  
        }  
        System.out.print("upload succeed");
        return new ResultBody<>("upload success");
	}
}
