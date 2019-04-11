package www.shetuan.po;

import lombok.Data;
import www.basePo.po.StudentInfo;
@Data

/**
 * 对stu_outclass_code学生参加课外活动记录的实体抽象
 * @author chen gen
 *
 */

public class StuOutClass {
	private int stuOutClassId;
	private OutActive activityId;
	private StudentInfo stuId;
	private String takePartDate;
	private String auditingStats;
	//-1为审核,0为学生提交填写，1位审核通过

}
