package com.llq.training.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.llq.training.dto.EmailDTO;
import com.llq.training.entity.EmailEntity;
import com.llq.training.service.EmailService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class EmailController {

	@Autowired
	private EmailService emailService;
	
	@GetMapping("/emails")
	public List<EmailEntity> getEmails() {
		return this.emailService.getAll();
	}

	@GetMapping("/emails/{id}")
	public Optional<EmailEntity> getEmail(@PathVariable("id") Long id) {
		return this.emailService.findByID(id);
	}
	
	@PostMapping("/addemail")
	public EmailEntity addEmail(@RequestBody EmailEntity newEmail) {
		return emailService.addEmail(newEmail);
	}

	@PutMapping("/emails/{id}")
	public ResponseEntity<EmailEntity> editEmail(@PathVariable(value = "id") Long id, @RequestBody EmailEntity email) {
		return emailService.editEmail(id, email);
	}

	@DeleteMapping("emails/{id}")
	public Map<String, Boolean> deleteEmail(@PathVariable("id") Long id) {
		return emailService.deleteEmail(id);
	}

	@PostMapping("/emails")
	public List<EmailEntity> getNewsByPagingCriteria(@RequestParam("page") int page, @RequestBody EmailDTO emaildto) {
		Pageable firstPageWithFourElements = PageRequest.of(page, 4);
		return emailService.findByPagingCriteria(emaildto, firstPageWithFourElements);
	}

	@PostMapping("/count-emails-by-criteria")
	public Long getCountEmailByCriteria(@RequestBody EmailDTO emaildto) {
		return emailService.findCountByCriteria(emaildto);
	}

}
