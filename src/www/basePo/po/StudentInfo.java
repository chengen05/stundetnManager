package www.basePo.po;

import lombok.Data;
@Data

/**
 * 对学生信息(stu_info)的实体抽象
 * @author chen gen
 *
 */

public class StudentInfo {
    private int studentInfoid;
    private int userStuId;
    private String stuBirthday;
    private String entranceDate;
    private String stuPhone;
    private String stuQQ;
    private String stuEmail;
    private String stuWechat;
    private String stuNation;
    private String stuIdCard;
    private String studyStatus;
    private int stuHeight;
    private int stuWeight;
    private String personDescription;
    private String politicalStatus;
    private String nativePlace;
    private String stuAddress;
    private int stuDifficult;
    private String stuDifficultType;
    private int stuClassId;
	
}
