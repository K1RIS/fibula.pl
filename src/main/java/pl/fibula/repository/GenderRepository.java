package pl.fibula.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.fibula.entity.Gender;

public interface GenderRepository extends JpaRepository<Gender, Long> {
	
}