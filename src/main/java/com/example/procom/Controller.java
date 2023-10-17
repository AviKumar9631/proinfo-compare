package com.example.procom;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class Controller {

	@Autowired
	private CompareResponses compareResponses;

	@PostMapping("/compare")
	public List<Map<String, Object>>  compare(@RequestBody Map<String, List<String>> map) {
	 return	compareResponses.compareApi(map.get("data"));
	}
	
}
