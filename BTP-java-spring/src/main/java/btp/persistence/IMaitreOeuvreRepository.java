package btp.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import btp.model.MaitreOeuvre;

public interface IMaitreOeuvreRepository extends JpaRepository<MaitreOeuvre, Long>{

}
