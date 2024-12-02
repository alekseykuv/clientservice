package com.example.clientservice.repository.client;

import com.example.clientservice.model.client.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmailRepository extends JpaRepository<Email, Long> {

    @Modifying
    @Query(nativeQuery = true, value = """
            INSERT INTO client_emails (email, client_id) VALUES (:email, :clientId)
            """)
    void addEmailByClientId(long clientId, String email);

    @Query(nativeQuery = true, value = """
            SELECT ce.email FROM client_emails ce JOIN clients c ON c.id = ce.client_id WHERE c.id = :id
            """)
    List<String> findEmailsByClientId(long id);
}
