package com.ritesh.survey.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ritesh.survey.templates.UserDetails;

@Repository
public interface UserRepository extends JpaRepository<UserDetails, Long> {

	List<UserDetails> findByRole(String role);
}