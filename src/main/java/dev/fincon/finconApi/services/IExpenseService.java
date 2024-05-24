package dev.fincon.finconApi.services;

import java.util.List;

import dev.fincon.finconApi.entities.ExpenseModel;

public interface IExpenseService {

    public List<ExpenseModel> findAll();

    public ExpenseModel findById();

    public ExpenseModel createExpense();

    public void delete();

    public ExpenseModel update();
}
