package com.healthclinic.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Billing {

    private int billId;
    private int appointmentId;
    private BigDecimal amount;
    private String paymentStatus;
    private String paymentMethod;
    private LocalDate billDate;

    public Billing() {
    }

    public Billing(int billId, int appointmentId,
                   BigDecimal amount,
                   String paymentStatus,
                   String paymentMethod,
                   LocalDate billDate) {
        this.billId = billId;
        this.appointmentId = appointmentId;
        this.amount = amount;
        this.paymentStatus = paymentStatus;
        this.paymentMethod = paymentMethod;
        this.billDate = billDate;
    }

    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public LocalDate getBillDate() {
        return billDate;
    }

    public void setBillDate(LocalDate billDate) {
        this.billDate = billDate;
    }

    @Override
    public String toString() {
        return "\nBill ID : " + billId +
                "\nAppointment ID : " + appointmentId +
                "\nAmount : " + amount +
                "\nPayment Status : " + paymentStatus +
                "\nPayment Method : " + paymentMethod +
                "\nBill Date : " + billDate;
    }
}