package www.technology.dao;

import www.technology.po.StuTechnologyCode;

public interface StuTechnologyDAO {
	public boolean inserstutechnology(StuTechnologyCode stutechnology);
	
	public boolean updatastutechnology(StuTechnologyCode stutechnology);
	
	public boolean delstutechnology(int stutechnologyid);

}
