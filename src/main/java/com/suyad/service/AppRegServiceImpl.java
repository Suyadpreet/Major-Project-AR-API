package com.suyad.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.suyad.binding.CitizenApp;
import com.suyad.entity.CitizenAppEntity;
import com.suyad.repo.CitizenAppRepo;

public class AppRegServiceImpl implements AppRegService
{
	private String SSA_API_URL = "http://192.168.3.1:8081/ssn/{ssn}";
	
	@Autowired
	CitizenAppRepo repo;
	@Override
	public String createCitizenApp(CitizenApp app) 
	{
		Long citizenSsn = app.getCitizenSsn();
		CitizenAppEntity appEntity = repo.findByCitizenSsn(citizenSsn);
		if(appEntity!=null)
		{
			return "Duplicate Application";
		}
		else
		{
			RestTemplate rt = new RestTemplate();
			ResponseEntity<String> forEntity = rt.getForEntity(SSA_API_URL, String.class, citizenSsn);
			String body = forEntity.getBody();
			if(body.equals("Rhode Island"))
			{
				CitizenAppEntity entity = new CitizenAppEntity();
				BeanUtils.copyProperties(app, entity);
				CitizenAppEntity save = repo.save(entity);
				return "Application created with caseNum = "+save.getCaseNum();
			}
			else
			{
				return "Invalid Ssn";
			}
		}
	}

	@Override
	public List<CitizenApp> getApplications(Integer userId, String userType) 
	{
		List<CitizenAppEntity> entities = null;
		List<CitizenApp> apps = new ArrayList();
		if("Admin".equals(userType))
		{
			entities = repo.findAll();
		}
		else
		{
			entities = repo.findByCreatedBy(userId);
		}
		for(CitizenAppEntity entity:entities)
		{
			CitizenApp app = new CitizenApp();
			BeanUtils.copyProperties(entity, app);
			apps.add(app);
		}
		return apps;
	}

}
