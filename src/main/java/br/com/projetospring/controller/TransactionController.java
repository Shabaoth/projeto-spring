package br.com.projetospring.controller;
import br.com.projetospring.dto.TransactionCreateUpdateDTO;
import br.com.projetospring.dto.TransactionDTO;
import br.com.projetospring.service.TransactionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Transaction")
@Api(tags = {"transactions"})
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get a single transaction.", notes = "You have to provide a valid post ID.")
    public TransactionDTO findById(@PathVariable Integer id) {
        return transactionService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Create a transaction resource.")
    public TransactionDTO createTransaction(@RequestBody TransactionCreateUpdateDTO transactionCreateUpdateDTO) {

        final TransactionDTO createTransaction = transactionService.create(transactionCreateUpdateDTO);
        return this.findById(createTransaction.getId());
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Update a transaction resource.", notes = "You have to provide a valid transaction ID in the URL and in the payload. The ID attribute can not be updated.")
    public TransactionDTO update(@PathVariable Integer id, @RequestBody TransactionCreateUpdateDTO transactionCreateUpdateDTO) {
        return transactionService.update(id, transactionCreateUpdateDTO);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Delete a transaction resource.", notes = "You have to provide a valid transaction ID in the URL. Once deleted the resource can not be recovered.")
    public void delete(@PathVariable Integer id) {
        transactionService.delete(id);
    }
}
