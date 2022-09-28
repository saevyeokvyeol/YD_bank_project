package dto;

public class AccountState {
	private int stateId;
	private String stateName;
	
	public AccountState() {}

	public AccountState(int stateId, String stateName) {
		this.stateId = stateId;
		this.stateName = stateName;
	}

	public int getStateId() {
		return stateId;
	}

	public String getStateName() {
		return stateName;
	}
}
