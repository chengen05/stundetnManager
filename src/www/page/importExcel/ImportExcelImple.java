package www.page.importExcel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ImportExcelImple {
	//��ȡexcel2010�ļ�
		public ArrayList<ArrayList<String>> readerExcel(String excelName,int args){
			XSSFWorkbook xssfworkbook = null;
			FileInputStream excelFile;
			try {
				excelFile = new FileInputStream(excelName);
				xssfworkbook = new XSSFWorkbook(excelFile);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			if(xssfworkbook == null) {
				System.out.println("·������");
				return null;
			}
			
			ArrayList<ArrayList<String>> ans=new ArrayList<ArrayList<String>>();
			//����xlsx�е�sheet
			for (int numSheet = 0; numSheet < xssfworkbook.getNumberOfSheets(); numSheet++) {
				XSSFSheet xssfSheet = xssfworkbook.getSheetAt(numSheet);
				if (xssfSheet == null) {
               continue;
           }
           // ����ÿ��sheet��������һ�� ����ȡ�����ÿһ��
           for (int rowNum = 1; rowNum <= xssfSheet.getLastRowNum(); rowNum++) {
               XSSFRow xssfRow = xssfSheet.getRow(rowNum);
               if (xssfRow == null) continue; 
               ArrayList<String> curarr=new ArrayList<String>();
               for(int columnNum = 0 ; columnNum<args ; columnNum++){
               	XSSFCell cell = xssfRow.getCell(columnNum);
               	curarr.add( Trim_str( getValue(cell) ) );
               }
               ans.add(curarr);
           }
       }
       return ans;
   }
		
		 //�жϺ�׺Ϊxlsx��excel�ļ���������
		private static String getValue(XSSFCell xssfRow) {
			 SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");  
	    	if(xssfRow==null){
	    		return "---";
	    	}
	        if (xssfRow.getCellType() == Cell.CELL_TYPE_BOOLEAN) {
	            return String.valueOf(xssfRow.getBooleanCellValue());
	        } else if (xssfRow.getCellType() == Cell.CELL_TYPE_NUMERIC) {
	        	if(DateUtil.isCellInternalDateFormatted(xssfRow)) {
	        		return fmt.format(xssfRow.getDateCellValue());
	        	}
	        	else {
	        		double cur=xssfRow.getNumericCellValue();
	        		long longVal = Math.round(cur);
	        		Object inputValue = null;
	        		if(Double.parseDouble(longVal + ".0") == cur)  
	        	        inputValue = longVal;  
	        		else  
	        	        inputValue = cur; 
	        		return String.valueOf(inputValue);
	        	}
	        } else if(xssfRow.getCellType() == Cell.CELL_TYPE_BLANK || xssfRow.getCellType() == Cell.CELL_TYPE_ERROR){
	        	return "---";
	        }
	        else {
	        	xssfRow.setCellType(Cell.CELL_TYPE_STRING);
	            return String.valueOf(xssfRow.getStringCellValue());
	        }
	    }
	    //�ַ����޼�  ȥ�����пհ׷��� �� �ʺ� �� ���Ŀո�
	    static private String Trim_str(String str){
	        if(str==null)
	            return null;
	        return str.replaceAll("[\\s\\?]", "").replace("��", "");
	    }
	//���������
	public int getCelltotal(String excelName,int sheetTotal) {
		FileInputStream ipts;
		int celltotal = 0;
		int rowlastCellnum = 0;
		try {
			ipts= new FileInputStream(excelName);
			System.out.println(ipts);
			try {
				XSSFWorkbook xswk = new XSSFWorkbook(ipts);
				int lastRowNum = xswk.getSheetAt(sheetTotal).getLastRowNum();
				for(int j = 0;j <=lastRowNum;j++) {
					if(xswk.getSheetAt(sheetTotal).getRow(j)!=null) {
						{
							 rowlastCellnum = xswk.getSheetAt(sheetTotal).getRow(j).getLastCellNum();
							if(rowlastCellnum > celltotal) {
								celltotal = rowlastCellnum;
							}
						}
					}
				} 
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return celltotal;
	}
	
	public int getRowNum(String excelName,int sheetTotal) {
		FileInputStream ipts = null;
		XSSFWorkbook xswk = null;
		try {
			ipts= new FileInputStream(excelName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
			try {
				xswk = new XSSFWorkbook(ipts);
			} catch (IOException e) {
				e.printStackTrace();
			}
			int lastRowNum = xswk.getSheetAt(sheetTotal).getLastRowNum();
			System.out.println(lastRowNum);
		return lastRowNum;
	}
}
