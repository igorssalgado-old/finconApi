package dev.fincon.finconApi.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.fincon.finconApi.entities.ExpenseModel;
import dev.fincon.finconApi.repositories.ExpenseRepository;

@Service
public class ExpenseService {

    @Autowired
    ExpenseRepository expenseRepository;

    public List<ExpenseModel> findAll() {
        return expenseRepository.findAll();
    }

    public ExpenseModel findById(UUID id) {
        return expenseRepository.findById(id).orElse(null);
    }

    public ExpenseModel createExpense(ExpenseModel expenseModel) {
        return expenseRepository.save(expenseModel);
    }

    public void delete() {

    }

    public ExpenseModel update() {
        return null;
    }
}
