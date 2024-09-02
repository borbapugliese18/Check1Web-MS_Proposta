package com.github.borbapugliese18.ms_proposta.repository;

import com.github.borbapugliese18.ms_proposta.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByCpf(String cpf);
}
