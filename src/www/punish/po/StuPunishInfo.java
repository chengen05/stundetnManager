package www.punish.po;

import lombok.Data;
@Data

/**
 * ��ѧ��������¼(stu_punish_code)�ĳ���
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
