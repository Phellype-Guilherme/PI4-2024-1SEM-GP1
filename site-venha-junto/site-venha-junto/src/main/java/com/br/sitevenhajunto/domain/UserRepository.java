package com.br.sitevenhajunto.domain;

import com.br.sitevenhajunto.domain.entitie.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User getUserByEmail(String email);

}
