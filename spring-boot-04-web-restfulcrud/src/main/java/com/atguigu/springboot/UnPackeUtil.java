package com.atguigu.springboot;

import java.io.File;
import java.io.FileOutputStream;

import com.github.junrar.Archive;
import com.github.junrar.rarfile.FileHeader;

import net.lingala.zip4j.core.ZipFile;

/**
 * @Description: ��ѹrar/zip������
 * @Date: 2019/1/22
 * @Auther:
 */
public class UnPackeUtil {
	
	/**
     * zip�ļ���ѹ
     *
     * @param destPath ��ѹ�ļ�·��
     * @param zipFile  ѹ���ļ�
     * @param password ��ѹ����(�����)
     */
    public static void unPackZip(File zipFile, String password, String destPath) {
        try {
            ZipFile zip = new ZipFile(zipFile);
            /*zip4jĬ����GBK����ȥ��ѹ,�������ñ���ΪGBK��*/
            zip.setFileNameCharset("GBK");
//            log.info("begin unpack zip file....");
            zip.extractAll(destPath);
            // �����ѹ��Ҫ����
            if (zip.isEncrypted()) {
                zip.setPassword(password);
            }
        } catch (Exception e) {
//            log.error("unPack zip file to " + destPath + " fail ....", e.getMessage(), e);
        }
    }
 
    /**
     * rar�ļ���ѹ(��֧���������ѹ����)
     *
     * @param rarFile  rarѹ����
     * @param destPath ��ѹ����·��
     */
    public static void unPackRar(File rarFile, String destPath) {
        try (Archive archive = new Archive(rarFile)) {
            if (null != archive) {
                FileHeader fileHeader = archive.nextFileHeader();
                File file = null;
                while (null != fileHeader) {
                    // ��ֹ�ļ���������������Ĵ���
                    String fileName = fileHeader.getFileNameW().isEmpty() ? fileHeader.getFileNameString() : fileHeader.getFileNameW();
                    if (fileHeader.isDirectory()) {
                        //���ļ���
                        file = new File(destPath + File.separator + fileName);
                        file.mkdirs();
                    } else {
                        //�����ļ���
                        file = new File(destPath + File.separator + fileName.trim());
                        if (!file.exists()) {
                            if (!file.getParentFile().exists()) {
                                // ���·�����ܶ༶��������Ҫ������Ŀ¼.
                                file.getParentFile().mkdirs();
                            }
                            file.createNewFile();
                        }
                        FileOutputStream os = new FileOutputStream(file);
                        archive.extractFile(fileHeader, os);
                        os.close();
                    }
                    fileHeader = archive.nextFileHeader();
                }
            }
        } catch (Exception e) {
//            log.error("unpack rar file fail....", e.getMessage(), e);
        }
    }


}
