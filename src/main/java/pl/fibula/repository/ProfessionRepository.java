package pl.fibula.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.fibula.entity.Profession;

public interface ProfessionRepository extends JpaRepository<Profession, Long> {
	
}