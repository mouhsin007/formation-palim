package com.zsmart.is.dao;
import com.zsmart.is.bean.ImpotSociete;
import com.zsmart.is.bean.IsFacture;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
 public interface IsFactureDao extends JpaRepository<IsFacture,Long> {


	 public IsFacture findByImpotSociete(ImpotSociete impotSociete);

	 public int deleteByImpotSociete(ImpotSociete impotSociete);

}
