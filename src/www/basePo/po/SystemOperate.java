package www.basePo.po;

/**
 * ��ϵͳ�ڲ����������ӱ�(href_url_info)��ʵ�����
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
	//���ڵ����      
}
