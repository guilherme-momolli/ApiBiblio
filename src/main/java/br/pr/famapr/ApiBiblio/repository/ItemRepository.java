package br.pr.famapr.ApiBiblio.repository;

import br.pr.famapr.ApiBiblio.model.Cliente;
import br.pr.famapr.ApiBiblio.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.Optional;

public interface ItemRepository extends JpaRepository<Item, Long> {
    ArrayList<Item> findAll();
    Item save(Cliente cliente);
    Optional<Item> findById(Long id);

}
