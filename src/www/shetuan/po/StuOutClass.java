package www.shetuan.po;

import lombok.Data;
import www.basePo.po.StudentInfo;
@Data

/**
 * ��stu_outclass_codeѧ���μӿ�����¼��ʵ�����
 * @author chen gen
 *
 */

public class StuOutClass {
	private int stuOutClassId;
	private OutActive activityId;
	private StudentInfo stuId;
	private String takePartDate;
	private String auditingStats;
	//-1Ϊ���,0Ϊѧ���ύ��д��1λ���ͨ��

}
