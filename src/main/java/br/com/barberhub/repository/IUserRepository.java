package br.com.barberhub.repository;

import br.com.barberhub.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface IUserRepository extends JpaRepository<User, Long> {

    List<User> findByName(String name);

    Optional<User> findByEmail(String email);

    List<User> findByNameContainingIgnoreCase(String name);


}
