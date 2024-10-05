package com.tpe.backendproject.InitialWork.repository;

import com.tpe.backendproject.InitialWork.entity.ContactMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public interface ContactMessageRepository extends JpaRepository<ContactMessage,Long> {

    List<ContactMessage> findByEmail(String email);
}
