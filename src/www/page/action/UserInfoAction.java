package www.page.action;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import www.basePo.dao.UserInfoDao;
import www.basePo.imple.UserInfoImple;
import www.basePo.po.UserInfo;

@Data
public class UserInfoAction {
	private List<UserInfo> userInfoList;
	
	public String showUserInfos()
	{
		userInfoList = new ArrayList<UserInfo>();
		UserInfoDao userdo = new UserInfoImple();
		this.userInfoList = userdo.selectAll();
		for (UserInfo userInfo : userInfoList) {
			System.out.println(userInfo.getAccount());
		}
		return "success";
	}
}
