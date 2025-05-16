package com.aula.agendaTelefonica;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContatoRepository extends JpaRepository<ContatoEntity, Integer> {

    boolean existsByEmail(String email);

    boolean existsByIdAndEmail(Integer id, String email);

}
