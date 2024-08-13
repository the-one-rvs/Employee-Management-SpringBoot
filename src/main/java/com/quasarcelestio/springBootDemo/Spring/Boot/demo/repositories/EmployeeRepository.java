package com.quasarcelestio.springBootDemo.Spring.Boot.demo.repositories;

import com.quasarcelestio.springBootDemo.Spring.Boot.demo.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
    EmployeeEntity getById(Long id);
}
// hql is also here