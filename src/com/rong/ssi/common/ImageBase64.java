package com.rong.ssi.common;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import Decoder.BASE64Decoder;
import Decoder.BASE64Encoder;
//��ͼƬ�ļ�ת��Ϊ�ֽ������ַ��������������Base64���봦��  
public class ImageBase64 {

	public static String GetImageStr(String imgFile)  
    {
        InputStream in = null;  
        byte[] data = null;  
        //��ȡͼƬ�ֽ�����  
        try   
        {  
            in = new FileInputStream(imgFile);          
            data = new byte[in.available()];  
            in.read(data);  
            in.close();  
        }   
        catch (IOException e)   
        {  
            e.printStackTrace();  
        }  
        //���ֽ�����Base64����  
        BASE64Encoder encoder = new BASE64Encoder();
        System.out.println(encoder.encode(data));
        return encoder.encode(data);//����Base64��������ֽ������ַ���  
    }  
	public static boolean GenerateImage(String base64str,String savepath)  
    {   //���ֽ������ַ�������Base64���벢����ͼƬ  
        if (base64str == null) //ͼ������Ϊ��  
            return false;  
       // System.out.println("��ʼ����");
        BASE64Decoder decoder = new BASE64Decoder();  
        try   
        {  
            //Base64����  
            byte[] b = decoder.decodeBuffer(base64str);  
          //  System.out.println("�������");
            for(int i=0;i<b.length;++i)  
            {  
                if(b[i]<0)  
                {//�����쳣����  
                    b[i]+=256;  
                }  
            }
           // System.out.println("��ʼ����ͼƬ");
            //����jpegͼƬ  
            OutputStream out = new FileOutputStream(savepath);      
            out.write(b);  
            out.flush();  
            out.close();  
            return true;  
        }   
        catch (Exception e)   
        {  
            return false;  
        }  
    }
	public static void main(String[] args) {
		GetImageStr("D:/workspaceForWeb/DY_PGS/WebContent/images/baidu.png");
	}
}
