package www.partyProcess.po;

/**
 * 对学生入党记录(stu_party_process)的抽象
 * @author chen gen
 *
 */
import lombok.Data;
@Data


public class StuPartyProcessCode {
	private int stuPartyId;
	private int partyProcessInfoId;
	private int stuId;
	private String time;
	private String teacher;
	private String descripiton;
}
