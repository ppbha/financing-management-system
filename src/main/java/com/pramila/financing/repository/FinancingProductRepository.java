package com.pramila.financing.repository;

import com.pramila.financing.entity.FinancingProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FinancingProductRepository extends JpaRepository<FinancingProduct,Long> {
}
