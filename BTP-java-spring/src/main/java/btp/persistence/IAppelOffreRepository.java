package btp.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import btp.model.AppelOffre;

public interface IAppelOffreRepository extends JpaRepository<AppelOffre, Long> {

	
}
