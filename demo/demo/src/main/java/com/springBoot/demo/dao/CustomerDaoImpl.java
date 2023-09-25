package com.springBoot.demo.dao;

import org.springframework.stereotype.Repository;

import com.springBoot.demo.entity.CustomerEntity;
import com.springBoot.demo.entity.DueBillEntity;
import com.springBoot.demo.model.Customer;
import com.springBoot.demo.model.DueBill;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
@Repository(value="CustomerDao")
public class CustomerDaoImpl implements CustomerDao{

	@PersistenceContext
    private EntityManager entityManager;

    @Override
    public DueBill getDueBillDetails(Integer billId) {
        System.out.println("kyunai rha bhai");

        DueBillEntity dueBillEntity = entityManager.find(DueBillEntity.class, billId);

        DueBill dueBill = null;
        if (dueBillEntity != null) {
            dueBill = new DueBill();
            dueBill.setBillId(dueBillEntity.getBillId());
            dueBill.setAmount(dueBillEntity.getAmount());
            dueBill.setBillIssueDate(dueBillEntity.getBillIssueDate());
            dueBill.setStatus(dueBillEntity.getStatus());

            CustomerEntity customerEntity = dueBillEntity.getCustomer();
            if (customerEntity != null) {
                Customer customer = new Customer();
                customer.setCustomerId(customerEntity.getCustomerId());
                customer.setDateOfBirth(customerEntity.getDateOfBirth());
                customer.setEmailId(customerEntity.getEmailId());
                customer.setName(customerEntity.getName());
                dueBill.setCustomer(customer);
            }

        }

        return dueBill;
    }

	@Override
	public Integer addBillAndCustomer(DueBill dueBill) {
		// TODO Auto-generated method stub
		
		DueBillEntity dbentity=new DueBillEntity();
		
		dbentity.setAmount(dueBill.getAmount());
		dbentity.setStatus("unpaid");
		dbentity.setBillIssueDate(dueBill.getBillIssueDate());
		Customer customer=dueBill.getCustomer();
		
		CustomerEntity ce=new CustomerEntity();
		
		ce.setCustomerId(customer.getCustomerId());
		ce.setEmailId(customer.getEmailId());
		ce.setName(customer.getName());
		ce.setDateOfBirth(customer.getDateOfBirth());
		
		dbentity.setCustomer(ce);
		entityManager.persist(dbentity);
		
	
		return dbentity.getBillId();
	}

	@Override
	public Integer sanctionBillToExistingCustomer(Integer customerId, DueBill dueBill) {
		
		DueBillEntity dbentity=new DueBillEntity();
		
		dbentity.setAmount(dueBill.getAmount());
		dbentity.setBillId(dueBill.getBillId());
		dbentity.setBillIssueDate(dueBill.getBillIssueDate());
		dbentity.setStatus(dueBill.getStatus());
		
		CustomerEntity ce= entityManager.find(CustomerEntity.class, customerId);
		
		dbentity.setCustomer(ce);
		
		entityManager.persist(dbentity);	
		return dueBill.getBillId();
	}

	@Override
	public void closeBill(Integer billId) {
		// TODO Auto-generated method stub
		
		DueBillEntity dbentity=entityManager.find(DueBillEntity.class, billId);
		dbentity.setStatus("paid");
		
	}

	@Override
	public Customer getCustomerDetails(Integer customerId) {
		// TODO Auto-generated method stub
		Customer customer=new Customer();
		CustomerEntity ce= entityManager.find(CustomerEntity.class,customerId);
		
		customer.setCustomerId(ce.getCustomerId());
		customer.setDateOfBirth(ce.getDateOfBirth());
		customer.setEmailId(ce.getEmailId());
		customer.setName(ce.getName());	
		return customer;
		
		
	}

	@Override
	public void deleteBill(Integer billId) {
		// TODO Auto-generated method stub
		DueBillEntity dbentity=entityManager.find(DueBillEntity.class, billId);
		dbentity.setCustomer(null);
		entityManager.remove(dbentity);
		
		
	}

}
