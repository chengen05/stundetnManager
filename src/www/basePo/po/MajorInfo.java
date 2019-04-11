package www.basePo.po;

/**
 * ��רҵ��Ϣ��(major_info)��ʵ�����
 */

import lombok.Data;
@Data
public class MajorInfo {
	private int majorInfoId;
	private String majorName;
	private String majorCode;
	private String trainLevel;
	private int eduSystem;
	private int teacherMajor;
	private String leaderName;
	private String leaderDescription;
	private String trainTarget;
	private int totalPoints; //��ҵ����ѧ��
	private String establishDate;
	private int schoolDepartId;
	
	

}
