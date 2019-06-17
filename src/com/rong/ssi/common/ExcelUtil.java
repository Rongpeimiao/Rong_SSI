package com.rong.ssi.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFClientAnchor;
import org.apache.poi.xssf.usermodel.XSSFDrawing;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.sun.org.apache.xml.internal.security.utils.Base64;

public class ExcelUtil {

	public ExcelUtil() {
		// TODO Auto-generated constructor stub
	}
	/**
     * 通过文件路径直接修改文件名
     * 
     * @param filePath    需要修改的文件的完整路径
     * @param newFileName 需要修改的文件的名称
     * @return
     */
    private static String FixFileName(String filePath, String newFileName) {
        File f = new File(filePath);
        if (!f.exists()) { // 判断原文件是否存在（防止文件名冲突）
            return null;
        }
        newFileName = newFileName.trim();
        if ("".equals(newFileName) || newFileName == null) // 文件名不能为空
            return null;
        String newFilePath = null;
        if (f.isDirectory()) { // 判断是否为文件夹
            newFilePath = filePath.substring(0, filePath.lastIndexOf("/")) + "/" + newFileName;
        } else {
            newFilePath = filePath.substring(0, filePath.lastIndexOf("/")) + "/" + newFileName
                    + filePath.substring(filePath.lastIndexOf("."));
        }
        File nf = new File(newFilePath);
        try {
            f.renameTo(nf); // 修改文件名
        } catch (Exception err) {
            err.printStackTrace();
            return null;
        }
        return newFilePath;
    }
    
