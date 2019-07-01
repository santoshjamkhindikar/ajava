package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import pojos.Candidates;
import pojos.Voters;
import utils.DBUtils;

public class VoterClass implements VoterInterface {
	
	private Connection cn;
	private PreparedStatement pst1,pst2,pst3;

	// constr
	public VoterClass() throws Exception {
		// get cn from DBUtils
		cn = DBUtils.fetchConnection();
		// pst1
		pst1 = cn.prepareStatement("select * from voters where email=? and password=?");
		pst2 = cn.prepareStatement("insert into voters values(default,?,?,?,?)");
		pst3 = cn.prepareStatement("select * from candidates");
		System.out.println("dao created...");
	}

	// clean up
	public void cleanUp() throws Exception {
		if (pst1 != null)
			pst1.close();
		if (cn != null)
			cn.close();
		System.out.println("dao cleaned up...");
	}

	@Override
	public Voters validateCustomer(String email, String pwd) throws Exception {
		// set IN params
		pst1.setString(1, email);
		pst1.setString(2, pwd);
		try (ResultSet rst = pst1.executeQuery()) {
			if (rst.next())
				return new Voters(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5));
		}
		return null;
	}

	@Override
	public void insertCustomerData(Voters cust) throws Exception {
		
		pst2.setString(1, cust.getName());
		pst2.setString(2, cust.getEmailId());
		pst2.setString(3, cust.getPassword());
		pst2.setString(4, cust.getStatus());
		pst2.execute();
		System.out.println("Data Inserted");
	}

	@Override
	public ArrayList<Candidates> getAllCandidates() throws Exception {
		
		ArrayList<Candidates> candidateName = new ArrayList<Candidates>();
		try(ResultSet rst = pst3.executeQuery())
		{
			while(rst.next())
			{
				Candidates canObj = new Candidates(rst.getInt(1),rst.getString(2),rst.getString(3),rst.getInt(4));
				candidateName.add(canObj);
			}
		}
		return candidateName;
	}

}
