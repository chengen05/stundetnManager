package www.shetuan.dao;

import www.shetuan.po.InstituteJob;

public interface InstituteJobDAO {
	public boolean inserInstitJob (InstituteJob InstitJob);
	
	public boolean updataInstitJob (InstituteJob InstitJob);
	
	public boolean delInstitJob (int InstitJobid);
}
