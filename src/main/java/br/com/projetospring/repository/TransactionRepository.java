package br.com.projetospring.repository;

import br.com.projetospring.entity.Transaction;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    List<Transaction> findAllByEntityNameStartsWith(String entityName);

    List<Transaction> findAllByUserId(Integer userId);
}
