package www.hobby.po;


/**
 * ��ѧ���س�����(stu_hobby_code)��ʵ�����
 * @author chen gen
 *
 */

import lombok.Data;
@Data

public class StuHobbyCode {
	private int stuHobbyId;
	private int stuId;
	private int hobbyId;
	private int description;
}
