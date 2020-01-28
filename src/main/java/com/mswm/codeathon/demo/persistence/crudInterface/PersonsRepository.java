package com.mswm.codeathon.demo.persistence.crudInterface;

import com.mswm.codeathon.demo.persistence.entity.Persons;
import org.springframework.data.repository.CrudRepository;

public interface PersonsRepository extends CrudRepository<Persons, Integer> {
}
