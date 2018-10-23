package org.tsrj.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tsrj.model.member.Member;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ClassReLoader extends ClassLoader {
    private static final Logger LOG = LoggerFactory.getLogger(ClassReLoader.class);
    private String classPath;
    private String className = "compile.zqh";

    public ClassReLoader(String classPath) {
        this.classPath = classPath;
    }

    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] classData = getData(name);
        if (classData == null) {
            throw new ClassNotFoundException();
        } else {
            return defineClass(className, classData, 0, classData.length);
        }
    }

    private byte[] getData(String name) {
        String path = classPath + name;
        try {
            InputStream inputStream = new FileInputStream(path);
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            byte[] buffer = new byte[2048];
            int num = 0;
            while ((num = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, num);
            }
            return outputStream.toByteArray();
        } catch (IOException e) {
            LOG.error("解析类{}异常{}", name, e);
        }
        return null;
    }

    public static void main(String[] args) {
        try {
            String path = "D";
            ClassReLoader classReLoader = new ClassReLoader(path);
            Class r = classReLoader.findClass("");
            System.out.println(r.newInstance());

            ClassReLoader classReLoader1 = new ClassReLoader(path);
            Class r1 = classReLoader1.findClass("");
            System.out.println(r1.newInstance());
        }catch (Exception e){
            LOG.error("main方法异常：{}", e);
        }
    }
}
