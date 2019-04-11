package www.hobby.po;


/**
 * 对学生特长爱好(stu_hobby_code)的实体抽象
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
