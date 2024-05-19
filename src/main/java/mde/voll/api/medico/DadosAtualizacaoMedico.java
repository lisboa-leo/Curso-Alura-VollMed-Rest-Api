package mde.voll.api.medico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import mde.voll.api.endereco.DadosEndereco;
import mde.voll.api.endereco.Endereco;

public record DadosAtualizacaoMedico(
        @NotNull Long id,
        String telefone,
        String email,
        DadosEndereco endereco) {

}
