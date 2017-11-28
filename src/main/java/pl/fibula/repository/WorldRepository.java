package pl.fibula.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.fibula.entity.World;

public interface WorldRepository extends JpaRepository<World, Long> {
	
}