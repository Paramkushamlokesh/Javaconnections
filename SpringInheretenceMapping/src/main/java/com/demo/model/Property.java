package com.demo.model;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
public class Property {
     
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer propId;
	private String configuration;
	private String offerType ;
	private Double offerCost;
	private Double areaSqft;
	private String address;
	private String street;
	private String city;
	private Boolean status;
	
	@OneToOne
	private Broker broker;
	
	public Property() {
		
	}
	

	public Property(String configuration, String offerType, Double offerCost, Double areaSqft, String address,
			String street, String city, Boolean status, Broker broker) {
		this.configuration = configuration;
		this.offerType = offerType;
		this.offerCost = offerCost;
		this.areaSqft = areaSqft;
		this.address = address;
		this.street = street;
		this.city = city;
		this.status = status;
		this.broker = broker;
	}


	
	
	
	
}
