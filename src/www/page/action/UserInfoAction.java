package www.page.action;


import java.util.List;

import lombok.Data;
import www.basePo.dao.UserInfoDao;
import www.basePo.dao.UserRoleNodeDao;
import www.basePo.imple.UserInfoImple;
import www.basePo.imple.UserRoleNodeImple;
import www.basePo.po.UserInfo;
import www.basePo.po.UserRoleNode;

@Data
public class UserInfoAction {
	private List<UserRoleNode> roleinfo;
	private UserInfo userInfo;
	private int userid;
	
	public String showUserInfo()
	{
		UserRoleNodeDao userRole = new UserRoleNodeImple();
		this.roleinfo = userRole.selectAll();
		return "success";
	}
	/**
	 * ����һ������
	 */
	public String insertUserInfo()
	{
		UserInfoDao userdo = new UserInfoImple();
		userdo.insertUserCode(userInfo);
		return "success";
	}
	/**
	 * �޸�����
	 */
	public String updateUserInfo()
	{
		UserInfoDao userdo = new UserInfoImple();
		userdo.updateUserCode(userInfo);
		return "success";
	}
	/**
	 * ɾ������
	 */
	public String delUserInfo()
	{
		UserInfoDao userdo = new UserInfoImple();
		userdo.delUserCode(userid);
		return "success";
	}
}
