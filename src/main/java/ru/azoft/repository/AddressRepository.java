package ru.azoft.repository;


import org.springframework.data.repository.CrudRepository;
import ru.azoft.domain.Address;


public interface AddressRepository extends CrudRepository<Address, Integer> {

}
