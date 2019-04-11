package www.kaoqin.po;

/**
 * 对寝室检查选项(dormitory_inspect_option)的实体抽象
 * @author chen gen
 *
 */
import lombok.Data;
@Data
public class DormCheck {
	private int dormcheckId;
	private String checkName;
	private String checkType;
	private int checkSort;

}
