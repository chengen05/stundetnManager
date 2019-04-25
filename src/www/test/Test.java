package www.test;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import www.basePo.dao.ClassInfoDao;
import www.basePo.dao.HrefUrlItemDao;
import www.basePo.dao.RolePowerDao;
import www.basePo.dao.SchoolDepartmentDao;
import www.basePo.dao.SystemOperateDao;
import www.basePo.dao.UserInfoDao;
import www.basePo.imple.ClassInfoImple;
import www.basePo.imple.HrefUrlItemImple;
import www.basePo.imple.RolePowerImple;
import www.basePo.imple.SchoolDepartmentImple;
import www.basePo.imple.SystemOperateImple;
import www.basePo.imple.UserInfoImple;
import www.basePo.po.ClassInfo;
import www.basePo.po.HrefUrlItem;
import www.basePo.po.RolePower;
import www.basePo.po.SchoolDepartment;
import www.basePo.po.SystemOperate;
import www.basePo.po.UserInfo;
import www.page.action.ImportUserInfoAction;
import www.page.action.MenuTree;
import www.page.action.SchoolDepartJson;
import www.page.importExcel.ImportExcelImple;

public class Test {

	public static void main(String[] args) {
//		ClassInfoDao classinfo = new ClassInfoImple();
//		ClassInfo classInfo = new ClassInfo();
//		classInfo.setClassName("2017��11��");
//		classInfo.setMeetRoom("1��204");
//		classInfo.setHeadMasterId(1);
//		classInfo.setMajorId(1);
//		
//		boolean boo = classinfo.delClassInfo(1);
//		if(boo == true)
//		{
//			System.out.println("�ɹ�");
//		}
		
		List<SystemOperate> sys = new ArrayList<SystemOperate>();
		List<SystemOperate> sysDropDownItem = new ArrayList<SystemOperate>();
		List<SystemOperate> sysDropDownmenu = new ArrayList<SystemOperate>();
		List<HrefUrlItem> sysItem = new ArrayList<HrefUrlItem>();
		
		
		
		/**
		 * ����ѧԺ����tablejson���ݸ�ʽ
		 * 
		 */
	
//		SchoolDepartmentDao schoolDo = new SchoolDepartmentImple();
//		List<SchoolDepartment> depart = schoolDo.selectAll();
//		JSONObject s= new JSONObject(); 
//		s.put("total", depart.size());
//		s.put("rows", listToJson(depart));
//		System.out.println(s);
		
//		HrefUrlItem hrefUrlItem;
//		SystemOperateDao sysop = new SystemOperateImple();
//		RolePowerDao role = new RolePowerImple();
//		List<RolePower> roleList = role.selectList(2);
//		//���ݽ�ɫrole_id��ѯ���������ɫ��ӵ�еĲ˵�����
//		for (RolePower rolePower : roleList) {
//			SystemOperate system = sysop.selectSysOp(rolePower.getHrefUrlId());
//			//����id��role_root_code��ѯ��������¼
//			if(!(system.getLinkUrl().equals("empty"))&& system.getParentNode()==0)
//			{
//				sys.add(system);//һ���˵�
//			}
//			else if((system.getLinkUrl().equals("empty"))&& system.getParentNode()==0)
//			{
//				int parentnode = system.getSystemId();
//				hrefUrlItem = new HrefUrlItem();
//				hrefUrlItem.setSystemId(system.getSystemId());
//			//	hrefUrlItem.setLinkName(system.getLinkName());
//				hrefUrlItem.setMenu(system.getMenu());
//				hrefUrlItem.setIcon(system.getIcon());
//				hrefUrlItem.setSystemSort(system.getSystemSort());
//				HrefUrlItemDao hrefurlitem = new HrefUrlItemImple();
//				hrefUrlItem.setSystemOperate(hrefurlitem.selectHrefList(parentnode, 2));
//				sysItem.add(hrefUrlItem);
//			}
////			else if(system.getParentNode()!=0)
////			{
////				sysDropDownItem.add(system);
////			}
//		}
//		
//		for(HrefUrlItem href : sysItem)
//		{
//			System.out.println(href.getLinkName()+"/r" );
//				for(SystemOperate system1 : href.getSystemOperate())
//				{
//				//	System.out.print(system1.getLinkName()+" "+system1.getLinkUrl()+"--");
//				}
//		}
//		
//		for (SystemOperate systemOperate:sysDropDownItem) {
//			System.out.println(systemOperate.getLinkName()+"/r" +systemOperate.getLinkUrl() );
//		}
//		for (SystemOperate systemOperatet : sysDropDownmenu) {
//			//������һ����һ���˵�
//			//System.out.println(systemOperatet.getLinkName()+"/r" +systemOperatet.getLinkUrl() );
//		}
		
//		UserInfoDao userdo = new UserInfoImple();
//		List<UserInfo> lis = userdo.selectAll();
//		for (UserInfo userInfo : lis) {
//			System.out.println(userInfo.getName());
////		}
//		System.out.println("\n"+"------123-");
	/**
	 * �������ܲ˵�������
	 */
//		SystemOperateDao sysdo = new SystemOperateImple();
//		List<SystemOperate> systemList= sysdo.selectAll();
//		MenuTree menu =new MenuTree();
//		List<Object> listcode = menu.menuList(systemList);
//		System.out.println("������:"+listcode);
//		for (Object systemOperatet : listcode) {
//			System.out.println(systemOperatet);
//		}
//		System.out.println("\n"+"-----123-");
//		
		/**
		 *���Ե�������
		 */
		ImportUserInfoAction userinfo =new ImportUserInfoAction();
		userinfo.setFilePath("D:\\eclipoxygenspace\\JoinPart\\WebContent\\WEB-INF\\downandupload\\�û���Ϣ����ģ��.xlsx");
		userinfo.setSheetNum("0");
		userinfo.info();
		
	
	}
//	private static JSONArray listToJson(List<SchoolDepartment> depart)
//	{
//		JSONArray json = new JSONArray();
//		for(SchoolDepartment dep: depart)
//		{
//		
//			JSONObject jo =new JSONObject();
//			jo.put("id",dep.getSchoolDepartId());
//			jo.put("name", dep.getDepartmentName());
//			jo.put("departtype", dep.getDepartmentType());
//			jo.put("linkMan",dep.getDepartmentLinkman());
//			jo.put("office",dep.getOfficeAddress());
//			jo.put("phoneNum", dep.getPhoneNumber());
//			json.add(jo);
//		}
//	
//		return json;
//	}

}
