package www.basePo.po;

/**
 * ��ѧУ���ű�(school_department)��ʵ�����
 * @author chen gen
 *
 */

import lombok.Data;
@Data

public class SchoolDepartment {
	private int schoolDepartId;
	private String departmentName;
	private int departmentType;
	private int departmentSort;
	private String departmentLinkman;
	private String officeAddress;
	private String phoneNumber;
	

}
