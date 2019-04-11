package www.partyProcess.po;

import lombok.Data;
@Data

/**
 * 对入党流程信息表(party_process_info)的信息
 * @author chen gen
 *
 */
public class PartyProcessInfo {
	private int partyId;
	private String flowName;
	private int sort;
}
