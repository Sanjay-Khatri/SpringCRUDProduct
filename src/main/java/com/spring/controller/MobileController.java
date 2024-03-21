package com.spring.controller;

import java.util.Arrays;
import java.util.Optional;

import com.spring.entities.onetomany.MobileEntity;
import com.spring.entities.onetomany.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.spring.repositories.MobileRepository;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping("/mobile")
public class MobileController {

	@Autowired
	private MobileRepository mobileRepositories;

	@PostConstruct
	public void addData(){
//		mobileRepositories.save(new MobileEntity(1, "5918943774"));
//		mobileRepositories.save(new MobileEntity(2, "985698569"));
//		mobileRepositories.save(new MobileEntity(3, "957845896"));
//
//		mobileRepositories.save(new MobileEntity(4, "879654321"));
//		mobileRepositories.save(new MobileEntity(5, "952012365"));
//		mobileRepositories.save(new MobileEntity(6, "859869325"));
	}
	
	@PostMapping("/create")
	public ResponseEntity<?> createMobile(@RequestBody() MobileEntity mobile) {
		mobileRepositories.save(mobile);
		return ResponseEntity.ok(mobile);
	}	

	
	@PostMapping("/delete")
	public ResponseEntity<?> deleteAddress(@RequestParam(name = "mobileId") int id) {
		Optional<MobileEntity> mobile = mobileRepositories.findById(id);
		if (mobile.isPresent()) {
			mobileRepositories.delete(mobile.get());
			return ResponseEntity.ok(mobile.get());
		}
		return ResponseEntity.ok(new MobileEntity());
	}

	@RequestMapping("/sample")
	public Page<MobileEntity> getSample(@RequestParam()int offset, @RequestParam()int pagesize){
		return mobileRepositories.findAll(PageRequest.of(offset, pagesize));
	}

	@GetMapping("/get")
	public MobileEntity getMobile(@RequestParam int id){
		System.out.println("getMobile");
		return mobileRepositories.getMobileByUserId(id).orElse(new MobileEntity());
	}
}
