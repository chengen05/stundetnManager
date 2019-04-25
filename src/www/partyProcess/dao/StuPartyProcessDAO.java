package www.partyProcess.dao;

import www.partyProcess.po.StuPartyProcessCode;

public interface StuPartyProcessDAO {
       public boolean inserStuPtyProce(StuPartyProcessCode StuPtyProce);
       
       public boolean updataStuPtyProce(StuPartyProcessCode StuPtyProce);
       
       public boolean delStuPtyProce(int stuPartyid);
}
