package www.basePo.po;

import java.util.List;

import lombok.Data;

@Data

/**
 * �����˵�����
 * @author chen gen
 *
 */
public class HrefUrlItem {
	private int systemId;
	private String linkName;
	private int menu;
	private String icon;
	private int systemSort;
	private List<SystemOperate> systemOperate;
}
