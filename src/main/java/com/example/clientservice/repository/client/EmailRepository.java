package com.example.clientservice.repository.client;

import com.example.clientservice.model.client.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailRepository extends JpaRepository<Email, Long> {

    @Modifying
    @Query(nativeQuery = true, value = """
            INSERT INTO client_emails (email, client_id) VALUES (:email, :clientId)
            """)
    void addEmailByClientId(long clientId, String email);
}
