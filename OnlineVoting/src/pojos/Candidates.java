package pojos;

public class Candidates {
	
	private int id;
	private String name;
	private String party;
	private int totalVotes;
	
	public Candidates()
	{
		
	}

	public Candidates(int id, String name, String party, int totalVotes) {
		super();
		this.id = id;
		this.name = name;
		this.party = party;
		this.totalVotes = totalVotes;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getParty() {
		return party;
	}

	public void setParty(String party) {
		this.party = party;
	}

	public int getTotalVotes() {
		return totalVotes;
	}

	public void setTotalVotes(int totalVotes) {
		this.totalVotes = totalVotes;
	}

	@Override
	public String toString() {
		return "Candidates [id=" + id + ", name=" + name + ", party=" + party + ", totalVotes=" + totalVotes + "]";
	}
	
	
}
