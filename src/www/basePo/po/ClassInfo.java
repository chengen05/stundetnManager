package www.basePo.po;


/**
 * 对班级信息表(class_info)的实体抽象
 * @author chen gen
 *
 */

import lombok.Data;
@Data

public class ClassInfo {
	private int classInfoId;
	private String className;
	private String meetRoom;
	private int headMasterId;
	private int majorId;
	
}
