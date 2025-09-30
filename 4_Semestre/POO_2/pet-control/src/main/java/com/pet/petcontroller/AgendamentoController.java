package com.pet.petcontroller;

import com.pet.petcontrol.Agendamento;
import com.pet.petcontrol.Pet;
import com.pet.petrepository.AgendamentoRepository;
import com.pet.petrepository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/agendamentos")

public class AgendamentoController {

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    @GetMapping
    public Iterable<Agendamento> getAgendamentos() {
        return agendamentoRepository.findAll();
    }

    @PostMapping
    public Agendamento criarAgendamento(@RequestBody Agendamento agendamento) {
        return agendamentoRepository.save(agendamento);
    }

    @PutMapping("/{id}")
    public Agendamento atualizarAgendamento(@PathVariable Long id, @RequestBody Agendamento agendamento) {
        agendamento.setId(id);
        return agendamentoRepository.save(agendamento);
    }

    @DeleteMapping("/{id}")
    public void deletarAgendamento(@PathVariable Long id) {
        agendamentoRepository.deleteById(id);
    }

}//AgendamentoController
