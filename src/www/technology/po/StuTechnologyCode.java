package www.technology.po;

/**
 * ��ѧ���μӿ������(stu_technology_type)��ʵ�����
 * @author chen gen
 *
 */

import lombok.Data;
@Data

public class StuTechnologyCode {
	private int stuTecId;
	private int stuId;
	private int technologyInfoId;
	private String guideTeacher;
	private String time;
	private String description;
}
