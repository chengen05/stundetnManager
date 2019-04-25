package www.page.action;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import www.basePo.dao.HrefUrlItemDao;
import www.basePo.dao.RolePowerDao;
import www.basePo.dao.SystemOperateDao;
import www.basePo.dao.UserInfoDao;
import www.basePo.dao.UserRoleDao;
import www.basePo.imple.HrefUrlItemImple;
import www.basePo.imple.RolePowerImple;
import www.basePo.imple.SystemOperateImple;
import www.basePo.imple.UserInfoImple;
import www.basePo.imple.UserRoleImple;
import www.basePo.po.HrefUrlItem;
import www.basePo.po.RolePower;
import www.basePo.po.SystemOperate;
import www.basePo.po.UserInfo;
import www.basePo.po.UserRole;


public class LoginAction extends ActionSupport{


	public String loginPage() {
		return "login";
	}

	/**
	 * ��½�жϣ������û���Ϣ����session
	 */
	private UserInfo userInfo;		//�û�
	private UserRole userRole;		//��ɫ
	private RolePower rolePower;	//��ɫȨ��
	private SystemOperate systemOperate;
	private List<SystemOperate> systemList;
	private List<RolePower> roleList;
	
	
	
	public UserInfo getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	public UserRole getUserRole() {
		return userRole;
	}
	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}
	public RolePower getRolePower() {
		return rolePower;
	}
	public void setRolePower(RolePower rolePower) {
		this.rolePower = rolePower;
	}
	public SystemOperate getSystemOperate() {
		return systemOperate;
	}
	public void setSystemOperate(SystemOperate systemOperate) {
		this.systemOperate = systemOperate;
	}
	public List<SystemOperate> getSystemList() {
		return systemList;
	}
	public void setSystemList(List<SystemOperate> systemList) {
		this.systemList = systemList;
	}
	public List<RolePower> getRoleList() {
		return roleList;
	}
	public void setRoleList(List<RolePower> roleList) {
		this.roleList = roleList;
	}
	public List<HrefUrlItem> getSysItemdropItem() {
		return sysItemdropItem;
	}
	public void setSysItemdropItem(List<HrefUrlItem> sysItemdropItem) {
		this.sysItemdropItem = sysItemdropItem;
	}

	private List<HrefUrlItem> sysItemdropItem;//�����˵�
	public String loginDo() {
		String judge = "faileLogin";
		UserInfoDao userInfoDao = new UserInfoImple();
		userInfo = userInfoDao.selectUser(userInfo);
		if(this.userInfo.getUserId()!=0)
		{	
		
			//����˻���������ȷ�����¼�ɹ�����̬���ɲ˵�.
			sysItemdropItem = new ArrayList<HrefUrlItem>();
			systemList = new ArrayList<SystemOperate>(); //һ���˵�
			SystemOperateDao sysop = new SystemOperateImple();
			RolePowerDao role = new RolePowerImple();
			this.roleList = role.selectList(userInfo.getUserRoleId());
			
			for (RolePower rolePower : roleList) {
				SystemOperate system = sysop.selectSysOp(rolePower.getHrefUrlId());
				if(!(system.getLinkUrl().equals("empty"))&& system.getParentNode()==0)
				{
					systemList.add(system);//һ���˵�
				}
				else if((system.getLinkUrl().equals("empty"))&& system.getParentNode()==0)
				{
					int parentnode = system.getSystemId();
					HrefUrlItem	hrefUrlItem = new HrefUrlItem();
					hrefUrlItem.setSystemId(system.getSystemId());
					hrefUrlItem.setLinkName(system.getName());
					hrefUrlItem.setMenu(system.getMenu());
					hrefUrlItem.setIcon(system.getIcon());
					hrefUrlItem.setSystemSort(system.getSystemSort());
					HrefUrlItemDao hrefurlitem = new HrefUrlItemImple();
					hrefUrlItem.setSystemOperate(hrefurlitem.selectHrefList(parentnode, 2));
					sysItemdropItem.add(hrefUrlItem);
				}
			}
			UserRoleDao userRoleDo = new UserRoleImple();
			this.userRole = userRoleDo.selectUserRole(userInfo.getUserRoleId());
			/**
			 * session�����ؼ�¼
			 */
			 ActionContext actionContext = ActionContext.getContext();
		     Map<String, Object> session = actionContext.getSession(); 
		     session.put("userinfo", this.userInfo); 
			session.put("systemList",this.systemList);
			session.put("sysItemdropItem", this.sysItemdropItem);
			session.put("userRole", this.userRole);
			judge = "successLogin";
		}
		return judge;
	}
	 
}
