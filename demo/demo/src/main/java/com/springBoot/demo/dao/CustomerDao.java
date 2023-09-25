package com.springBoot.demo.dao;

import com.springBoot.demo.model.Customer;
import com.springBoot.demo.model.DueBill;

public interface CustomerDao {
    public DueBill getDueBillDetails(Integer billId);

    public Integer addBillAndCustomer(DueBill dueBill);

    public Integer sanctionBillToExistingCustomer(Integer customerId, DueBill dueBill);

    public void closeBill(Integer billId);

    public Customer getCustomerDetails(Integer customerId);

    public void deleteBill(Integer billId);
}
