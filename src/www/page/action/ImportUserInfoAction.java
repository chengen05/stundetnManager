package www.page.action;

import java.util.ArrayList;


import lombok.Data;
import www.basePo.dao.UserInfoDao;
import www.basePo.imple.UserInfoImple;
import www.page.importExcel.ImportExcelImple;

/**
 * 通过excel导入用户信息
 * @author chen gen
 *
 */
@Data
public class ImportUserInfoAction {
	private String filePath;
	private String sheetNum;
	private String msginfo;
	public String info()
	{
		if(filePath.equals(null) && sheetNum.equals(null)) {
			msginfo = "地址或sheet名，未输入";
			return "error";
		}
		else {
			int sheet = Integer.parseInt(sheetNum);
			ImportExcelImple imExcel = new ImportExcelImple();
			int cellNum = imExcel.getCelltotal(filePath, sheet);
			ArrayList<ArrayList<String>> arrayInsert = imExcel.readerExcel(filePath, cellNum);
			UserInfoDao userinfoDo = new UserInfoImple();
			 userinfoDo.insertUserInfo(arrayInsert);
			
		}
		return "success";
		
	}
}
