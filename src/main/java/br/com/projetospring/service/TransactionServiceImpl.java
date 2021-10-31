package br.com.projetospring.service;

import br.com.projetospring.dto.TransactionCreateUpdateDTO;
import br.com.projetospring.dto.TransactionDTO;
import br.com.projetospring.entity.Transaction;
import br.com.projetospring.entity.User;
import br.com.projetospring.repository.TransactionRepository;
import br.com.projetospring.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Slf4j
@Component("transactionService")
public class TransactionServiceImpl implements TransactionService {
    private final TransactionRepository transactionRepository;
    private final UserRepository userRepository;
    

    public TransactionServiceImpl(
            TransactionRepository transactionRepository, UserRepository userRepository
    ) {
        this.transactionRepository = transactionRepository;
        this.userRepository = userRepository;
    }

    @Override
    public TransactionDTO findById(Integer id) {
        Transaction transaction = getTransactionById(id);
        return new TransactionDTO(transaction);
    }

    @Override
    public TransactionDTO create(TransactionCreateUpdateDTO transactionCreateUpdateDTO) {

        User user = userRepository.findById(transactionCreateUpdateDTO.getUserId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "user.not.found"));

        Transaction transaction = new Transaction(transactionCreateUpdateDTO, user);

        Transaction transactionSaved = transactionRepository.save(transaction);
        return new TransactionDTO(transactionSaved);
    }

    @Override
    public TransactionDTO update(Integer id, TransactionCreateUpdateDTO transactionCreateUpdateDTO) {
        Transaction transaction = getTransactionById(id);

        User user = userRepository.getById(transactionCreateUpdateDTO.getUserId());

        transaction.setEntityName(transactionCreateUpdateDTO.getEntityName());
        transaction.setUser(user);
        transaction.setValue(transactionCreateUpdateDTO.getValue());

        Transaction transactionSaved = transactionRepository.save(transaction);
        return new TransactionDTO(transactionSaved);
    }

    @Override
    public void delete(Integer id) {
        getTransactionById(id);
        transactionRepository.deleteById(id);
    }

    private Transaction getTransactionById(Integer id) {
        return transactionRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "transaction.not.found"));
    }
}