    /**
     * 读取Excel数据内容
     * @param InputStream
     * @return List<Map<String, String>>  Map的key是列Id(0代表第一列)，值是具体内容
     * @throws IOException 
     */
    public List<Map<Integer, String>> readExcelContentByList(InputStream is) throws IOException {
        
        List<Map<Integer, String>> list = new ArrayList<Map<Integer,String>>();

        POIFSFileSystem ps = new POIFSFileSystem(is);  //使用POI提供的方法得到excel的信息   
        HSSFWorkbook wb = new HSSFWorkbook(ps);
        try {
            //fs = new POIFSFileSystem(is);
            wb = new HSSFWorkbook(is);
            //wb = new XSSFWorkbook(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        HSSFSheet sheet = wb.getSheetAt(0);
        HSSFRow row;
        // 得到总行数
        int rowNum = sheet.getLastRowNum();
        row = sheet.getRow(0);
        int colNum = row.getPhysicalNumberOfCells();
        
        // 正文内容应该从第二行开始,第一行为表头的标题
        for (int i = 1; i <= rowNum; i++) {
        	String valueCell="";
            row = sheet.getRow(i);
            int j = 0;
            Map<Integer,String> map = new HashMap<Integer, String>();
            
            while (j < colNum) {
                // 每个单元格的数据内容用"-"分割开，以后需要时用String类的replace()方法还原数据
                // "-";
            	if(j==0){
            		valueCell=row.getCell((short) j).toString().trim().replaceAll("\t\r", "");
            	}else{
            		valueCell=valueCell+"-"+row.getCell((short) j).toString().trim().replaceAll("\t\r", "");
            	}
                //str += getCellFormatValue(row.getCell((short) j)).trim() + "    ";
                j++;
            }
            map.put(j, valueCell.trim().replaceAll("\t\r", ""));
            list.add(map);
        }
        return list;
    }
    
    /**
	 * 导入excel
	 * 
	 * @param xlsPath
	 *            导入文件路径
	 * @return temp List<String[]>
	 */
     //HSSFWorkbook:是操作Excel2003以前（包括2003）的版本，扩展名是.xls 
    //XSSFWorkbook:是操作Excel2007的版本，扩展名是.xlsx
    //读取第几个 Excel 页   sheetNUM 
    //读取  Excel 页中的头部有几行，数据从第几行开始  sheetHeadNUM 
	public static List<String[]> loadExcel(File xlsPath,Integer sheetNUM,Integer sheetHeadNUM) throws IOException {
		List temp = new ArrayList();
		FileInputStream fileIn = new FileInputStream(xlsPath);
		Workbook wb0 = new XSSFWorkbook(fileIn);
		
		Sheet sht0 = wb0.getSheetAt(sheetNUM);
		for (Row r : sht0) {
			if (r.getRowNum() < sheetHeadNUM) {
				continue;
			}
			String[] info = new String[r.getLastCellNum()];
			for (int i = 0; i < r.getLastCellNum(); i++) {
				if (r.getCell(i) != null) {
					if (r.getCell(i).getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
						info[i] = r.getCell(i).getNumericCellValue() + "";
					} else {
						info[i] = r.getCell(i).getStringCellValue();

					}
				} else {
					info[i] = "";
				}
			}
			temp.add(info);
		}
		fileIn.close();
		return temp;
	}
	
	public static String imagesBase64toXSSFWorkbook(String base64str,String savepath)	{
		String result = new String();
	        // 声明一个工作薄
	        XSSFWorkbook wb = new XSSFWorkbook();
	        // 生成一个样式  
	        XSSFCellStyle style = wb.createCellStyle();
	        //样式字体居中
	        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
	        
	        //声明第一个sheet名称
	        XSSFSheet sheet1 = wb.createSheet("cs");

		List<byte[]> images = new ArrayList<>();
				
		// 必须去除每个base64前面的"data:image/png;base64,"这22个字符
		try {
			images.add(Base64.decode(base64str));
		} catch  (Exception e) {
			e.printStackTrace();
		}
					
					//设置宽高
					  sheet1.setDefaultRowHeight((short)(350*30/25));
				      sheet1.setColumnWidth( (int)(400*1990/140), 0);
					
					  //将获取到的base64 编码转换成图片，画到excel中
					  XSSFDrawing patriarch  =sheet1.createDrawingPatriarch();
						XSSFClientAnchor anchor=null;
						int index=0;
						for(byte[] image:images){
							anchor = new XSSFClientAnchor(0,0,0,0,(short) (8*(index%3)),((index/3)*18),(short)(7+8*(index%3)),									16+((index/3)*18)); 
							patriarch.createPicture(anchor, wb.addPicture(image, XSSFWorkbook.PICTURE_TYPE_PNG));
							index++;
						}
						// 工程路径（根据个人需要，路径可以写简单的磁盘路径）
						String fileName = savepath+"csvfile.xlsx";
						File file = new File(fileName);
						if (file.isFile()) {
							file.delete();
						}
						
						// 规定的路径下，生成excel表格
						FileOutputStream output = null;
						try {
							output = new FileOutputStream(fileName);
							wb.write(output);
							output.flush();
							output.close();
						}catch (FileNotFoundException e) {
								e.printStackTrace();
							} catch (IOException e) {
								try {
									if (output != null) {
										output.close();
									}
								} catch (Exception e1) {
									e1.printStackTrace();
								}
							}
	
	       	return fileName;//返回excel的路径到js中的window.location.herf ，触发浏览器的下载功能
}
	
	//base64图片导入工作薄
	public static String getBase64(String base64str,String savepath)	{
		String result = new String();
	        // 声明一个工作薄
	        XSSFWorkbook wb = new XSSFWorkbook();
	        // 生成一个样式  
	        XSSFCellStyle style = wb.createCellStyle();
	        //样式字体居中
	        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
	        
	        //声明第一个sheet名称
	        XSSFSheet sheet1 = wb.createSheet("cs");
	        Row row;
	         row = sheet1.createRow((short)(1)); //创建行    
	         row.createCell(0).setCellValue(11); //设置第一个（从0开始）单元格的数据
	         row.createCell(1).setCellValue(2);
	         row.createCell(2).setCellValue(3);
	         row.createCell(3).setCellValue(4);
	         row.createCell(4).setCellValue(5);	
	         row.createCell(5).setCellValue(6);		 
	         row.createCell(6).setCellValue(7); 
	         
	         
	         
	       /*  Row row;
		        row = sheet1.createRow((short)(0)); //创建行    
		        row.createCell(0).setCellValue("样本总数 （录入）"); //设置第一个（从0开始）单元格的数据
		        CellRangeAddress region=new CellRangeAddress(0, 1, 0, 0);
		        sheet1.addMergedRegion(region);
		        row.createCell(1).setCellValue("已完成"); //设置第一个（从0开始）单元格的数据
		        region=new CellRangeAddress(0, 0, 1, 4);
		        sheet1.addMergedRegion(region);
		        row.createCell(5).setCellValue("未完成"); //设置第一个（从0开始）单元格的数据
		        region=new CellRangeAddress(0, 0, 5, 11);
		        sheet1.addMergedRegion(region);*/
		List<byte[]> images = new ArrayList<>();
				
		// 必须去除每个base64前面的"data:image/png;base64,"这22个字符
		try {
			images.add(Base64.decode(base64str));
		} catch  (Exception e) {
			e.printStackTrace();
		}
					
					//设置宽高
					  sheet1.setDefaultRowHeight((short)(350*30/25));
				      sheet1.setColumnWidth( (int)(400*1990/140), 0);
					
					  //将获取到的base64 编码转换成图片，画到excel中
					  XSSFDrawing patriarch  =sheet1.createDrawingPatriarch();
						XSSFClientAnchor anchor=null;
						int index=0;
						for(byte[] image:images){
							anchor = new XSSFClientAnchor(0,0,0,0,(short) (8*(index%3)),5+((index/3)*18),(short)(20+8*(index%3)),16+((index/3)*18)); 
							patriarch.createPicture(anchor, wb.addPicture(image, XSSFWorkbook.PICTURE_TYPE_PNG));
							index++;
						}
						// 工程路径（根据个人需要，路径可以写简单的磁盘路径）
						String fileName = savepath+"csvfile.xlsx";
						File file = new File(fileName);
						if (file.isFile()) {
							file.delete();
						}
						
						// 规定的路径下，生成excel表格
						FileOutputStream output = null;
						try {
							output = new FileOutputStream(fileName);
							wb.write(output);
							output.flush();
							output.close();
						}catch (FileNotFoundException e) {
								e.printStackTrace();
							} catch (IOException e) {
								try {
									if (output != null) {
										output.close();
									}
								} catch (Exception e1) {
									e1.printStackTrace();
								}
							}
	
	       	return fileName;//返回excel的路径到js中的window.location.herf ，触发浏览器的下载功能
}
	
    public static void main(String[] args) throws Exception {
    	// String fullFileName = getServletContext().getRealPath("/xlsx/" + filename);  
    	///DY_PGS/WebContent/xlsx/BasicInfoExport_01.xlsx
    	//FixFileName("D:/workspaceForWeb/DY_PGS/WebContent/xlsx/BasicInfoExport_02.xlsx","BasicInfoExport_01");
    	System.out.println("fix");
    	
    	FileInputStream fs = new FileInputStream("D:/workspaceForWeb/DY_PGS/WebContent/xlsx/BasicInfoExport_02.xlsx");  //获取已有的Excel  
        Workbook wb = new XSSFWorkbook(fs);    
        Sheet sheet1 = wb.getSheetAt(0);  //获取第一个工作表，一个excel可能有多个工作表 
        sheet1.shiftRows(1, 4, -1);//删除第一行到第四行，然后使下方单元格上移  
        FileOutputStream os = new FileOutputStream("D:/workspaceForWeb/DY_PGS/WebContent/xlsx/BasicInfoExport_02.xlsx");  //获取已有的Excel  
        wb.write(os);
        fs.close(); 
        os.close(); 
        System.out.println("fix");
	}
}
