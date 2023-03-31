package com.stl.AdminManager.service;

import java.util.List;
import java.util.Optional;
import com.stl.AdminManager.model.AdminManager;

public interface AdminManagerService {
	String AddManager(AdminManager adminmanager);	
	List<AdminManager> getAllmanagers();
	Optional<AdminManager> getManagerbyId(String email);
	void deleteManager(String email);
	AdminManager updateManager(AdminManager manager, String email);
}
