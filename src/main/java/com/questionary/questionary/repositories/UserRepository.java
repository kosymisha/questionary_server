package com.questionary.questionary.repositories;

import com.questionary.questionary.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "select * from users where id = ?1", nativeQuery = true)
    User getUserById (String id);

    @Query(value = "select * from users where email = ?1", nativeQuery = true)
    User getUserByEmail (String email);
}
