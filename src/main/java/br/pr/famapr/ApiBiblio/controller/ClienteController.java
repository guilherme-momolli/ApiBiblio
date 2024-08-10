package br.pr.famapr.ApiBiblio.controller;

import br.pr.famapr.ApiBiblio.model.Cliente;
import br.pr.famapr.ApiBiblio.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/cliente")
public class ClienteController {

    private ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<Cliente>> getAllClientes(){
        return clienteService.listClientes();
    }

    @GetMapping("/list/{id}")
    public ResponseEntity<Cliente> getClienteById(@PathVariable Long id){
        return clienteService.getClienteById(id);
    }

    @PostMapping("/create")
    public ResponseEntity<Cliente> criarFornecedor(@RequestBody Cliente cliente) {
        return clienteService.createCliente(cliente);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Cliente> updateFornecedor(@PathVariable Long id, @RequestBody Cliente cliente) {
        return clienteService.updateCliente(id, cliente);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Cliente> deleteCliente(@PathVariable Long id){
        return clienteService.deleteCliente(id);
    }

}
