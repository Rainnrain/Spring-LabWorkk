package com.cydeo.lab06orm.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
public class Customer extends BaseEntity {
    private String email;
    private String firstName;
    private String lastName;
    private String userName;
    @OneToOne
    private Balance balance;
    @OneToMany(mappedBy = "customer")
    private List<Address> address;
}
