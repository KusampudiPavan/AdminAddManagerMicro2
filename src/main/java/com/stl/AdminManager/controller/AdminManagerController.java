package com.stl.AdminManager.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.stl.AdminManager.model.AdminManager;
import com.stl.AdminManager.service.AdminManagerService;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("adminManager")
public class AdminManagerController {

	@Autowired
	AdminManagerService service;

	//Add Manager
	@PostMapping("/addmanager")
	public ResponseEntity<String> AddManager(@RequestBody AdminManager adminmodel){
		String pass = adminmodel.getPassword();
		adminmodel.setPassword(new BCryptPasswordEncoder().encode(pass));
		return new ResponseEntity<String>(service.AddManager(adminmodel),HttpStatus.CREATED);
	}
	
	@GetMapping("/get")
	public List<AdminManager> getAllEmployees(){
		
		return service.getAllmanagers();
	}
	
	//Get Manager by Id
	@GetMapping("/get/{email}")
	public Optional<AdminManager> getEmployeeById(@PathVariable("email") String email){
		return service.getManagerbyId(email);
	}
	
	//Delete Manager
	@DeleteMapping("/delete/{email}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("email") String email){
		service.deleteManager(email);
		return new ResponseEntity<String> ("Manager Deleted Successfully!", HttpStatus.OK);

	}
	
	//Update Manager
	@PutMapping("/update/{email}")
	public ResponseEntity<AdminManager> updateEmployee(@PathVariable("email") String email,@RequestBody AdminManager manager){
		String pass = manager.getPassword();
		manager.setPassword(new BCryptPasswordEncoder().encode(pass));
		return new ResponseEntity<AdminManager> (service.updateManager(manager, email),HttpStatus.OK);
	}

}
