package com.pet.petcontroller;

import com.pet.petcontrol.Pet;
import com.pet.petrepository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pets")
public class PetController {

    @Autowired
    private PetRepository petRepository;

    @GetMapping
    public Iterable<Pet> getPets() {
        return petRepository.findAll();
    }

    @PostMapping
    public Pet criarPet(@RequestBody Pet animal) {
        return petRepository.save(animal);
    }

    @PutMapping("/{id}")
    public Pet atualizarPet(@PathVariable Long id, @RequestBody Pet pet) {
        pet.setId(id);
        return petRepository.save(pet);
    }

    @DeleteMapping("/{id}")
    public void deletarPet(@PathVariable Long id) {
        petRepository.deleteById(id);
    }
}//PetController
