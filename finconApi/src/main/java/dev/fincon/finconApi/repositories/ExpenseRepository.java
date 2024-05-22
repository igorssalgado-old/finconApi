package dev.fincon.finconApi.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.fincon.finconApi.entities.ExpenseModel;

@Repository
public interface ExpenseRepository extends JpaRepository<ExpenseModel, UUID> {

}
