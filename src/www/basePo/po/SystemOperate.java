package www.basePo.po;

/**
 * 对系统内部操作的连接表(href_url_info)的实体抽象
 * @author chen gen
 *
 */
import lombok.Data;
@Data

public class SystemOperate {
	private int systemId;
	private String name;
	private String linkUrl;
	private int menu;
	private String icon;
	private int systemSort;
	private int parentNode;
	//父节点序号      
}
