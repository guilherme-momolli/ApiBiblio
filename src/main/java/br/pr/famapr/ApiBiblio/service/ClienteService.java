package br.pr.famapr.ApiBiblio.service;

import br.pr.famapr.ApiBiblio.model.Cliente;
import br.pr.famapr.ApiBiblio.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public ResponseEntity<List<Cliente>> listClientes(){
        try{
            return new ResponseEntity(clienteRepository.findAll(), HttpStatus.OK);
        }
        catch(Exception exception){
            System.out.println(exception.getMessage());
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<Cliente> getClienteById(Long id){
        try{
            Optional<Cliente> cliente = clienteRepository.findById(id);
            return cliente.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        }
        catch(Exception exception){
            System.out.println(exception.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Cliente> createCliente(Cliente cliente){
        try{
            Cliente saveCliente = clienteRepository.save(cliente);
            return new ResponseEntity<>(saveCliente, HttpStatus.CREATED);
        }
        catch(Exception exception){
            System.out.println(exception.getMessage());
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<Cliente> updateCliente(Long id, Cliente cliente){
        try {
            Optional<Cliente> clienteAtualizar = clienteRepository.findById(id);
            Cliente clienteParaAtualizar = clienteAtualizar.get();
            clienteParaAtualizar.setNome(cliente.getNome());
            clienteParaAtualizar.setEndereco(cliente.getEndereco());
            clienteParaAtualizar.setComplemento(cliente.getComplemento());
            clienteParaAtualizar.setBairro(cliente.getBairro());
            clienteParaAtualizar.setCep(cliente.getCep());
            clienteParaAtualizar.setTelefone(cliente.getTelefone());
            clienteParaAtualizar.setDataCadastro(cliente.getDataCadastro());
            clienteParaAtualizar.setEmail(cliente.getEmail());
            clienteParaAtualizar.setCpf(cliente.getCpf());
            clienteParaAtualizar.setRg(cliente.getRg());
            clienteParaAtualizar.setDataNascimento(cliente.getDataNascimento());
            clienteParaAtualizar.setIdade(cliente.getIdade());
            clienteParaAtualizar.setLimiteCredito(cliente.getLimiteCredito());
            clienteParaAtualizar.setSaldo(cliente.getSaldo());
            clienteParaAtualizar.setAtivo(cliente.isAtivo());
            Cliente update = clienteRepository.save(clienteParaAtualizar);
            return new ResponseEntity<>(update, HttpStatus.OK);
        }
        catch(Exception exception){
            System.out.println(exception.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Cliente> deleteCliente(Long id){
        try{
            clienteRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        catch(Exception exception){
            System.out.println(exception.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
