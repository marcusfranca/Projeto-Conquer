package br.com.conquer.marcus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.conquer.marcus.model.User;

@Repository 
public interface IUserRepository extends JpaRepository<User, Long>{

}
