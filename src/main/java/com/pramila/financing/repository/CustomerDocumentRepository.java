package com.pramila.financing.repository;

import com.pramila.financing.entity.CustomerDocuments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDocumentRepository extends JpaRepository<CustomerDocuments,Long> {
}
