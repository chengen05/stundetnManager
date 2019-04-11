package www.basePo.po;


/**
 * 对用户信息表(user_info)
 * @author chen gen
 *
 */

import lombok.Data;
@Data

public class UserInfo {
	private int userId;
	private String account;
	private String password;
	private String name;
	private String gender;
	private String photo;
	private int userRoleId;
	
}
