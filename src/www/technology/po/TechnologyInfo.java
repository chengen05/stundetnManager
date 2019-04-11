package www.technology.po;

import lombok.Data;
@Data

/**
 * 对科研类型信息表(technology_research_type)的实体抽象
 * @author chen gen
 *
 */
public class TechnologyInfo {
	private int technologyId;
	private String technologyType;
	private String grade;
	private String description;
}
