package com.suyad.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.suyad.binding.CitizenApp;
import com.suyad.service.AppRegService;

@RestController
public class AppRestController 
{
	@Autowired
	private AppRegService service;
	
	@PostMapping("/app")
	public ResponseEntity<String> createApp(@RequestBody CitizenApp app)
	{
		String response = service.createCitizenApp(app);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	public ResponseEntity<List<CitizenApp>> getApplications(Integer userId,String userType)
	{
		List<CitizenApp> apps = service.getApplications(userId, userType);
		
		return new  ResponseEntity<>(apps,HttpStatus.OK);
	}
}
