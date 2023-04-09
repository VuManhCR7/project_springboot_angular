package com.llq.training.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.llq.training.dao.EmailDAO;
import com.llq.training.dto.EmailDTO;
import com.llq.training.entity.EmailEntity;

@Service
public class EmailService {
	@Autowired
	private EmailDAO emailDAO;
	
	public Long findCountByCriteria(EmailDTO emaildto){
	       return this.emailDAO.count(new Specification<EmailEntity>() {
	           @Override
	           public Predicate toPredicate(Root<EmailEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
	               List<Predicate> predicates = new ArrayList<>();
	               if(emaildto.getMa()!=null && emaildto.getMa()!=""){
	            	   predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("ma"), emaildto.getMa())));
	               }	              
	               return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
	           }
	       });
	}

	
	public List<EmailEntity> findByPagingCriteria(EmailDTO emaildto, Pageable pageable){
	        Page<EmailEntity> page = emailDAO.findAll(new Specification<EmailEntity>() {
	            @Override
	            public Predicate toPredicate(Root<EmailEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
	                List<Predicate> predicates = new ArrayList<>();	          
	                if(emaildto.getMa() != null && emaildto.getMa().trim() != "") {
	                	predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("ma"), emaildto.getMa())));
	                }
	                if(emaildto.getNoi_dung() != null && emaildto.getNoi_dung().trim() != "") {
	                	predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("noi_dung"), emaildto.getNoi_dung())));
	                }
	                if(emaildto.getNguoi_tao() != null && emaildto.getNguoi_tao().trim() != "") {
	                	predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("nguoi_tao"), emaildto.getNguoi_tao())));
	                }
	                if(emaildto.getNgay_tao() != null) {
	                	predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("ngay_tao"), emaildto.getNgay_tao())));
	                }
	                if(emaildto.getNguoi_sua() != null && emaildto.getNguoi_sua().trim() != "") {
	                	predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("nguoi_sua"), emaildto.getNguoi_sua())));
	                }
	                if(emaildto.getNgay_sua() != null) {
	                	predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("ngay_sua"), emaildto.getNgay_sua())));
	                }
	                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
	            }
	        }, pageable);
	        page.getTotalElements();        // get total elements
	        page.getTotalPages();           // get total pages
	        return page.getContent();       // get List of Employee
	}
	
	public List<EmailEntity> getAll() {
		return (List<EmailEntity>) emailDAO.findAll();
	}
	
	public Optional<EmailEntity> findByID(Long id) {
		return emailDAO.findById(id);
	}
	
	public EmailEntity addEmail(EmailEntity newEmail) {
		return emailDAO.save(newEmail);
	}
	
	public ResponseEntity<EmailEntity> editEmail(@PathVariable(value = "id") Long id,@RequestBody EmailEntity emailDetails) {
		EmailEntity email = emailDAO.findById(id).orElseThrow();
		
		email.setMa(emailDetails.getMa());
		email.setNoi_dung(emailDetails.getNoi_dung());
		email.setNguoi_tao(emailDetails.getNguoi_tao());
		email.setNgay_tao(emailDetails.getNgay_tao());
		email.setNguoi_sua(emailDetails.getNguoi_sua());
		email.setNgay_sua(emailDetails.getNgay_sua());
		
		final EmailEntity editEmail = emailDAO.save(email);
		
		return ResponseEntity.ok(editEmail);
	}
	
	public Map<String, Boolean> deleteEmail(@PathVariable(value = "id") Long id) {
		EmailEntity email = emailDAO.findById(id).orElseThrow();
		
		emailDAO.delete(email);
		Map<String, Boolean> response =  new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}

