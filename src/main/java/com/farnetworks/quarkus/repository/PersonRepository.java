package com.farnetworks.quarkus.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.farnetworks.quarkus.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
   
	Optional<Person> findByEmail(String email);

    List<Person> findByIdIn(List<Long> userIds);

    Optional<Person> findBySurname(String username);

}