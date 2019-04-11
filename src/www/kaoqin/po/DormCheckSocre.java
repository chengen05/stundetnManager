package www.kaoqin.po;

/**
 * 对寝室检查得分表（dormitory_inspect_score）的实体抽象
 * @author chen gen
 *
 */
import lombok.Data;
@Data
public class DormCheckSocre {
	private int checkSocreId;
	private DormCheck dormCheckId;
	private int checkSocre;
	private String checkName;
    private String checkDate;
}
