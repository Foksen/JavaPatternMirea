package ru.mirea.lab19.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "orders")
@Getter
@Setter
public class Order {
    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "ordersIdSeq", sequenceName = "orders_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ordersIdSeq")
    private int id;

    @Column(name = "order_date")
    private Date orderDate;

    @ManyToOne()
    @JoinColumn(name = "item_id", nullable = false)
    private Item item;
}
