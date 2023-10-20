package com.web.prova.service;

import com.web.prova.entity.Tarefa;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class TarefaService {


    private List<Tarefa> tarefas;

    public TarefaService() {
        this.tarefas = new ArrayList<>();
    }


    public Tarefa criarTarefa(Tarefa tarefa) {
        tarefas.add(tarefa);
        return tarefa;
    }

    public List<Tarefa> buscarTarefas(){
        return tarefas;
    }

    public Tarefa buscarTarefa(Long codigo) throws Exception {
        Optional<Tarefa> tarefaOptional = tarefas.stream().filter
                (e -> e.getCodigo().equals(codigo)).findFirst();
        if(tarefaOptional.isPresent()){
            return tarefaOptional.get();
        } else {
            throw new Exception("Tarefa não encontrada!");
        }
    }

    public Tarefa atualizarTarefa(Long codigo, Tarefa tarefa) throws Exception {
        Optional<Tarefa> tarefaOptional = tarefas.stream().filter
                (e -> e.getCodigo().equals(codigo)).findFirst();
        if(tarefaOptional.isPresent()){
            tarefaOptional.get().setStatus(tarefa.getStatus());
            tarefaOptional.get().setNome(tarefa.getNome());
            return tarefaOptional.get();
        } else {
            throw new Exception("Tarefa não encontrada!");
        }
    }
    public void removerTarefa(Long codigo) {
        tarefas.removeIf(tarefa -> tarefa.getCodigo() .equals(codigo));
    }

    public Tarefa atualizarStatus(Long codigo, Tarefa tarefa) throws Exception {
        Optional<Tarefa> tarefaOptional = tarefas.stream().filter
                (e -> e.getCodigo().equals(codigo)).findFirst();
        if(tarefaOptional.isPresent()){
            Tarefa tarfaAtualizada = tarefaOptional.get();
            tarfaAtualizada.setStatus(tarefa.getStatus());
            return tarfaAtualizada;
        } else {
            throw new Exception("Tarefa não encontrada!");
        }
    }

}
