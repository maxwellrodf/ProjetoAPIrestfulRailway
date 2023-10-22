package com.maxwell.projetoapinuvem.repository;

import com.maxwell.projetoapinuvem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
boolean existsByAccountNumber(String accountNumber);

}
