package com.example.demo;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class homeContoller 
{
	@Autowired
	staffService ss;
	
	
	@RequestMapping("/")
	public String one()
	{
		return "register";
	}
	
	@PostMapping("/saveData")
	public String getdata(@ModelAttribute("s1") staff s1)
	{
		staff st = new staff();
		
		UUID uuid = UUID.randomUUID();
		
		st.setSid(uuid.toString());
		st.setSname(s1.getSname());
		st.setSemail(s1.getSemail());
		st.setSpass(s1.getSpass());
		
		String x = ss.staffRegister(st);
		System.out.println(x);

		return "redirect:/";
	}
	
	@PostMapping("/checkData")
	public String checkCred(@ModelAttribute("s1") staff s1, HttpSession sk)
	{
		staff h = ss.checkCredi(s1);
		if(h==null)
		{
			return "redirect:/";
		}
		sk.setAttribute("temp", h.getSemail());
		return "redirect:/dash";
	}
	
	@RequestMapping("/dash")
	public String dash(HttpSession sk)
	{
		if(sk.getAttribute("temp")==null)
		{
			return "redirect:/";
		}
		return "dash";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession sk)
	{
		sk.invalidate();
		return("redirect:/");
	}


}
