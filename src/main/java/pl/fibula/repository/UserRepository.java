package pl.fibula.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.fibula.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByName(String name);
	
}