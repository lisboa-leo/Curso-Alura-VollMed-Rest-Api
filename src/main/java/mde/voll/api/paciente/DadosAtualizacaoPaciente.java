package mde.voll.api.paciente;

import jakarta.validation.constraints.NotNull;
import mde.voll.api.endereco.DadosEndereco;

public record DadosAtualizacaoPaciente(
        @NotNull Long id,
        String telefone,
        String email,
        DadosEndereco endereco
) {
}
