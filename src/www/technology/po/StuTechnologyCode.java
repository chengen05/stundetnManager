package www.technology.po;

/**
 * 对学生参加科研情况(stu_technology_type)的实体抽象
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
