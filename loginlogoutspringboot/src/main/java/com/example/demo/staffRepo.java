package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface staffRepo extends JpaRepository<staff,String> 
{
	public staff findBySemail(String k);
	
	public staff findBySemailAndSpass(String e, String p);
	

}
