package com.stl.AdminManager.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stl.AdminManager.exception.ResourceNotFoundException;
import com.stl.AdminManager.model.AdminManager;
import com.stl.AdminManager.repository.AdminManagerRepo;

@Service
public class AdminManagerServiceImpl implements AdminManagerService {
	
	@Autowired
	AdminManagerRepo adminrepo;

	@Override
	public String AddManager(AdminManager adminmanager) {
		
		if(!adminrepo.existsById(adminmanager.getManageremail())) {
			adminrepo.save(adminmanager);

			return adminmanager.getFirstname() + " Registration is successfull!";
		}
		else {
			System.out.println("Email id already exists!!");
			return "Email id already exists!!";
		}
	}

	@Override
	public List<AdminManager> getAllmanagers() {
		return adminrepo.findAll();
	}

	@Override
	public Optional<AdminManager> getManagerbyId(String email) {
		return adminrepo.findById(email);
	}

	@Override
	public void deleteManager(String email) {
		adminrepo.findById(email);
		adminrepo.deleteById(email);
	}

	@Override
	public AdminManager updateManager(AdminManager manager, String email) {
		AdminManager existingManager = adminrepo.findById(email).orElseThrow(() -> new ResourceNotFoundException("Manager","Id",email));
		existingManager.setFirstname(manager.getFirstname());
		existingManager.setLastname(manager.getLastname());
		existingManager.setManageremail(manager.getManageremail());
		existingManager.setGender(manager.getGender());
		existingManager.setPhonenumber(manager.getPhonenumber());
//		existingManager.setPassword(manager.getPassword());
		adminrepo.save(existingManager);
		return existingManager;
	}

}
