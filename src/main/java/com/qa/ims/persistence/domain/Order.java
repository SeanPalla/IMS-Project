package com.qa.ims.persistence.domain;

import java.util.Objects;

public class Order {
    private long orderId;
    private float totalAmount;
    private long customerId;
    private int quantity;
    private long itemId;

    public Order() {

    }

    public Order(long orderId, float totalAmount, long customerId, int quantity, long itemId) {
        this.orderId = orderId;
        this.totalAmount = totalAmount;
        this.customerId = customerId;
        this.quantity = quantity;
        this.itemId = itemId;
    }

    public Order(long customerId, int quantity, long itemId) {
        this.customerId = customerId;
        this.quantity = quantity;
        this.itemId = itemId;
    }

    public Order(long orderId, float totalAmount, long customerId, int quantity) {
        this.orderId = orderId;
        this.totalAmount = totalAmount;
        this.customerId = customerId;
        this.quantity = quantity;
    }

    public long getOrderId() {
        return this.orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public float getTotalAmount() {
        return this.totalAmount;
    }

    public void setTotalAmount(float totalAmount) {
        this.totalAmount = totalAmount;
    }

    public long getCustomerId() {
        return this.customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public long getItemId() {
        return this.itemId;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Order)) {
            return false;
        }
        Order order = (Order) o;
        return orderId == order.orderId && totalAmount == order.totalAmount && customerId == order.customerId
                && Objects.equals(quantity, order.quantity) && itemId == order.itemId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, totalAmount, customerId, quantity, itemId);
    }

    @Override
    public String toString() {
        return "{" +
                " orderId='" + getOrderId() + "'" +
                ", totalAmount='" + getTotalAmount() + "'" +
                ", customerId='" + getCustomerId() + "'" +
                ", quantity='" + getQuantity() + "'" +
                ", itemId='" + getItemId() + "'" +
                "}";
    }

}
