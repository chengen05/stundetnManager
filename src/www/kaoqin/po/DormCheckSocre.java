package www.kaoqin.po;

/**
 * �����Ҽ��÷ֱ�dormitory_inspect_score����ʵ�����
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
