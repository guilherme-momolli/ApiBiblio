package br.pr.famapr.ApiBiblio.service;

import br.pr.famapr.ApiBiblio.model.Fornecedor;
import br.pr.famapr.ApiBiblio.repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class FornecedorService {

    @Autowired
    private FornecedorRepository fornecedorRepository;

    public FornecedorService(FornecedorRepository hardwareRepository){this.fornecedorRepository = hardwareRepository;}

    public ResponseEntity<List<Fornecedor>> listFornecedores(){
        try{
            return new ResponseEntity(fornecedorRepository.findAll(), HttpStatus.OK);
        }
        catch(Exception exception){
            System.out.println(exception.getMessage());
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
    public ResponseEntity<Fornecedor> getFornecedorById(Long id) {
        try {
            Optional<Fornecedor> hardware = fornecedorRepository.findById(id);
            return hardware.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    public ResponseEntity<Fornecedor> createFornecedor(@RequestBody Fornecedor fornecedor){
        try {
            Fornecedor saveFornecedor = fornecedorRepository.save(fornecedor);
            return new ResponseEntity<>(saveFornecedor, HttpStatus.CREATED);
        }catch (Exception exception){
            System.out.println(exception.getMessage());
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }


    public ResponseEntity<Fornecedor> updateFornecedor(@PathVariable Long id, @RequestBody Fornecedor fornecedor){
        try{
            Optional<Fornecedor> fornecedorAtualizar = fornecedorRepository.findById(id);
            Fornecedor fornecedorParaAtualizar = fornecedorAtualizar.get();
            fornecedorParaAtualizar.setNome(fornecedor.getNome());
            fornecedorParaAtualizar.setEndereco(fornecedor.getEndereco());
            fornecedorParaAtualizar.setComplemento(fornecedor.getComplemento());
            fornecedorParaAtualizar.setBairro(fornecedor.getBairro());
            fornecedorParaAtualizar.setCep(fornecedor.getCep());
            fornecedorParaAtualizar.setTelefone(fornecedor.getTelefone());
            fornecedorParaAtualizar.setDataCadastro(fornecedor.getDataCadastro());
            fornecedorParaAtualizar.setEmail(fornecedor.getEmail());
            fornecedorParaAtualizar.setCnpj(fornecedor.getCnpj());
            fornecedorParaAtualizar.setIe(fornecedor.getIe());
            Fornecedor update = fornecedorRepository.save(fornecedorParaAtualizar);
            return new ResponseEntity<>(update, HttpStatus.OK);
        }catch (Exception exception){
            System.out.println(exception.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Fornecedor> deleteFornecedor(@PathVariable Long id){
        try {
            fornecedorRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception exception){
            System.out.println(exception.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
