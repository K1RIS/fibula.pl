package pl.fibula.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.fibula.entity.Hero;

public interface HeroRepository extends JpaRepository<Hero, Long> {
	
	Hero findByName(String name);
	
}