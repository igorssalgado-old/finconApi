package dev.fincon.finconApi.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import dev.fincon.finconApi.entities.ExpenseModel;
import dev.fincon.finconApi.services.ExpenseService;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/expense")
public class ExpenseController {

    @Autowired
    ExpenseService expenseService;

    @GetMapping
    public ResponseEntity<List<ExpenseModel>> findAll() throws Exception {

        var productList = expenseService.findAll();

        for (ExpenseModel item : productList) {
            UUID id = item.getId();

            item.add(linkTo(methodOn(ExpenseController.class).findById(id)).withSelfRel());
        }

        return ResponseEntity.ok(productList);
    }

    @GetMapping("{id}")
    public ResponseEntity<ExpenseModel> findById(@PathVariable(name = "id") UUID id) throws Exception {

        ExpenseModel foundIt = expenseService.findById(id);

        if (foundIt == null) {
            System.out.println("falhou");
        }

        foundIt.add(linkTo(methodOn(ExpenseController.class).findById(id)).withRel("Producting Listing:"));
        return ResponseEntity.status(HttpStatus.OK).body(foundIt);
    }

    @PostMapping
    public ResponseEntity<ExpenseModel> createExpense(@RequestBody ExpenseModel expenseModel) {
        return ResponseEntity.status(HttpStatus.OK).body(expenseService.createExpense(expenseModel));
    }
}
