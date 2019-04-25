package www.partyProcess.dao;

import www.partyProcess.po.PartyProcessInfo;

public interface PartyProcessDAO {
	public boolean inserPtyProceCode(PartyProcessInfo PtyProce);
	
	public boolean updataPtyProceCode(PartyProcessInfo PtyProce);
	
	public boolean delPtyProceCode(int partyid);

}
