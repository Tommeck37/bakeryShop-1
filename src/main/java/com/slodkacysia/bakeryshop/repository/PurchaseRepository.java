package com.slodkacysia.bakeryshop.repository;

import com.slodkacysia.bakeryshop.entity.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseRepository extends JpaRepository<Purchase, Integer> {

    Purchase save(Purchase purchase);

    Purchase findPurchaseById(Integer id);
}
