package www.basePo.dao;

import java.util.List;

import www.basePo.po.UserInfo;

/**
 * 
 * ���û���Ϣ����г��󷽷�
 * @author chen gen
 *
 */
public interface UserInfoDao {
	public boolean  insertUserCode(UserInfo userInfo);
	
	public boolean updateUserCode(UserInfo userInfo);
	
	public boolean delUserCode(int userId);
	
	public UserInfo selectUser(UserInfo userInfo);
	
	public List<UserInfo> selectAll();
}
