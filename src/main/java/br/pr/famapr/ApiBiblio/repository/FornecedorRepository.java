package br.pr.famapr.ApiBiblio.repository;

import br.pr.famapr.ApiBiblio.model.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.Optional;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {
    ArrayList<Fornecedor> findAll();
    Fornecedor save(Fornecedor fornecedor);
    Optional<Fornecedor> findById(Long id);
}
