package com.zsmart.is.dao;
import com.zsmart.is.bean.Facture;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
 public interface FactureDao extends JpaRepository<Facture,Long> {
	 public Facture findByReference(String reference);

	 public int deleteByReference(String reference);
	 public List<Facture> findByAnneeAndTypeFacture( Integer annee,String typeFacture);
	


}
