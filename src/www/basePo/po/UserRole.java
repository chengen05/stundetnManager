package www.basePo.po;

/**
 * 对用户角色信息表的抽象(role_info)的抽象
 */
import lombok.Data;
@Data
public class UserRole {
    private int useRoleId;
    private String roleName;
    private int stuRang;
    private String roleExplain;
   
      
}
