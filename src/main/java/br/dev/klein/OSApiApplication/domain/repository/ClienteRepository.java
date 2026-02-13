/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.dev.klein.OSApiApplication.domain.repository;

import br.dev.klein.OSApiApplication.domain.model.Cliente;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    List<Cliente> findByNome(String nome);
    List<Cliente> findByNomeContaining(String nome);
}
