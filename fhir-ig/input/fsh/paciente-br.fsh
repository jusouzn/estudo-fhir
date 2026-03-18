Profile: PacienteBR
Parent: Patient
Id: paciente-br
Title: "Paciente Brasileiro (com CPF)"
Description: "Perfil de paciente brasileiro, com extensão para CPF"

// Regras
//O paciente precisa ter no mínimo 1 (um) identificador e no máximo vários (*)
* identifier 1..* 
//O sistema desse identificador deve ser a URL oficial do CPF no Brasil
* identifier.system = "https://gov.br/cpf"
//O CPF é obrigatorio 1..1
* identifier.value 1..1
