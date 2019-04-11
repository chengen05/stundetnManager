package www.shetuan.po;

/**
 * 对课外活动情况(outclass_activity)的抽象
 */


import lombok.Data;
@Data
public class OutActive {
    private int outActiveId;
    private String activeName;
    private String activeOrg;//主办单位
    private String outactMemo;//备注说明
   
}
