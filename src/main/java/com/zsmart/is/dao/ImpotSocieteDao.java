package com.zsmart.is.dao;
import com.zsmart.is.bean.TauxIs;
import com.zsmart.is.bean.EtatIs;
import com.zsmart.is.bean.ImpotSociete;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
 public interface ImpotSocieteDao extends JpaRepository<ImpotSociete,Long> {
	public ImpotSociete findByReference(String reference);

	 public int deleteByReference(String reference);

	 public ImpotSociete findByEtatIsCode(String code);

	 public int deleteByTauxIsProfitMin(BigDecimal profitMin);
	 public int deleteByEtatIsCode(String code);
	 public ImpotSociete findByTauxIsProfitMin(BigDecimal profitMin);
	 
	 
	 

}
