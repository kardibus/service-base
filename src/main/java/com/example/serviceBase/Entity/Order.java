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

    private int price;

    private String serialnumber;

    private String about_repair;

    private String defects;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<StatusOrder> getStatusOrder() {
        return statusOrder;
    }

    public void setStatusOrder(Set<StatusOrder> statusOrder) {
        this.statusOrder = statusOrder;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getSerialnumber() {
        return serialnumber;
    }

    public void setSerialnumber(String serialnumber) {
        this.serialnumber = serialnumber;
    }

    public String getAbout_repair() {
        return about_repair;
    }

    public void setAbout_repair(String about_repair) {
        this.about_repair = about_repair;
    }

    public String getDefects() {
        return defects;
    }

    public void setDefects(String defects) {
        this.defects = defects;
    }

    public LocalDateTime getDate_Open() {
        return date_Open;
    }

    public void setDate_Open(LocalDateTime date_Open) {
        this.date_Open = date_Open;
    }

    public LocalDateTime getDate_Close() {
        return date_Close;
    }

    public void setDate_Close(LocalDateTime date_Close) {
        this.date_Close = date_Close;
    }

    public Users getUsers_id() {
        return users_id;
    }

    public void setUsers_id(Users users_id) {
        this.users_id = users_id;
    }

    public Model getModel_id() {
        return model_id;
    }

    public void setModel_id(Model model_id) {
        this.model_id = model_id;
    }

    public Brand getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(Brand brand_id) {
        this.brand_id = brand_id;
    }
}
