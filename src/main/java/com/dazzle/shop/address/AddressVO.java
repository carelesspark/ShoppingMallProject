package com.dazzle.shop.address;

import lombok.Data;

@Data

public class AddressVO {
	private int base;
	private String name;
	private String postalCode;
	private String addr;
	private String detailAddr;
	private String phoneNumber;
	private String request;
}
