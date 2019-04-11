package www.jingsai.po;

/**
 * 对学生参加竞赛获奖信息(stu_match_code)的实体抽象
 * @author chen gen
 *
 */
import lombok.Data;
@Data
public class StuMatchCode {
	private int matchId;
	private int stuId;
	private int stuMatchId;//竞赛序号
	private String guideTeacher;//指导教师
	private String matchDate;
	private String matchDiploma;//证书
	private String matchMemo;//备注说明
}
