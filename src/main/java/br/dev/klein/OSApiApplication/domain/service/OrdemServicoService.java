package br.dev.klein.OSApiApplication.domain.service;

import br.dev.klein.OSApiApplication.domain.dto.AtualizaStatusDTO;
import br.dev.klein.OSApiApplication.domain.exception.DomainException;
import br.dev.klein.OSApiApplication.domain.model.OrdemServico;
import br.dev.klein.OSApiApplication.domain.model.StatusOrdemServico;
import br.dev.klein.OSApiApplication.domain.repository.OrdemServicoRepository;
import jakarta.validation.Valid;
import java.time.LocalDateTime;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class OrdemServicoService {

    @Autowired
    private OrdemServicoRepository ordemServicoRepository;

    public OrdemServico criar(OrdemServico ordemServico) {
        ordemServico.setStatus(StatusOrdemServico.ABERTA);
        ordemServico.setDataAbertura(LocalDateTime.now());

        return ordemServicoRepository.save(ordemServico);
    }

    public OrdemServico salvar(OrdemServico os) {
        return ordemServicoRepository.save(os);
    }

    public void apagar(Long id) {
        ordemServicoRepository.deleteById(id);
    }

    public Optional<OrdemServico> atualizaStatus(Long ordemServicoID, StatusOrdemServico status) {
        Optional<OrdemServico> optOrdemServico = ordemServicoRepository.findById(ordemServicoID);

        if (optOrdemServico.isPresent()) {
            OrdemServico ordemServico = optOrdemServico.get();

            if (ordemServico.getStatus() == StatusOrdemServico.ABERTA
                    && status != StatusOrdemServico.ABERTA) {
                ordemServico.setStatus(status);
                ordemServico.setDataFinalizacao(LocalDateTime.now());
                ordemServicoRepository.save(ordemServico);
                return Optional.of(ordemServico);
            } else {
                return Optional.empty();
            }
        } else {
            throw new DomainException("Não existe OS com o id" + ordemServicoID);

        }
    }

   
}
