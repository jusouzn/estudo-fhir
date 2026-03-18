package br.com.estudofhir;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.rest.client.api.IGenericClient;
import org.hl7.fhir.r4.model.Bundle;
import org.hl7.fhir.r4.model.Patient;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PacienteService {

    private final IGenericClient client;

    public PacienteService() {
        FhirContext ctx = FhirContext.forR4();
        this.client = ctx.newRestfulGenericClient("http://localhost:8080/fhir");
    }

    public String cadastrarPaciente(String nome, String cpf) {
        try {
            Patient paciente = new Patient();
            // Vincula ao seu Perfil do IG
            paciente.getMeta().addProfile("http://estudofhir.com.br/StructureDefinition/paciente-br");
            
            paciente.addName().addGiven(nome);
            paciente.addIdentifier().setSystem("https://gov.br/cpf").setValue(cpf);

            client.create().resource(paciente).execute();
            return "Paciente " + nome + " cadastrado com sucesso!";
        } catch (Exception e) {
            return "Erro ao cadastrar: " + e.getMessage();
        }
    }

    public List<Patient> buscarTodos() {
        // Faz a busca (Search) por todos os pacientes
        Bundle bundle = client.search()
                .forResource(Patient.class)
                .returnBundle(Bundle.class)
                .execute();

        // Converte os resultados do Bundle para uma lista simples de Patient
        return bundle.getEntry().stream()
                .map(entry -> (Patient) entry.getResource())
                .collect(Collectors.toList());
    }
}