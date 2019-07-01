package dao;

import java.util.ArrayList;

import pojos.Candidates;
import pojos.Voters;

public interface VoterInterface {

	Voters validateCustomer(String email,String pwd) throws Exception;
	void insertCustomerData(Voters cust)throws Exception;
	ArrayList<Candidates> getAllCandidates()throws Exception;
}
