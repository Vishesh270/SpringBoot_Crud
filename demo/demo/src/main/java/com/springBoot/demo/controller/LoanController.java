package com.springBoot.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springBoot.demo.model.Customer;
import com.springBoot.demo.model.DueBill;
import com.springBoot.demo.service.CustomerService;

import io.swagger.annotations.Api;

@Controller
@RequestMapping(value = "/api")
@Api
public class LoanController {
   
    @Autowired
    private  CustomerService cservice;

    @GetMapping(value = "/bills/{billId}")
    public ResponseEntity<DueBill> getDueBillDetails(@PathVariable Integer billId) throws Exception {
        System.out.println("this is vishesh testing");
        DueBill dueBill = cservice.getDueBillDetails(billId);
        ResponseEntity<DueBill> response = new ResponseEntity<DueBill>(dueBill, HttpStatus.OK);
        return response;
    }
    

    
    @PostMapping(value="/addloan")
    public ResponseEntity<String> addBillAndCustomer(@RequestBody DueBill duebill) throws Exception{
    	System.out.println("add loan spi trigger");
    	cservice.addBillAndCustomer(duebill);
    	String successMessage="loan added succefully";
    	ResponseEntity<String> response=new ResponseEntity<String>(successMessage,HttpStatus.CREATED);
    	return response;
    	
  
    }
    
    
    @DeleteMapping(value="/deletebill/{billId}")
    public ResponseEntity<String> addBillAndCustomer(@PathVariable Integer billId) throws Exception{
    	System.out.println("loan deleted succesfully");
    	cservice.deleteBill(billId);
    	String successMessage="loan deleted succefully";
    	ResponseEntity<String> response=new ResponseEntity<String>(successMessage,HttpStatus.OK);
    	return response;
    	
  
    }
    
    @GetMapping(value="customer/{customerId}")
    public ResponseEntity<Customer> getCustomerDetails(@PathVariable Integer customerId) throws Exception{
    	System.out.println("this is vishesh testing");
        Customer customer = cservice.getCustomerDetails(customerId);
        ResponseEntity<Customer> response = new ResponseEntity<Customer>(customer, HttpStatus.OK);
        return response;
    }

}
