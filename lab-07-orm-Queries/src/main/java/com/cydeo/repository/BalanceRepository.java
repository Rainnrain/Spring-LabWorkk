package com.cydeo.repository;


import com.cydeo.entity.Balance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import javax.persistence.Entity;
import java.util.List;


@Repository
public interface BalanceRepository extends JpaRepository<Balance, Long> {
    //Write a derived query to check balance exists for specific customer
    boolean existsBalanceByAmountGreaterThan(Double a);

    //Write a derived query to get balance for specific customer
    Balance findByCustomerId(Long id);

    //Write a native query to get top 5 max balance


   @Query(value = "select * from balance order by amount desc limit 5;",nativeQuery = true)
    List<Balance> listMax5Balance();

    //Write a derived query to get all balances greater than or equal specific balance amount

    List<Balance> findBalanceByAmountGreaterThanEqual(Double a);
    //Write a native query to get all balances less than specific balance amount

    @Query(value = "select * from balance where amount < ?1", nativeQuery = true)
    List<Balance> listOfBalancesBelow(Double d);
}
