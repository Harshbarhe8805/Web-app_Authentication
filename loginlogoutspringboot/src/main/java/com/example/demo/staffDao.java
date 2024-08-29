package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class staffDao implements staffService {
	
	@Autowired
	staffRepo sr;

	@Override
	public String staffRegister(staff s1) 
	{
		sr.save(s1);
		return "Record Saved";
	}

	@Override
	public staff checkCredi(staff s1) 
	{
		staff s=sr.findBySemailAndSpass(s1.getSemail(),s1.getSpass());
		return s;
	}

}
