package com.springBoot.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springBoot.demo.dao.CustomerDao;
import com.springBoot.demo.model.Customer;
import com.springBoot.demo.model.DueBill;

import jakarta.transaction.Transactional;

@Service(value = "CustomerService")
@Transactional
public class CustomerServiceImpl implements CustomerService{
	@Autowired
	private CustomerDao cdao;
	
	
    @Override
    public DueBill getDueBillDetails(Integer billId) throws Exception {
        DueBill dueBill = cdao.getDueBillDetails(billId);
        System.out.println("babhsbbahsajbsahbsabsab");
        if (dueBill == null) {
            throw new Exception("Service.BILL_UNAVAILABLE");
        }
        return dueBill;
    }

	@Override
	public Integer addBillAndCustomer(DueBill dueBill) throws Exception {
		// TODO Auto-generated method stub
		
		return cdao.addBillAndCustomer(dueBill);
		
	}

	@Override
	public Integer sanctionBillToExistingCustomer(Integer customerId, DueBill dueBill) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void closeBill(Integer billId) throws Exception {
		// TODO Auto-generated method stub
		DueBill duebill=cdao.getDueBillDetails(billId);
		if(duebill==null) {
			throw new Exception("Service.BILL_UNAVAILABLE");
		}
		cdao.closeBill(billId);
		
	}

	@Override
	public Customer getCustomerDetails(Integer customerId) throws Exception {
		// TODO Auto-generated method stub
		
		Customer customer=cdao.getCustomerDetails(customerId);
		if(customer==null) {
			throw new Exception("Service.CUSTOMER_UNAVAILABLE");
		}
		
		return customer;
	}

	@Override
	public void deleteBill(Integer billId) throws Exception {
		// TODO Auto-generated method stub
		
		DueBill duebill=cdao.getDueBillDetails(billId);
		if(duebill==null) {
			throw new Exception("Service.LOAN_UNAVAILABLE");
		}
		cdao.deleteBill(billId);
	
	}
}
