package com.schoolmanagement.javaPractice.payloads.request;

public class StudentFeePay {
    private Integer amount;

    public StudentFeePay() {
    }

    public StudentFeePay(Integer amount) {
        this.amount = amount;
    }

    public Integer getAmount() {
        return amount;
    }
}
