package org.example.models;

import org.example.enums.PaymentMode;
import org.example.enums.PaymentStatus;

public class Payment extends BaseEntity {

    private PaymentMode paymentMode;

    private int amount;

    private PaymentStatus paymentStatus;

    private String referenceId;
}
