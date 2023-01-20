package ru.gb.spring_security2.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.gb.spring_security2.model.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
}
