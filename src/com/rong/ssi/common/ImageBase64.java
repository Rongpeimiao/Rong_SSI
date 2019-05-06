package com.rong.ssi.common;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import Decoder.BASE64Decoder;
import Decoder.BASE64Encoder;
//将图片文件转化为字节数组字符串，并对其进行Base64编码处理  
public class ImageBase64 {

	public static String GetImageStr(String imgFile)  
    {
        InputStream in = null;  
        byte[] data = null;  
        //读取图片字节数组  
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
        //对字节数组Base64编码  
        BASE64Encoder encoder = new BASE64Encoder();
        System.out.println(encoder.encode(data));
        return encoder.encode(data);//返回Base64编码过的字节数组字符串  
    }  
	public static boolean GenerateImage(String base64str,String savepath)  
    {   //对字节数组字符串进行Base64解码并生成图片  
        if (base64str == null) //图像数据为空  
            return false;  
       // System.out.println("开始解码");
        BASE64Decoder decoder = new BASE64Decoder();  
        try   
        {  
            //Base64解码  
            byte[] b = decoder.decodeBuffer(base64str);  
          //  System.out.println("解码完成");
            for(int i=0;i<b.length;++i)  
            {  
                if(b[i]<0)  
                {//调整异常数据  
                    b[i]+=256;  
                }  
            }
           // System.out.println("开始生成图片");
            //生成jpeg图片  
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
