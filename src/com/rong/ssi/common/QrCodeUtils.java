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
	            // 1����ȡ�ļ�ת��Ϊ�ֽ�����
	            ByteArrayOutputStream out = new ByteArrayOutputStream();
	            BufferedImage image = toBufferedImage(bitMatrix);
	            //ת����png��ʽ��IO��
	            ImageIO.write(image, "png", out);
	            byte[] bytes = out.toByteArray();

	            // 2�����ֽ�����תΪ������
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
	     * image�����ݴ���
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
        /* jar������  core.jar   javase.jar
                                 ����ͼƬ�����ƴ��룺 String binary = QrCodeUtils.creatRrCode("��ά������", 200,200);
                                 ǰ̨չʾ �� <div id="qrcode"><img src="data:image/png;base64,${binary }"></div>
         */

	    public static void main(String[] args) {
	        String binary = QrCodeUtils.creatRrCode("https://blog.csdn.net/ianly123", 200,200);
	        System.out.println(binary);
	    }
	    /*
		<li><a class="icon"  onClick="printBoxdiv();"  ><span>��ӡ���</span></a></li>
         //dwz ��ӡ���
	    function printBoxdiv(){
	   
	     	 $.printBox('extable');
	    }*/
}
