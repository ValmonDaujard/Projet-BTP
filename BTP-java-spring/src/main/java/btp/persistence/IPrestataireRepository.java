package btp.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import btp.model.Prestataire;

public interface IPrestataireRepository extends JpaRepository<Prestataire, Long>{

}
