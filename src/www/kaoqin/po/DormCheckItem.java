package www.kaoqin.po;


import lombok.Data;
@Data
/**
 * 对dormitory_inspect_item寝室检查子项的实体抽象
 * @author chen gen
 *
 */
public class DormCheckItem {
      private int checkItemId;
      private int checkOder;//检查项序号
      private int checkScore;//检查项分值
      private int checkSort;//检查排序值
            
}
