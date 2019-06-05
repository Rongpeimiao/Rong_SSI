package com.rong.ssi.common;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import org.xhtmlrenderer.pdf.ITextFontResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;

//import com.itextpdf.text.pdf.BaseFont;
import com.lowagie.text.pdf.BaseFont;

public class htmlToPdf2 {

	  public static void main(String[] args) {
		  try {
			htmlToPdf2("C:/Users/Administrator/Desktop/123.pdf","http://127.0.0.1:8081/DY_PGS/createPdfhtml.action");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	    }
	/**
     * 把URL转换为PDF
     * @return
     * @throws Exception
     */
    public static boolean htmlToPdf2(String outputFile, String url)
            throws Exception {
        File outFile = new File(outputFile);
        if (!outFile.exists()) {
            outFile.getParentFile().mkdirs();
        }
        OutputStream os = new FileOutputStream(outputFile);
        ITextRenderer renderer = new ITextRenderer();
        renderer.setDocument(url);
        String fontPath="D:/workspaceForWeb/DY_PGS/WebContent/xlsx/simsun.ttc";
        // 解决中文支持问题
        ITextFontResolver fontResolver = renderer.getFontResolver();
        fontResolver.addFont(fontPath, BaseFont.IDENTITY_H,BaseFont.NOT_EMBEDDED);
        renderer.layout();
        renderer.createPDF(os);
        os.flush();
        os.close();
        System.out.println("文件转换成功");
        return true;
    }
}
