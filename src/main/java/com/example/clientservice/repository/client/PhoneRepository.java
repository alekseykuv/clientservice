package com.example.clientservice.repository.client;

import com.example.clientservice.model.client.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhoneRepository extends JpaRepository<Phone, Long> {

    @Modifying
    @Query(nativeQuery = true, value = """
            INSERT INTO client_phones (number_phone, client_id) VALUES (:phone, :clientId)
            """)
    void addPhoneByClientId(long clientId, String phone);

    @Query(nativeQuery = true, value = """
            SELECT cp.number_phone FROM client_phones cp JOIN clients c ON c.id = cp.client_id WHERE c.id = :id
            """)
    List<String> findPhonesByClientId(long id);
}
