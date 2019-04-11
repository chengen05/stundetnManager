package www.basePo.po;

/**
 * 对学校部门表(school_department)的实体抽象
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
