package www.basePo.po;


import lombok.Data;
@Data

/**
 * 对家庭成员信息表(family_member)的抽象信息
 * @author chen gen
 *
 */

public class Family {
	private int familyId;
	private String familyName;
	private String familyRelation;//家人与你的关系
	private String familyBirthday;
	private String avg_income;
	private int stuId;
	
}
