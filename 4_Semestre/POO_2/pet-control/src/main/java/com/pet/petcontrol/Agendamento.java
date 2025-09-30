package com.pet.petcontrol;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime dataHora;
    private String servico;
    private String observacoes;

    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;
}//Agendamento
