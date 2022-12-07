package com.cydeo.lab08rest.service;

import com.cydeo.lab08rest.dto.DiscountDTO;

import java.util.List;

public interface DiscountService {

  List<DiscountDTO> findDiscounts();

  DiscountDTO createDiscount(DiscountDTO discountDTO);
  void updateDiscount(DiscountDTO discountDTO);
  DiscountDTO findDiscoundsByName(String name);
}
