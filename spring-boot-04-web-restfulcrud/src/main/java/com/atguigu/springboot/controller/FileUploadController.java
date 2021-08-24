package com.atguigu.springboot.controller;
 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.atguigu.springboot.PackParam;
import com.atguigu.springboot.Result.AjaxList;
import com.atguigu.springboot.service.FileUploadService;

 
/**
 * @Description:
 * @Date: 2019/1/22
 * @Auther: 
 */
 
@Controller
public class FileUploadController {
 
    @Autowired
    private FileUploadService fileUploadService;
 
    @GetMapping("/upload")
    public String uploadZip() {
    	MultipartFile zipFile=null;
    	PackParam packParam = new PackParam();
        AjaxList<String> ajaxList = fileUploadService.handlerUpload(zipFile, packParam);
        return ajaxList.getData();
    }
    
//    @PostMapping("/upload")
//    @ResponseBody
//    public String uploadZip(MultipartFile zipFile, @RequestBody PackParam packParam) {
//    	MultipartFile zipFile = new MultipartFile();
//    	AjaxList<String> ajaxList = fileUploadService.handlerUpload(zipFile, packParam);
//    	return ajaxList.getData();
//    }
    
    @GetMapping("/upload/zip")
    public String  list(Model model){
        return "emp/index";
    }
}