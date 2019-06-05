package com.rong.ssi.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @describe ѹ������ļ�
 * @author zfc
 */
public class ZipMultiFile {

    public static void main(String[] args) {
        File[] srcFiles = { new File("C:\\Users\\Administrator\\Desktop\\ReportRoot\\S19010307\\S19010307_201905291005200.pdf"),
        					new File("C:\\Users\\Administrator\\Desktop\\ReportRoot\\S19010307\\S19010307_201905290934410.pdf")};
        File zipFile = new File("C:\\Users\\Administrator\\Desktop\\ReportRoot\\S19010307\\ZipFile.zip");
        // ����ѹ������
        zipFiles(srcFiles, zipFile);
    }

    public static String zipFiles(File[] srcFiles, File zipFile) {
        // �ж�ѹ������ļ����ڲ����������򴴽�
        if (!zipFile.exists()) {
            try {
                zipFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // ���� FileOutputStream ����
        FileOutputStream fileOutputStream = null;
        // ���� ZipOutputStream
        ZipOutputStream zipOutputStream = null;
        // ���� FileInputStream ����
        FileInputStream fileInputStream = null;

        try {
            // ʵ���� FileOutputStream ����
            fileOutputStream = new FileOutputStream(zipFile);
            // ʵ���� ZipOutputStream ����
            zipOutputStream = new ZipOutputStream(fileOutputStream);
            // ���� ZipEntry ����
            ZipEntry zipEntry = null;
            // ����Դ�ļ�����
            for (int i = 0; i < srcFiles.length; i++) {
                // ��Դ�ļ������еĵ�ǰ�ļ����� FileInputStream ����
                fileInputStream = new FileInputStream(srcFiles[i]);
                // ʵ���� ZipEntry ����Դ�ļ������еĵ�ǰ�ļ�
                zipEntry = new ZipEntry(srcFiles[i].getName());
                zipOutputStream.putNextEntry(zipEntry);
                // �ñ�����¼ÿ�����������ֽڸ���
                int len;
                // ����ÿ�ζ�ȡ���ֽ�����
                byte[] buffer = new byte[1024];
                while ((len = fileInputStream.read(buffer)) > 0) {
                    zipOutputStream.write(buffer, 0, len);
                }
            }
            zipOutputStream.closeEntry();
            zipOutputStream.close();
            fileInputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
		return zipFile.getName();

    }
}