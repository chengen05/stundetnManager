package www.shetuan.po;

/**
 * ��ѧԺѧ���ɲ�(stu_job)��ʵ�����
 * @author chen gen
 *
 */

import lombok.Data;
@Data
public class StuJob {
	private int stuJobId;
	private int stuId;//ѧ�����
	private int jobId;//ְλ���
	private String jobStart;
	private String jobEnd;
	private String jobStatus;
	
	
	
}
