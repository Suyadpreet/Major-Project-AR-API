package com.suyad.service;

import java.util.List;

import com.suyad.binding.CitizenApp;

public interface AppRegService 
{
	public String createCitizenApp(CitizenApp app);
	
	public List<CitizenApp> getApplications(Integer userId, String userType);
}
