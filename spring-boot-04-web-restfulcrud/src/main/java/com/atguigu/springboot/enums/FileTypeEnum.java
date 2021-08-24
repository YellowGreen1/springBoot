package com.atguigu.springboot.enums;
 
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
 
/**
 * @Description: ѹ���ļ�����
 * @Date: 2019/1/22
 * @Auther:
 */
@AllArgsConstructor
@NoArgsConstructor
public enum FileTypeEnum {
    FILE_TYPE_ZIP("application/zip", ".zip"),
    FILE_TYPE_RAR("application/octet-stream", ".rar");
    public String type;
    public String fileStufix;
 
    public static String getFileStufix(String type) {
        for (FileTypeEnum orderTypeEnum : FileTypeEnum.values()) {
            if (orderTypeEnum.type.equals(type)) {
                return orderTypeEnum.fileStufix;
            }
        }
        return null;
    }

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getFileStufix() {
		return fileStufix;
	}

	public void setFileStufix(String fileStufix) {
		this.fileStufix = fileStufix;
	}

	private FileTypeEnum(String type, String fileStufix) {
		this.type = type;
		this.fileStufix = fileStufix;
	}
	
}
