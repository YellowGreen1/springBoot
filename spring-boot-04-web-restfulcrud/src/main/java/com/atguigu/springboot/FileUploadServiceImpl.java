package com.atguigu.springboot;
 
import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.atguigu.springboot.Result.AjaxList;
import com.atguigu.springboot.enums.FileTypeEnum;
import com.atguigu.springboot.service.FileUploadService;

import lombok.extern.slf4j.Slf4j;
 
/**
 * @Description:
 * @Date: 2019/1/22
 * @Auther: 
 */
@Service
@Slf4j
public class FileUploadServiceImpl implements FileUploadService {
 
    @Override
    public AjaxList<String> handlerUpload(MultipartFile zipFile, PackParam packParam) {
 
        if (null == zipFile) {
            return AjaxList.createFail("请上传压缩文件!");
        }
        boolean isZipPack = true;
        String fileContentType = zipFile.getContentType();
        //将压缩包保存在指定路径
        String packFilePath = packParam.getDestPath() + File.separator + zipFile.getName();
        if (FileTypeEnum.FILE_TYPE_ZIP.type.equals(fileContentType)) {
            //zip解压缩处理
            packFilePath += FileTypeEnum.FILE_TYPE_ZIP.fileStufix;
        } else if (FileTypeEnum.FILE_TYPE_RAR.type.equals(fileContentType)) {
            //rar解压缩处理
            packFilePath += FileTypeEnum.FILE_TYPE_RAR.fileStufix;
            isZipPack = false;
        } else {
            return AjaxList.createFail("上传的压缩包格式不正确,仅支持rar和zip压缩文件!");
        }
        File file = new File(packFilePath);
        try {
            zipFile.transferTo(file);
        } catch (IOException e) {
//            log.error("zip file save to " + packParam.getDestPath() + " error", e.getMessage(), e);
            return AjaxList.createFail("保存压缩文件到:" + packParam.getDestPath() + " 失败!");
        }
        if (isZipPack) {
            //zip压缩包
            UnPackeUtil.unPackZip(file, packParam.getPassword(), packParam.getDestPath());
        } else {
            //rar压缩包
            UnPackeUtil.unPackRar(file, packParam.getDestPath());
        }
        return AjaxList.createSuccess("解压成功");
    }
}