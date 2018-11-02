package ru.azoft.repository;

import org.springframework.data.repository.CrudRepository;
import ru.azoft.domain.User;


public interface UserRepository extends CrudRepository<User, Integer> {


}
