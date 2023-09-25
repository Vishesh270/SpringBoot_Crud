package com.springBoot.demo.model;

import java.time.LocalDate;

public class DueBill {
    private Integer billId;
    private Double amount;
    private LocalDate billIssueDate;
    private Customer customer;
    private String status;

    public Integer getBillId() {
        return billId;
    }

    public void setBillId(Integer billId) {
        this.billId = billId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public LocalDate getBillIssueDate() {
        return billIssueDate;
    }

    public void setBillIssueDate(LocalDate billIssueDate) {
        this.billIssueDate = billIssueDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
