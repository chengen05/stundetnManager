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
		 * �Ȳ�ѯ������������Ϣ����
		 * �ٽ����ݿ�������ӵ�listcode��
		 */
		SystemOperateDao sysdo = new SystemOperateImple();
		MenuTree menu =new MenuTree();
		this.listcode = menu.menuList(sysdo.selectAll());
		System.out.println(listcode);
		return Action.SUCCESS;
	}

}
