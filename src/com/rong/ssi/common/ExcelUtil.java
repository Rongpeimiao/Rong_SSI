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
     * ͨ���ļ�·��ֱ���޸��ļ���
     * 
     * @param filePath    ��Ҫ�޸ĵ��ļ�������·��
     * @param newFileName ��Ҫ�޸ĵ��ļ�������
     * @return
     */
    private static String FixFileName(String filePath, String newFileName) {
        File f = new File(filePath);
        if (!f.exists()) { // �ж�ԭ�ļ��Ƿ���ڣ���ֹ�ļ�����ͻ��
            return null;
        }
        newFileName = newFileName.trim();
        if ("".equals(newFileName) || newFileName == null) // �ļ�������Ϊ��
            return null;
        String newFilePath = null;
        if (f.isDirectory()) { // �ж��Ƿ�Ϊ�ļ���
            newFilePath = filePath.substring(0, filePath.lastIndexOf("/")) + "/" + newFileName;
        } else {
            newFilePath = filePath.substring(0, filePath.lastIndexOf("/")) + "/" + newFileName
                    + filePath.substring(filePath.lastIndexOf("."));
        }
        File nf = new File(newFilePath);
        try {
            f.renameTo(nf); // �޸��ļ���
        } catch (Exception err) {
            err.printStackTrace();
            return null;
        }
        return newFilePath;
    }
    
    /**
     * ��ȡExcel��������
     * @param InputStream
     * @return List<Map<String, String>>  Map��key����Id(0�����һ��)��ֵ�Ǿ�������
     * @throws IOException 
     */
    public List<Map<Integer, String>> readExcelContentByList(InputStream is) throws IOException {
        
        List<Map<Integer, String>> list = new ArrayList<Map<Integer,String>>();

        POIFSFileSystem ps = new POIFSFileSystem(is);  //ʹ��POI�ṩ�ķ����õ�excel����Ϣ   
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
        // �õ�������
        int rowNum = sheet.getLastRowNum();
        row = sheet.getRow(0);
        int colNum = row.getPhysicalNumberOfCells();
        
        // ��������Ӧ�ôӵڶ��п�ʼ,��һ��Ϊ��ͷ�ı���
        for (int i = 1; i <= rowNum; i++) {
        	String valueCell="";
            row = sheet.getRow(i);
            int j = 0;
            Map<Integer,String> map = new HashMap<Integer, String>();
            
            while (j < colNum) {
                // ÿ����Ԫ�������������"-"�ָ���Ժ���Ҫʱ��String���replace()������ԭ����
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
	 * ����excel
	 * 
	 * @param xlsPath
	 *            �����ļ�·��
	 * @return temp List<String[]>
	 */
     //HSSFWorkbook:�ǲ���Excel2003��ǰ������2003���İ汾����չ����.xls 
    //XSSFWorkbook:�ǲ���Excel2007�İ汾����չ����.xlsx
    //��ȡ�ڼ��� Excel ҳ   sheetNUM 
    //��ȡ  Excel ҳ�е�ͷ���м��У����ݴӵڼ��п�ʼ  sheetHeadNUM 
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
	        // ����һ��������
	        XSSFWorkbook wb = new XSSFWorkbook();
	        // ����һ����ʽ  
	        XSSFCellStyle style = wb.createCellStyle();
	        //��ʽ�������
	        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
	        
	        //������һ��sheet����
	        XSSFSheet sheet1 = wb.createSheet("cs");

		List<byte[]> images = new ArrayList<>();
				
		// ����ȥ��ÿ��base64ǰ���"data:image/png;base64,"��22���ַ�
		try {
			images.add(Base64.decode(base64str));
		} catch  (Exception e) {
			e.printStackTrace();
		}
					
					//���ÿ��
					  sheet1.setDefaultRowHeight((short)(350*30/25));
				      sheet1.setColumnWidth( (int)(400*1990/140), 0);
					
					  //����ȡ����base64 ����ת����ͼƬ������excel��
					  XSSFDrawing patriarch  =sheet1.createDrawingPatriarch();
						XSSFClientAnchor anchor=null;
						int index=0;
						for(byte[] image:images){
							anchor = new XSSFClientAnchor(0,0,0,0,(short) (8*(index%3)),((index/3)*18),(short)(7+8*(index%3)),									16+((index/3)*18)); 
							patriarch.createPicture(anchor, wb.addPicture(image, XSSFWorkbook.PICTURE_TYPE_PNG));
							index++;
						}
						// ����·�������ݸ�����Ҫ��·������д�򵥵Ĵ���·����
						String fileName = savepath+"csvfile.xlsx";
						File file = new File(fileName);
						if (file.isFile()) {
							file.delete();
						}
						
						// �涨��·���£�����excel���
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
	
	       	return fileName;//����excel��·����js�е�window.location.herf ����������������ع���
}
	
	//base64ͼƬ���빤����
	public static String getBase64(String base64str,String savepath)	{
		String result = new String();
	        // ����һ��������
	        XSSFWorkbook wb = new XSSFWorkbook();
	        // ����һ����ʽ  
	        XSSFCellStyle style = wb.createCellStyle();
	        //��ʽ�������
	        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
	        
	        //������һ��sheet����
	        XSSFSheet sheet1 = wb.createSheet("cs");
	        Row row;
	         row = sheet1.createRow((short)(1)); //������    
	         row.createCell(0).setCellValue(11); //���õ�һ������0��ʼ����Ԫ�������
	         row.createCell(1).setCellValue(2);
	         row.createCell(2).setCellValue(3);
	         row.createCell(3).setCellValue(4);
	         row.createCell(4).setCellValue(5);	
	         row.createCell(5).setCellValue(6);		 
	         row.createCell(6).setCellValue(7); 
	         
	         
	         
	       /*  Row row;
		        row = sheet1.createRow((short)(0)); //������    
		        row.createCell(0).setCellValue("�������� ��¼�룩"); //���õ�һ������0��ʼ����Ԫ�������
		        CellRangeAddress region=new CellRangeAddress(0, 1, 0, 0);
		        sheet1.addMergedRegion(region);
		        row.createCell(1).setCellValue("�����"); //���õ�һ������0��ʼ����Ԫ�������
		        region=new CellRangeAddress(0, 0, 1, 4);
		        sheet1.addMergedRegion(region);
		        row.createCell(5).setCellValue("δ���"); //���õ�һ������0��ʼ����Ԫ�������
		        region=new CellRangeAddress(0, 0, 5, 11);
		        sheet1.addMergedRegion(region);*/
		List<byte[]> images = new ArrayList<>();
				
		// ����ȥ��ÿ��base64ǰ���"data:image/png;base64,"��22���ַ�
		try {
			images.add(Base64.decode(base64str));
		} catch  (Exception e) {
			e.printStackTrace();
		}
					
					//���ÿ��
					  sheet1.setDefaultRowHeight((short)(350*30/25));
				      sheet1.setColumnWidth( (int)(400*1990/140), 0);
					
					  //����ȡ����base64 ����ת����ͼƬ������excel��
					  XSSFDrawing patriarch  =sheet1.createDrawingPatriarch();
						XSSFClientAnchor anchor=null;
						int index=0;
						for(byte[] image:images){
							anchor = new XSSFClientAnchor(0,0,0,0,(short) (8*(index%3)),5+((index/3)*18),(short)(20+8*(index%3)),16+((index/3)*18)); 
							patriarch.createPicture(anchor, wb.addPicture(image, XSSFWorkbook.PICTURE_TYPE_PNG));
							index++;
						}
						// ����·�������ݸ�����Ҫ��·������д�򵥵Ĵ���·����
						String fileName = savepath+"csvfile.xlsx";
						File file = new File(fileName);
						if (file.isFile()) {
							file.delete();
						}
						
						// �涨��·���£�����excel���
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
	
	       	return fileName;//����excel��·����js�е�window.location.herf ����������������ع���
}
	
    public static void main(String[] args) throws Exception {
    	// String fullFileName = getServletContext().getRealPath("/xlsx/" + filename);  
    	///DY_PGS/WebContent/xlsx/BasicInfoExport_01.xlsx
    	//FixFileName("D:/workspaceForWeb/DY_PGS/WebContent/xlsx/BasicInfoExport_02.xlsx","BasicInfoExport_01");
    	System.out.println("fix");
    	
    	FileInputStream fs = new FileInputStream("D:/workspaceForWeb/DY_PGS/WebContent/xlsx/BasicInfoExport_02.xlsx");  //��ȡ���е�Excel  
        Workbook wb = new XSSFWorkbook(fs);    
        Sheet sheet1 = wb.getSheetAt(0);  //��ȡ��һ��������һ��excel�����ж�������� 
        sheet1.shiftRows(1, 4, -1);//ɾ����һ�е������У�Ȼ��ʹ�·���Ԫ������  
        FileOutputStream os = new FileOutputStream("D:/workspaceForWeb/DY_PGS/WebContent/xlsx/BasicInfoExport_02.xlsx");  //��ȡ���е�Excel  
        wb.write(os);
        fs.close(); 
        os.close(); 
        System.out.println("fix");
	}
}
