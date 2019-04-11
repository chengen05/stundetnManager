package www.kaoqin.po;

/**
 * 对寝室信息表(dormitory_info)的实体抽象
 * @author chen gen
 *
 */

import lombok.Data;
@Data
public class DormInfo {
	private int dormId;
	private String buildName;//宿舍楼名称
	private String rootNum;//房间名称
}
