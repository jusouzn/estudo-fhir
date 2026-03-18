package br.com.estudofhir;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PacienteController {

    private final PacienteService service;

    public PacienteController(PacienteService service) {
        this.service = service;
    }

    @GetMapping("/testar")
    public String testar(@RequestParam String nome, @RequestParam String cpf) {
        return service.cadastrarPaciente(nome, cpf);
    }
}