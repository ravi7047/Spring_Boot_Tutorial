package com.nareshit.transactionmgmt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nareshit.transactionmgmt.dao.AuditDao;
import com.nareshit.transactionmgmt.model.Audit;

@Service
public class AuditService {

	@Autowired
	private AuditDao auditDao;

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public Audit updateAudit(Audit auditObj) {
		return auditDao.save(auditObj);
	}
}
