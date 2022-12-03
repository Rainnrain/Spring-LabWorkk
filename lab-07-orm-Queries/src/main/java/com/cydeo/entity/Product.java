package com.cydeo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.repository.cdi.Eager;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Product extends BaseEntity{
    private String name;
    private BigDecimal price;
    private Integer quantity;
    private Integer remainingQuantity;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="product_category_rel",
            joinColumns = @JoinColumn(name="p_id"),
            inverseJoinColumns = @JoinColumn(name="c_id"))

    private List<Category> category;


}
