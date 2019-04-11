package www.jingsai.po;
/**
 * 对学生竞赛信息表(match_info)的实体抽象
 * @author chen gen
 *
 */

import lombok.Data;
@Data
public class StuMatch {
	private int stumatchId;
	private String matchName;
	private String matchGrade;//级别
	private String matchMemo;//备注说明
	
}
