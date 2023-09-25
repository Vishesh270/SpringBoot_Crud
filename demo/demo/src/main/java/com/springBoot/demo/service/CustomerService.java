package com.springBoot.demo.service;

import com.springBoot.demo.model.Customer;
import com.springBoot.demo.model.DueBill;

public interface CustomerService {
	 	public DueBill getDueBillDetails(Integer billId) throws Exception;
	    public Integer addBillAndCustomer(DueBill dueBill) throws Exception;
	    public Integer sanctionBillToExistingCustomer(Integer customerId,DueBill dueBill) throws Exception;
	    public void closeBill(Integer billId) throws Exception;
	    public Customer getCustomerDetails(Integer customerId) throws Exception;
	    public void deleteBill(Integer billId) throws Exception;
}
