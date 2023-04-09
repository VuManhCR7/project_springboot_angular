package com.llq.training.dao;

import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.llq.training.entity.EmailEntity;

@Repository
@Transactional
public interface EmailDAO extends CrudRepository<EmailEntity, Long>, JpaSpecificationExecutor<EmailEntity>{
}