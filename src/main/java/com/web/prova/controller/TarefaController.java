package com.web.prova.controller;


import com.web.prova.entity.Tarefa;
import com.web.prova.service.TarefaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/")
public class TarefaController {


    private final TarefaService tarefaService;

    public TarefaController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    @PostMapping("add")
    public ResponseEntity<?> criarTarefa(@RequestBody Tarefa tarefa){
        try{
            tarefa = tarefaService.criarTarefa(tarefa);
            return new ResponseEntity<>(tarefa, HttpStatus.CREATED);
        }catch (Exception exception){
            return new ResponseEntity(exception.getMessage(),
                    HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("all")
    public ResponseEntity<?> buscarTodasTarefas(){
        try {
            List<Tarefa> tarefas =
                    tarefaService.buscarTarefas();
            return new ResponseEntity(tarefas, HttpStatus.OK);
        } catch (Exception ex){
            return new ResponseEntity<>
                    ("Erro na requisição",
                            HttpStatus.BAD_GATEWAY);
        }
    }
    @GetMapping("{codigo}")
    public ResponseEntity<?> buscarTarefa(@PathVariable("codigo") Long codigo){
        try {
            Tarefa tarefa = tarefaService.buscarTarefa(codigo);
            return new ResponseEntity(tarefa, HttpStatus.OK);
        } catch (Exception ex){
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping("alterar/{codigo}")
    public ResponseEntity<?> alterarTarefa(@RequestBody Tarefa tarefa, @PathVariable("codigo") Long codigo){
        try{
            tarefa = tarefaService.atualizarTarefa(codigo, tarefa);
            return new ResponseEntity<>(tarefa, HttpStatus.CREATED);
        }catch (Exception exception){
            return new ResponseEntity(exception.getMessage(),
                    HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("remover/{codigo}")
    public ResponseEntity<?> removerPedido(@PathVariable("codigo") Long codigo){
        try {
            tarefaService.removerTarefa(codigo);
            return new ResponseEntity("Tarefa Removida com Sucesso", HttpStatus.OK);
        } catch (Exception ex){
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    @PatchMapping("alterarStatus/{codigo}")
    public ResponseEntity<?> alterarStatusTarefa(@RequestBody Tarefa tarefa, @PathVariable("codigo") Long codigo){
        try{
            tarefaService.atualizarStatus(codigo, tarefa);
            return new ResponseEntity<>("Status atualizado com sucesso", HttpStatus.OK);
        }catch (Exception exception){
            return new ResponseEntity(exception.getMessage(),
                    HttpStatus.BAD_REQUEST);
        }
    }
}