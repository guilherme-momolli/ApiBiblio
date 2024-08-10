package br.pr.famapr.ApiBiblio.controller;

import br.pr.famapr.ApiBiblio.model.Fornecedor;
import br.pr.famapr.ApiBiblio.service.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/fornecedor")
public class FornecedorController {

    private FornecedorService fornecedorService;

    @Autowired
    public FornecedorController(FornecedorService fornecedorService) {
        this.fornecedorService = fornecedorService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<Fornecedor>> getAllFornecedores(){
        return fornecedorService.listFornecedores();
    }

    @GetMapping("/list/{id}")
    public ResponseEntity<Fornecedor> getFornecedorById(@PathVariable Long id){
        return fornecedorService.getFornecedorById(id);
    }

    @PostMapping("/create")
    public ResponseEntity<Fornecedor> criarFornecedor(@RequestBody Fornecedor fornecedor) {
        return fornecedorService.createFornecedor(fornecedor);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Fornecedor> updateFornecedor(@PathVariable Long id, @RequestBody Fornecedor fornecedro) {
        return  fornecedorService.updateFornecedor(id, fornecedro);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Fornecedor> deleteFornecedor(@PathVariable Long id){
        return fornecedorService.deleteFornecedor(id);
    }

}
