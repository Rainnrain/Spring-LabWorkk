package com.cydeo.lab06orm.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Data
@NoArgsConstructor
@Entity
public class Category extends BaseEntity{
    private String name;
}
