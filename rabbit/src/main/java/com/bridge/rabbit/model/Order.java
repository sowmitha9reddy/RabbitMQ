package com.bridge.rabbit.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Order {
    private String orderId;
    private String name;
    private String qunatity;
    private String  price;



}
