package www.kaoqin.po;


/**��������סѧ����ʵ�����(stu_dormitory)
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
