package com.inkaa.crud.inkaa.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.inkaa.crud.inkaa.entity.User;

// Repository package is a link between the application and database
@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}
