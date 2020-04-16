package com.zsmart.is.dao;
import com.zsmart.is.bean.TauxIs;
import com.zsmart.is.bean.EtatIs;
import com.zsmart.is.bean.ImpotSociete;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
 public interface ImpotSocieteDao extends JpaRepository<ImpotSociete,Long> {
	 public ImpotSociete findByReference(String reference);

	 public int deleteByReference(String reference);

	 public ImpotSociete findByTauxIs(TauxIs tauxIs);
	 public ImpotSociete findByEtatIs(EtatIs etatIs);

	 public int deleteByTauxIs(TauxIs tauxIs);
	 public int deleteByEtatIs(EtatIs etatIs);

}
