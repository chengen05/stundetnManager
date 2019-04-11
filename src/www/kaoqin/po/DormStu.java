package www.kaoqin.po;


/**对寝室所住学生的实体抽象(stu_dormitory)
 * 
 * @author chen gen
 *
 */
import lombok.Data;
import www.basePo.po.StudentInfo;
@Data

public class DormStu {
	private int dormStuId;
       private StudentInfo stuId;
       private DormInfo dormId;
       private int dormState;
       private String adjustDate;
}
