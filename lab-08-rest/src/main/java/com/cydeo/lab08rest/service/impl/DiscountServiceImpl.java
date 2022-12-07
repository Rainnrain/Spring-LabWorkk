package com.cydeo.lab08rest.service.impl;

import com.cydeo.lab08rest.dto.DiscountDTO;
import com.cydeo.lab08rest.entity.Discount;
import com.cydeo.lab08rest.mapper.MapperUtil;
import com.cydeo.lab08rest.repository.DiscountRepository;
import com.cydeo.lab08rest.service.DiscountService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DiscountServiceImpl implements DiscountService {

 private final DiscountRepository discountRepository;
 private final MapperUtil mapperUtil;

    public DiscountServiceImpl(DiscountRepository discountRepository, MapperUtil mapperUtil) {
        this.discountRepository = discountRepository;
        this.mapperUtil = mapperUtil;
    }

    @Override
    public List<DiscountDTO> findDiscounts() {
     return  discountRepository.findAll().stream()
               .map(p->mapperUtil.convert(p, new DiscountDTO()))
               .collect(Collectors.toList());
    }

    @Override
    public DiscountDTO createDiscount(DiscountDTO discountDTO) {
        discountDTO.setId(null);
        discountRepository.save( mapperUtil.convert(discountDTO, new Discount()));
        return discountDTO;
    }

    @Override
    public void updateDiscount(DiscountDTO discountDTO) {
        discountRepository.save( mapperUtil.convert(discountDTO, new Discount()));
    }


    @Override
    public DiscountDTO findDiscoundsByName(String name) {

     return mapperUtil.convert(discountRepository.findFirstByName(name), new DiscountDTO());
    }
}
