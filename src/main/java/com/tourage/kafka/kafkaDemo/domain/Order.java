package com.tourage.kafka.kafkaDemo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Order.
 *
 * @author shitianyu 2022-06-28 11:11
 */
@Data
@AllArgsConstructor
public class Order {

    private Integer id;

    private Integer orderId;

    private Integer num;

    private Double price;

}
