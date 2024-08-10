package br.pr.famapr.ApiBiblio.repository;

import br.pr.famapr.ApiBiblio.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    ArrayList<Cliente> findAll();
    Cliente save(Cliente cliente);
    Optional<Cliente> findById(Long id);
}
