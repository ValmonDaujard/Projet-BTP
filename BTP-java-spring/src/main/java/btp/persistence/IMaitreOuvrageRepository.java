package btp.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import btp.model.MaitreOuvrage;

public interface IMaitreOuvrageRepository extends JpaRepository<MaitreOuvrage, Long>{

}
