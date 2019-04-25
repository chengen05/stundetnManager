package www.basePo.dao;

import java.util.ArrayList;
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
	/**
	 * ������Ϣ�ĵ���
	 * @param rowCode
	 * @return
	 */
	public void insertUserInfo(ArrayList<ArrayList<String>> arrayInsert);
	
	/**
	 * ���ڽ����ҳʱjson����
	 */
	public List<UserInfo> selectPageCode(int pageSize,int rowoffset);
}
