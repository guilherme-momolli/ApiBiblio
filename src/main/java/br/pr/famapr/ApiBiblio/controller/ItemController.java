package br.pr.famapr.ApiBiblio.controller;


import br.pr.famapr.ApiBiblio.model.Fornecedor;
import br.pr.famapr.ApiBiblio.model.Item;
import br.pr.famapr.ApiBiblio.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<Item>> getAllItens(){
        return itemService.listItens();
    }

    @GetMapping("/list/{id}")
    public ResponseEntity<Item> getItemById(@PathVariable Long id){
        return itemService.getItemById(id);
    }

    @PostMapping("/create")
    public ResponseEntity<Item> createItem(@RequestBody Item item) {
        return itemService.createItem(item);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Item> updateItem(@PathVariable Long id, @RequestBody Item item) {
        return  itemService.updateItem(id, item);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Item> deleterItem(@PathVariable Long id){
        return itemService.deleteItem(id);
    }
}
