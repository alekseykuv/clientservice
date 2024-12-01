package com.example.clientservice.repository.client;

import com.example.clientservice.model.client.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneRepository extends JpaRepository<Phone, Long> {

    @Modifying
    @Query(nativeQuery = true, value = """
            INSERT INTO client_phones (number_phone, client_id) VALUES (:phone, :clientId)
            """)
    void addPhoneByClientId(long clientId, String phone);
}
