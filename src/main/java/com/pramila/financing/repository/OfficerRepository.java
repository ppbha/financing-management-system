package com.pramila.financing.repository;

import com.pramila.financing.entity.Officer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfficerRepository extends JpaRepository<Officer,Long> {
}
