package com.merzmostafaei.store.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

//--Creating Entities for cartshoping
@Getter
@Setter
@Entity
@Table(name = "carts")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;

    //with insertable and updatable false we tall hybernate ignore this feild and generate sql statement
    @Column(name = "date_created",insertable = false,updatable = false)
    private LocalDate dateCreated;

    @OneToMany(mappedBy = "cart",cascade = CascadeType.MERGE)
    private Set<CartItem> cartItems = new LinkedHashSet<>();

}
