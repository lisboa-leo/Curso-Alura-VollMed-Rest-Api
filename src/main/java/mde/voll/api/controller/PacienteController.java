package mde.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import mde.voll.api.paciente.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository pacienteRepository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroPaciente dadosCadastroPaciente){
        pacienteRepository.save(new Paciente(dadosCadastroPaciente));
    }

    @GetMapping
    public Page<DadosListagemPacientes> listar(@PageableDefault(page = 0, size = 10, sort = {"nome"}) Pageable paginacao){
        return pacienteRepository.findAllByAtivoTrue(paginacao).map(DadosListagemPacientes::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoPaciente dados) {
        var paciente = pacienteRepository.getReferenceById(dados.id());
        paciente.atualizarInformacoes(dados);
    }
    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id){
        var paciente = pacienteRepository.getReferenceById(id);
        paciente.excluir();
    }
}
