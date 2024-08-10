package br.pr.famapr.ApiBiblio.service;

import br.pr.famapr.ApiBiblio.model.Item;
import br.pr.famapr.ApiBiblio.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository){this.itemRepository = itemRepository;}

    public ResponseEntity<List<Item>> listItens(){
        try {
            return new ResponseEntity<>(itemRepository.findAll(), HttpStatus.OK);
        }catch (Exception exception){
            System.out.println(exception.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Item> getItemById(Long id){
        try {
            return new ResponseEntity<>(itemRepository.findById(id).get(), HttpStatus.OK);
        }catch (Exception exception){
            System.out.println(exception.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Item> createItem(Item item){
        try {
            Item saveItem = itemRepository.save(item);
            return new ResponseEntity<>(saveItem, HttpStatus.CREATED);
        }catch (Exception exception){
            System.out.println(exception.getMessage());
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<Item> updateItem(Long id, Item item){
        try{
            Optional<Item> itemAtualizar = itemRepository.findById(id);
            Item itemParaAtualizar = itemAtualizar.get();
            itemParaAtualizar.setTitulo(item.getTitulo());
            itemParaAtualizar.setDataCompra(item.getDataCompra());
            Item update = itemRepository.save(itemParaAtualizar);
            return new ResponseEntity<>(update, HttpStatus.OK);
        }catch (Exception exception){
            System.out.println(exception.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Item> deleteItem(Long id){
        try{
            itemRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception exception){
            System.out.println(exception.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
