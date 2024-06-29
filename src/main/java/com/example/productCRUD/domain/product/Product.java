package com.example.productCRUD.domain.product;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="product")
@Entity(name="product")
@EqualsAndHashCode(of="id")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {

	@Id @GeneratedValue(strategy= GenerationType.UUID)
	private String id;
	
	private String name;
	
	private Integer price_in_cents;

	public Product(RequestProduct requestProduct) {
		
		this.id = requestProduct.id();
		this.name = requestProduct.name();
		this.price_in_cents = requestProduct.price_in_cents();
	}

	public Product(String name, Integer price_in_cents) {
		super();
		this.name = name;
		this.price_in_cents = price_in_cents;
	}

	
	public Product() {}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPrice_in_cents() {
		return price_in_cents;
	}

	public void setPrice_in_cents(Integer price_in_cents) {
		this.price_in_cents = price_in_cents;
	};
	

	



}

