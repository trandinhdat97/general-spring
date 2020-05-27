package com.trandinhdat.security.controller;

import java.util.HashMap;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.trandinhdat.security.model.Section;
import com.trandinhdat.security.repository.SectionRepository;

@RestController
public class HelloWorldController {
	@Autowired
	SectionRepository sectionRepository;
	
	@GetMapping("/admin")
	@PreAuthorize("hasRole('ADMIN')")
	public String helloAdmin() {
		return "Hello ADMIN";
	}
	
	@GetMapping("/user")
	@PreAuthorize("hasRole('USER')")
	@PostFilter("hasPermission()")
	public String helloUser() {
		return "Hello USER";
	}
	
	@GetMapping("/section/{id}")
	public HashMap<String, Object> getSection(@PathVariable Long id ) {
		HashMap<String, Object> map = new HashMap<>();
		
		Set<Section> lst = sectionRepository.findByParent_id(null);
		map.put("value", lst);
		return map;
	}

}
