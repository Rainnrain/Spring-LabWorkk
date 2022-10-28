package com.cydeo.lab06orm.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
public class Customer extends BaseEntity {
    private String email;
    private String firstName;
    private String lastName;
    private String userName;
    @OneToMany(mappedBy = "customer")
    private List<Address> address;
}
