package com.dazzle.shop.model.address;

import lombok.Data;

@Data
public class AddressVO {
	private int user_num;
	private int addr_num;
	private int base;
	private String address;
	private String recipient;
	private String postal_num;
	private String detail_address;
	private String phone_num;
	private String request;
}
