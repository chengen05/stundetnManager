package www.partyProcess.po;

/**
 * ��ѧ���뵳��¼(stu_party_process)�ĳ���
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
