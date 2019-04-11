package www.punish.po;

/**
 * 对处罚信息(punish_info)的抽象
 */
import lombok.Data;

@Data
public class PunishInfo {
	private int punishInfoId;
	private String punishName;
	private String punishType;
	private String punishMemo;
}
