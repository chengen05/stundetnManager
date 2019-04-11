package www.test;

import java.util.ArrayList;
import java.util.List;

import www.basePo.dao.ClassInfoDao;
import www.basePo.dao.HrefUrlItemDao;
import www.basePo.dao.RolePowerDao;
import www.basePo.dao.SystemOperateDao;
import www.basePo.dao.UserInfoDao;
import www.basePo.imple.ClassInfoImple;
import www.basePo.imple.HrefUrlItemImple;
import www.basePo.imple.RolePowerImple;
import www.basePo.imple.SystemOperateImple;
import www.basePo.imple.UserInfoImple;
import www.basePo.po.ClassInfo;
import www.basePo.po.HrefUrlItem;
import www.basePo.po.RolePower;
import www.basePo.po.SystemOperate;
import www.basePo.po.UserInfo;

public class Test {

	public static void main(String[] args) {
//		ClassInfoDao classinfo = new ClassInfoImple();
//		ClassInfo classInfo = new ClassInfo();
//		classInfo.setClassName("2017级11班");
//		classInfo.setMeetRoom("1教204");
//		classInfo.setHeadMasterId(1);
//		classInfo.setMajorId(1);
//		
//		boolean boo = classinfo.delClassInfo(1);
//		if(boo == true)
//		{
//			System.out.println("成功");
//		}
		
		List<SystemOperate> sys = new ArrayList<SystemOperate>();
		List<SystemOperate> sysDropDownItem = new ArrayList<SystemOperate>();
		List<SystemOperate> sysDropDownmenu = new ArrayList<SystemOperate>();
		List<HrefUrlItem> sysItem = new ArrayList<HrefUrlItem>();
		
		HrefUrlItem hrefUrlItem;
		SystemOperateDao sysop = new SystemOperateImple();
		RolePowerDao role = new RolePowerImple();
		List<RolePower> roleList = role.selectList(2);
		//根据角色role_id查询出，这个角色所拥有的菜单集合
		for (RolePower rolePower : roleList) {
			SystemOperate system = sysop.selectSysOp(rolePower.getHrefUrlId());
			//根据id在role_root_code查询出这条记录
			if(!(system.getLinkUrl().equals("empty"))&& system.getParentNode()==0)
			{
				sys.add(system);//一级菜单
			}
			else if((system.getLinkUrl().equals("empty"))&& system.getParentNode()==0)
			{
				int parentnode = system.getSystemId();
				hrefUrlItem = new HrefUrlItem();
				hrefUrlItem.setSystemId(system.getSystemId());
				hrefUrlItem.setLinkName(system.getLinkName());
				hrefUrlItem.setMenu(system.getMenu());
				hrefUrlItem.setIcon(system.getIcon());
				hrefUrlItem.setSystemSort(system.getSystemSort());
				HrefUrlItemDao hrefurlitem = new HrefUrlItemImple();
				hrefUrlItem.setSystemOperate(hrefurlitem.selectHrefList(parentnode, 2));
				sysItem.add(hrefUrlItem);
			}
//			else if(system.getParentNode()!=0)
//			{
//				sysDropDownItem.add(system);
//			}
		}
		
		for(HrefUrlItem href : sysItem)
		{
			System.out.println(href.getLinkName()+"/r" );
				for(SystemOperate system1 : href.getSystemOperate())
				{
					System.out.print(system1.getLinkName()+" "+system1.getLinkUrl()+"--");
				}
		}
		
//		for (SystemOperate systemOperate:sysDropDownItem) {
//			System.out.println(systemOperate.getLinkName()+"/r" +systemOperate.getLinkUrl() );
//		}
//		for (SystemOperate systemOperatet : sysDropDownmenu) {
//			//含有下一级的一级菜单
//			//System.out.println(systemOperatet.getLinkName()+"/r" +systemOperatet.getLinkUrl() );
//		}
		
//		UserInfoDao userdo = new UserInfoImple();
//		List<UserInfo> lis = userdo.selectAll();
//		for (UserInfo userInfo : lis) {
//			System.out.println(userInfo.getName());
//		}
	}

}
