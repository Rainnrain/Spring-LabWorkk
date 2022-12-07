package com.cydeo.lab08rest.controller;

import com.cydeo.lab08rest.dto.DiscountDTO;
import com.cydeo.lab08rest.model.ResponseWrapper;
import com.cydeo.lab08rest.service.DiscountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/discount")
public class DiscountController {


    private final DiscountService discountService;


    public DiscountController(DiscountService discountService) {
        this.discountService = discountService;
    }

    @GetMapping
   public ResponseEntity <ResponseWrapper> getDiscount(){
        List<DiscountDTO> discounts=discountService.findDiscounts();
       return ResponseEntity.ok(new ResponseWrapper("Discounts displayed", discounts ,HttpStatus.OK));
    }

    @PostMapping
    public ResponseEntity<ResponseWrapper> createDiscount(@RequestBody DiscountDTO discountDTO){
        DiscountDTO dto=discountService.createDiscount(discountDTO);
        return ResponseEntity.ok(new ResponseWrapper("Discount Created",dto, HttpStatus.OK ));
    }

    @PutMapping
    public ResponseEntity<ResponseWrapper> updateDiscount(@RequestBody DiscountDTO discountDTO){
        discountService.updateDiscount(discountDTO);
        return ResponseEntity.ok(new ResponseWrapper("Discount Created", HttpStatus.OK ));
    }

    @GetMapping("/{name}")
    public ResponseEntity<ResponseWrapper> updateDiscount(@PathVariable("name") String name){
        DiscountDTO dtos=discountService.findDiscoundsByName(name);
        return ResponseEntity.ok(new ResponseWrapper("Discount Created",dtos,  HttpStatus.OK ));
    }

}
