package com.dazzle.shop.address;

import lombok.Data;

@Data

public class AddressVO {
	private int addr_id;
	private int base;
	private String address;
	private String recipient;
	private String postal_num;
	private String detail_address;
	private String phone_num;
	private String request;
}
