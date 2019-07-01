package pojos;

public class Voters {

	private int voterId;
	private String name;
	private String emailId;
	private String password;
	private String status;
	
	public Voters()
	{
		
	}

	public Voters(int voterId, String name, String emailId, String password, String status) {
		super();
		this.voterId = voterId;
		this.name = name;
		this.emailId = emailId;
		this.password = password;
		this.status = status;
	}

	public int getVoterId() {
		return voterId;
	}

	public void setVoterId(int voterId) {
		this.voterId = voterId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Voters [voterId=" + voterId + ", name=" + name + ", emailId=" + emailId + ", password=" + password
				+ ", status=" + status + "]";
	}
	
	
}
