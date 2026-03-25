
package br.dev.klein.OSApiApplication.domain.repository;

import br.dev.klein.OSApiApplication.domain.model.OrdemServico;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrdemServicoRepository extends JpaRepository<OrdemServico, Long>{
    
}
