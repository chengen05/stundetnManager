package www.zhuxuejin.po;

import lombok.Data;
import www.basePo.po.StudentInfo;
@Data

/**
 * ��ѧ������ѧ���¼(stu_stipend_code)��ʵ�����
 * @author chen gen
 *
 */

public class StuGrantRecord {
   private int grantrecordId;
   private int stugrandId;//����ѧ�����
   private StudentInfo stuId;//ѧ�����
   private String grantrecordDate;
   private String grantrecordMemo;//��ע
}
