package com.questionary.questionary.repositories;

import com.questionary.questionary.models.Form;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FormRepository extends JpaRepository<Form, Long> {

    @Query(value = "select * from forms where id = ?1", nativeQuery = true)
    Form getFormById (String id);

}
