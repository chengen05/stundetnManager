package www.hobby.po;


/**
 * 对特长爱好信息表(hobby)的实体抽象
 */

import lombok.Data;
@Data
public class HobbyInfo {
	private int hobbyId;
	private String hobbyName;
	private int rankId;
	private String description;
}
