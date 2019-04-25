package www.page.action;

import java.util.List;

import com.opensymphony.xwork2.Action;

import lombok.Data;
import www.basePo.dao.SystemOperateDao;
import www.basePo.imple.SystemOperateImple;

@Data
public class RoleActionJson {
	private List<Object> listcode;
	public String execute() {
		/**
		 * 先查询出所有连接信息数据
		 * 再讲数据库数据添加到listcode里
		 */
		SystemOperateDao sysdo = new SystemOperateImple();
		MenuTree menu =new MenuTree();
		this.listcode = menu.menuList(sysdo.selectAll());
		System.out.println(listcode);
		return Action.SUCCESS;
	}

}
