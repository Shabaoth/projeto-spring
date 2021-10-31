package br.com.projetospring.service;

import br.com.projetospring.dto.TransactionCreateUpdateDTO;
import br.com.projetospring.dto.TransactionDTO;

public interface TransactionService {
    TransactionDTO findById(Integer id);
    TransactionDTO create(TransactionCreateUpdateDTO userCreateUpdateDTO);
    TransactionDTO update(Integer id, TransactionCreateUpdateDTO userCreateUpdateDTO);
    void delete(Integer id);
}
