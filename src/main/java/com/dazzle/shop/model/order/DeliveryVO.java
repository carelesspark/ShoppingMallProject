package com.dazzle.shop.model.order;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class DeliveryVO {
	private int delivery_num;
	private int invoice_num;
	private Timestamp delivery_date;
	private String delivery_company;
}
