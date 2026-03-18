package br.com.estudofhir;
import org.hl7.fhir.r4.model.Patient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller 
public class PacienteController {

    private final PacienteService service;

    public PacienteController(PacienteService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/cadastrar")
    public String cadastrar(@RequestParam String nome, @RequestParam String cpf, Model model) {
        String resultado = service.cadastrarPaciente(nome, cpf);
        model.addAttribute("mensagem", resultado);
        return "index";
    }
    @GetMapping("/listar")
    public String listar(Model model) {
        // Busca todos os pacientes no HAPI
        java.util.List<Patient> pacientes = service.buscarTodos(); 
        model.addAttribute("pacientes", pacientes);
        return "lista";
    }
}