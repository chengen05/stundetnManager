package www.technology.dao;

import www.technology.po.TechnologyInfo;

public interface TechnologyInfoDAO {
	public boolean insertechnology(TechnologyInfo technology);
	
	public boolean updatatechnology(TechnologyInfo technology);
	
	public boolean deltechnology(int technologyid);

}
