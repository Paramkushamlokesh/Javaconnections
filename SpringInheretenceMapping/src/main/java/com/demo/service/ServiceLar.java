package com.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.Repositry.BrokerRepo;
import com.demo.Repositry.CustomerRepo;
import com.demo.Repositry.DealRepo;
import com.demo.Repositry.PropertyRepo;
import com.demo.Repositry.UserRepo;
import com.demo.model.Broker;
import com.demo.model.Customer;
import com.demo.model.Property;

import jakarta.annotation.PostConstruct;

@Service
public class ServiceLar {


	@Autowired
//	@Qualifier("brokerRepo")
	UserRepo  ur;
	
	@Autowired
//	@Qualifier("customerRepo")
	BrokerRepo  br;
	
	@Autowired
//	@Qualifier("userRepo")
	CustomerRepo  cr;
	
	@Autowired
	PropertyRepo  pr;
	
	@Autowired
	DealRepo dr;

	
	@PostConstruct
	public void init() {
		
		Customer c=new Customer("Ramesh","12345","ramesh k");
		Broker b=new Broker("lokesh","12345","lokesh Paramkusham");
//		User u=new User("rama","12345");
		System.out.println("customer saved"+"\t"+cr.save(c));
		System.out.println("broker saved"+"\t"+br.save(b));
		
		
////////		//
		Optional<Broker> fetchedBrokerop1=br.findById(2);
		Broker fetchedBroker1=(fetchedBrokerop1.isPresent())?fetchedBrokerop1.get():null;
		Property p1=new Property("configuration1","Buy",2000.00,24.00,"hyd",
				"hyd","hyd",false,fetchedBroker1);
		fetchedBroker1.getList().add(p1);
		br.save(fetchedBroker1);
//		pr.save(p1);
//////////
		Optional<Broker> fetchedBrokerop2=br.findById(2);
		Broker fetchedBroker2=(fetchedBrokerop2.isPresent())?fetchedBrokerop2.get():null;
		Property p2=new Property("configuration2","Sell",2000.00,24.00,"hyd",
				"hyd","hyd",false,fetchedBroker2);
		fetchedBroker2.getList().add(p2);
		br.save(fetchedBroker2);
//		pr.save(p2);
///////////
		
		Optional<Property> prooptional1= pr.findById(1);
		if(prooptional1.isPresent()) System.out.println("\t"+prooptional1.get());
		Optional<Property> prooptional2= pr.findById(2);
		if(prooptional2.isPresent()) System.out.println("\t"+prooptional2.get());
//		br.findById(b.)
//		br.delete(b);
		
//		Optional<Customer> op1=cr.findById(1);
//		if(op1.isPresent()) System.out.println(op1.get());
		Optional<Broker> op2=br.findById(2);
		if(op2.isPresent()) {
			for(Property x: op2.get().getList()) {
				System.out.println("\n"+x);
			}
		}
		
		
		
// System.out.println("\t"+op3.get().getList());
//		
//		Optional<User> op3=ur.findById(2);
//		if(op3.isPresent()) System.out.println(op3.get());
		
		
		
//		cr.delete(c);

//		ur.save(u);
		
	}
	
	
}
