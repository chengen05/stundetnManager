package www.basePo.po;

/**
 * 对专业信息表(major_info)的实体抽象
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
	private int totalPoints; //毕业条件学分
	private String establishDate;
	private int schoolDepartId;
	
	

}
