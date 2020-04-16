package com.zsmart.is.dao;
import com.zsmart.is.bean.Facture;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
 public interface FactureDao extends JpaRepository<Facture,Long> {
	 public Facture findByReference(String reference);

	 public int deleteByReference(String reference);



}
