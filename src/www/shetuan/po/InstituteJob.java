package www.shetuan.po;

/**
 *对学院学生干部职位信息(institute_job_info)的实体抽象
 */

import lombok.Data;

@Data
public class InstituteJob {
	private int insJobId;
	private String jobName;
	private int sortValue;
	private int depart;
	
    
}
