package www.basePo.dao;

import java.util.ArrayList;
import java.util.List;

import www.basePo.po.UserInfo;

/**
 * 
 * 对用户信息表进行抽象方法
 * @author chen gen
 *
 */
public interface UserInfoDao {
	public boolean  insertUserCode(UserInfo userInfo);
	
	public boolean updateUserCode(UserInfo userInfo);
	
	public boolean delUserCode(int userId);
	
	public UserInfo selectUser(UserInfo userInfo);
	
	public List<UserInfo> selectAll();
	/**
	 * 用于信息的导入
	 * @param rowCode
	 * @return
	 */
	public void insertUserInfo(ArrayList<ArrayList<String>> arrayInsert);
	
	/**
	 * 用于界面分页时json数据
	 */
	public List<UserInfo> selectPageCode(int pageSize,int rowoffset);
}
