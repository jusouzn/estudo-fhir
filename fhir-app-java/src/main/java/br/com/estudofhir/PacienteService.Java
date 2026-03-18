package br.com.estudofhir;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.rest.client.api.IGenericClient;
import org.hl7.fhir.r4.model.Patient;
import org.hl7.fhir.r4.model.Identifier;
import org.springframework.stereotype.Service;

@Service
public class PacienteService {

    public String cadastrarPaciente(String nome, String cpf) {
        // 1. Inicializa o contexto FHIR R4
        FhirContext ctx = FhirContext.forR4();

        // 2. Cria o cliente para falar com o seu servidor Docker
        IGenericClient client = ctx.newRestfulGenericClient("http://localhost:8080/fhir");

        // 3. Cria o objeto Paciente (R4)
        Patient paciente = new Patient();
        paciente.addName().addGiven(nome);

        // 4. Adiciona o CPF (Identificador)
        // No seu IG, você definiu que o sistema do CPF é algo como http://estudofhir.com.br/sid/cpf
        Identifier id = new Identifier();
        id.setSystem("http://estudofhir.com.br/sid/cpf");
        id.setValue(cpf);
        paciente.addIdentifier(id);

        // 5. Envia para o servidor HAPI FHIR (que salva no Postgres)
        client.create().resource(paciente).execute();

        return "Paciente " + nome + " enviado com sucesso para o HAPI FHIR!";
    }
}