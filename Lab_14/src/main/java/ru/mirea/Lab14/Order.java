package ru.mirea.Lab14;

public class Order {
    private Item item;
    private String orderDate;

    public Order(Item item, String orderDate) {
        this.item = item;
        this.orderDate = orderDate;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    @Override
    public boolean equals(Object obj) {
        return this.getItem().equals(((Order) obj).getItem()) &&
                this.getOrderDate().equals(((Order) obj).getOrderDate());
    }
}