package com.atguigu.springboot;
 
import lombok.Data;
 
/**
 * @Description: 上传压缩的参数
 * @Date: 2019/1/23
 * @Auther: 
 */
@Data
public class PackParam {
    /**
     * 解压密码
     */
    private String password;
 
    /**
     * 解压文件存储地址
     */
    private String destPath;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDestPath() {
		return destPath;
	}

	public void setDestPath(String destPath) {
		this.destPath = destPath;
	}
    
    
    
}