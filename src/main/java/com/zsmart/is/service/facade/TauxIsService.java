package com.zsmart.is.service.facade;

import java.util.ArrayList;
import java.util.List;
import java.util.Date; 
import java.math.BigDecimal; 
import com.zsmart.is.bean.TauxIs;
public interface TauxIsService {

public TauxIs save(TauxIs tauxis); 
public List<TauxIs>  findAll();
public TauxIs findById(Long id);
public int delete(TauxIs tauxis);
public void  deleteById(Long id);
public void clone(TauxIs tauxis,TauxIs tauxisClone);
public TauxIs clone(TauxIs tauxis);
public List<TauxIs> clone(List<TauxIs>tauxiss);
 public List<TauxIs>  findByCriteria(Long idMin,Long idMax,BigDecimal profitMinMin,BigDecimal profitMinMax,BigDecimal profitMaxMin,BigDecimal profitMaxMax,BigDecimal percentageMin,BigDecimal percentageMax,BigDecimal majorationMin,BigDecimal majorationMax,BigDecimal penaliteMin,BigDecimal penaliteMax,Date dateApplicationDebutMin,Date dateApplicationDebutMax,Date dateApplicationFinMin,Date dateApplicationFinMax);

}
