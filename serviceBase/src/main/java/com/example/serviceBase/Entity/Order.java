package com.example.serviceBase.Entity;


import com.example.serviceBase.Repository.StatusOrder;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;


@Entity
@Table(name="order_users")
public class Order {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @ElementCollection(targetClass = StatusOrder.class,fetch = FetchType.EAGER)
    @CollectionTable(name="order_status",joinColumns=@JoinColumn(name="order_status"))
    @Enumerated(EnumType.STRING)
    private Set<StatusOrder>statusOrder;


    @CreationTimestamp
    private LocalDateTime date_Open;
    @CreationTimestamp
    private LocalDateTime date_Close;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="user_id")
    private Users users_id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="model_id")
    private Model model_id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="brand_id")
    private Brand brand_id;
}
