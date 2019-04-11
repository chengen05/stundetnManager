package www.zhuxuejin.po;

import lombok.Data;
import www.basePo.po.StudentInfo;
@Data

/**
 * 对学生获奖助学金记录(stu_stipend_code)的实体抽象
 * @author chen gen
 *
 */

public class StuGrantRecord {
   private int grantrecordId;
   private int stugrandId;//奖助学金序号
   private StudentInfo stuId;//学生序号
   private String grantrecordDate;
   private String grantrecordMemo;//备注
}
