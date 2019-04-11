package www.shetuan.po;

/**
 * 对学院学生干部(stu_job)的实体抽象
 * @author chen gen
 *
 */

import lombok.Data;
@Data
public class StuJob {
	private int stuJobId;
	private int stuId;//学生序号
	private int jobId;//职位序号
	private String jobStart;
	private String jobEnd;
	private String jobStatus;
	
	
	
}
