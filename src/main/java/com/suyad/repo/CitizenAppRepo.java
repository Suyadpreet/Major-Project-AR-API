package com.suyad.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.suyad.entity.CitizenAppEntity;

public interface CitizenAppRepo extends JpaRepository<CitizenAppEntity, Integer>
{
	public CitizenAppEntity findByCitizenSsn(Long ssn);
	
	public List<CitizenAppEntity> findByCreatedBy(Integer userId);
}
