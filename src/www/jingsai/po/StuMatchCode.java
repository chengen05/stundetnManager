package www.jingsai.po;

/**
 * ��ѧ���μӾ�������Ϣ(stu_match_code)��ʵ�����
 * @author chen gen
 *
 */
import lombok.Data;
@Data
public class StuMatchCode {
	private int matchId;
	private int stuId;
	private int stuMatchId;//�������
	private String guideTeacher;//ָ����ʦ
	private String matchDate;
	private String matchDiploma;//֤��
	private String matchMemo;//��ע˵��
}
