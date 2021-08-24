package com.atguigu.springboot.service;

import org.springframework.web.multipart.MultipartFile;

import com.atguigu.springboot.PackParam;
import com.atguigu.springboot.Result.AjaxList;

public interface FileUploadService {
	
	 AjaxList<String> handlerUpload(MultipartFile zipFile,PackParam packParam);
	

}
