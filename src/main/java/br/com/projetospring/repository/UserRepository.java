package br.com.projetospring.repository;

import br.com.projetospring.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findAllByNomeStartsWith(String name);

    @Query("from User m where m.name like :name%")
    List<User> buscarPorNome(String nome);
}
