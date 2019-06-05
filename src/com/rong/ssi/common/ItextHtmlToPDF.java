package com.rong.ssi.common;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;

import org.jsoup.Jsoup;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontProvider;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;

public class ItextHtmlToPDF {

    public static void main(String[] args) {
		//new ItextHtmlToPDF().createPdf("http://127.0.0.1:8081/DY_PGS/machines.action","123.pdf","123");
		new ItextHtmlToPDF().createPdf("http://127.0.0.1:8081/DY_PGS/xlsx/report.jsp","123.pdf","123","C:/Users/Administrator/Desktop/");

		//htmlCodeToPdf("file:///D:/workspaceForWeb/DY_PGS/WebContent/xlsx/report.html", "file:///C:/Users/Administrator/Desktop/S19011407_201905211559520.pdf"); 
		//gethtml("http://127.0.0.1:8081/DY_PGS/xlsx/report.html");

    }
	
	public static String getHtml(String urlstr){
		String html ="";  
		org.jsoup.nodes.Document doc;
			try {
				doc = Jsoup.parse(new URL(urlstr),10000);
				html = doc.toString();
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return html.toString().replace("<meta charset=\"UTF-8\">", "<meta charset=\"UTF-8\"/>").replace("alt=\"\">", "alt=\"11\"></img>");//alt="">
	}
	public String createPdf(String urlstr,String createReportName,String relCustomNo,String reportPath) {
		try {
			BaseFont bfChinese = BaseFont.createFont("STSongStd-Light", "UniGB-UCS2-H", false);
			Font font = new Font(bfChinese, 18, Font.BOLD);
			
			Document document = new Document(PageSize.A4, 60, 20, 40, 20);
			if(null==createReportName||"".equals(createReportName)){
				createReportName="Report.pdf";
			}
			if(null==relCustomNo||"".equals(relCustomNo)){
				relCustomNo="Report";
			}
			new File(reportPath+"/"+relCustomNo).mkdirs(); 
			
			PdfWriter mPdfWriter = PdfWriter.getInstance(document, new FileOutputStream(reportPath+"/"+relCustomNo+"/"+createReportName));
			document.open();
			document.add(new Paragraph("                    胚胎植入前遗传学筛查（PGS）报告 ", font));
			
			String s ="";
			if(!urlstr.contains("http:127.0.0.1")){
				 s=urlstr.replace("<meta charset=\"UTF-8\">", "<meta charset=\"UTF-8\"/>").replace("alt=\"\">", "alt=\"11\"></img>");//alt=""> ;
			}else{
				s=getHtml(urlstr);
			}
			//String s = getHtmldome();
			System.out.println(s);
			ByteArrayInputStream bin = new ByteArrayInputStream(s.getBytes("UTF-8"));
			XMLWorkerHelper.getInstance().parseXHtml(mPdfWriter, document, bin, Charset.forName("UTF-8"), new ChinaFontProvide());
			document.close();
			mPdfWriter.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return "no";
		} catch (DocumentException e) {
			e.printStackTrace();
			return "no";
		} catch (Exception e) {
			e.printStackTrace();
			return "no";
		}
		return "yes";
	}
 
	public static String getHtmldome() {
		
		StringBuffer html = new StringBuffer();
		html.append("<div style='color:green;font-size:20px;'>你好世界！hello world !</div>");
		html.append("<span style='color:red'>what are you 弄啥咧!</span>");
		html.append("<h1>标题</h1>");
		html.append("<table>");
		html.append("<tr>");
		html.append("<th>序号</th>");
		html.append("<th>用户名</th>");
		html.append("<th>性别</th>");
		html.append("</tr>");
		html.append("<tr>");
		html.append("<td>1</td>");
		html.append("<td>fengxing</td>");
		html.append("<td>男</td>");
		html.append("</tr>");
		html.append("<tr>");
		html.append("<td>2</td>");
		html.append("<td>admin</td>");
		html.append("<td> <img src=\"data:image/png;base64,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\" /></td> ");
		html.append("</tr>");
		html.append("</table>");
		return html.toString();
	}
 
	/**
	 * 
	 * 提供中文
	 * 
	 */
	public static final class ChinaFontProvide implements FontProvider {
 
		@Override
		public Font getFont(String arg0, String arg1, boolean arg2, float arg3, int arg4, BaseColor arg5) {
			BaseFont bfChinese = null;
			try {
				bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
			} catch (Exception e) {
				e.printStackTrace();
			}
			Font FontChinese = new Font(bfChinese, 10, Font.BOLD);
			return FontChinese;
		}
 
		@Override
		public boolean isRegistered(String arg0) {
			return false;
		}
	}
}
