package com.atguigu.spring.resource;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;

public class FileSourceExample {
    public static void main(String[] args) {

        try {
            String filePath = "D://BugReport.txt";
            //系统文件路径方式加载文件
            Resource res1 = new FileSystemResource(filePath);

            //使用类路径加载资源文件

            Resource res2 = new ClassPathResource("new.txt");
            InputStream in1 = res1.getInputStream();
            InputStream in2 = res2.getInputStream();
            System.out.println("res1:"+res1.getFilename());
            System.out.println("res2:"+res2.getFilename());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
