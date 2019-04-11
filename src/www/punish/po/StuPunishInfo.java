package www.punish.po;

import lombok.Data;
@Data

/**
 * 对学生处罚记录(stu_punish_code)的抽象
 * @author chen gen
 *
 */
public class StuPunishInfo {
	private int stuPunishId;
	private int punishInfoId;
	private int stuId;
	private String punishDate;
	private String cancelTime;
	private String description;
}
