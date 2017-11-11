package com.bulletproof.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bulletproof.resource.Customer;

@Repository
@Transactional
public class CustomerDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession() {
	return sessionFactory.getCurrentSession();
    }

    public String saveCustomer(Customer customer) {
	Long isSuccess = (Long) getSession().save(customer);
	if (isSuccess >= 1) {
	    return "Success";
	} else {
	    return "Error while Saving Customer";
	}

    }

}
