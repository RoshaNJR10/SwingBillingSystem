package com.nist.billingsystem.bill;

public class ProductDto {
	int id,quantity;
	String name;
	float price,amount;
	
	public ProductDto(int id,String name,int quantity,float price)
	{
		this.name=name;
		this.id=id;
		this.quantity=quantity;
		this.price=price;
	}
	
	

}
