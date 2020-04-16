package com.zsmart.is.service.facade;

import java.util.ArrayList;
import java.util.List;
import java.util.Date; 
import java.math.BigDecimal; 
import com.zsmart.is.bean.EtatIs;
public interface EtatIsService {

public EtatIs save(EtatIs etatis); 
public List<EtatIs>  findAll();
public EtatIs findById(Long id);
public int delete(EtatIs etatis);
public void  deleteById(Long id);
public void clone(EtatIs etatis,EtatIs etatisClone);
public EtatIs clone(EtatIs etatis);
public List<EtatIs> clone(List<EtatIs>etatiss);
 public List<EtatIs>  findByCriteria(String libelle,String code,Long idMin,Long idMax);

}
