package com.rong.ssi.common;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Hashtable;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;

import Decoder.BASE64Encoder;

public class QrCodeUtils {

 

	    public static String creatRrCode(String contents, int width, int height) {
	        String binary = null;
	        Hashtable hints = new Hashtable();
	        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
	        try {
	            BitMatrix bitMatrix = new MultiFormatWriter().encode(
	                    contents, BarcodeFormat.QR_CODE, width, height, hints);
	            // 1、读取文件转换为字节数组
	            ByteArrayOutputStream out = new ByteArrayOutputStream();
	            BufferedImage image = toBufferedImage(bitMatrix);
	            //转换成png格式的IO流
	            ImageIO.write(image, "png", out);
	            byte[] bytes = out.toByteArray();

	            // 2、将字节数组转为二进制
	            BASE64Encoder encoder = new BASE64Encoder();
	            binary = encoder.encodeBuffer(bytes).trim();
	        } catch (WriterException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        } catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        return binary;
	    }

	    /**
	     * image流数据处理
	     *
	     * @author ianly
	     */
	    public static BufferedImage toBufferedImage(BitMatrix matrix) {
	        int width = matrix.getWidth();
	        int height = matrix.getHeight();
	        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	        for (int x = 0; x < width; x++) {
	            for (int y = 0; y < height; y++) {
	                image.setRGB(x, y, matrix.get(x, y) ? 0xFF000000 : 0xFFFFFFFF);
	            }
	        }
	        return image;
	    }
        /* jar包括：  core.jar   javase.jar
                                 生成图片二进制代码： String binary = QrCodeUtils.creatRrCode("二维码内容", 200,200);
                                 前台展示 ： <div id="qrcode"><img src="data:image/png;base64,${binary }"></div>
         */

	    public static void main(String[] args) {
	        String binary = QrCodeUtils.creatRrCode("https://blog.csdn.net/ianly123", 200,200);
	        System.out.println(binary);
	    }
	    /*
		<li><a class="icon"  onClick="printBoxdiv();"  ><span>打印表格</span></a></li>
         //dwz 打印表格
	    function printBoxdiv(){
	   
	     	 $.printBox('extable');
	    }*/
}
