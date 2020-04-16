package com.zsmart.is.service.facade;

import java.util.ArrayList;
import java.util.List;
import java.util.Date; 
import java.math.BigDecimal; 
import com.zsmart.is.bean.ImpotSociete;
import com.zsmart.is.bean.TauxIs; 
import com.zsmart.is.bean.EtatIs; 
public interface ImpotSocieteService {

public ImpotSociete save(ImpotSociete impotsociete); 
public ImpotSociete  saveWithIsFactures (ImpotSociete impotsociete);public List<ImpotSociete>  findAll();
public ImpotSociete findById(Long id);
public ImpotSociete  findByReference(String  reference);
public int delete(ImpotSociete impotsociete);
public void  deleteById(Long id);
public void  deleteByReference(String  reference);
public void clone(ImpotSociete impotsociete,ImpotSociete impotsocieteClone);
public ImpotSociete clone(ImpotSociete impotsociete);
public List<ImpotSociete> clone(List<ImpotSociete>impotsocietes);
 public List<ImpotSociete>  findByCriteria(String description,String reference,String referenceComptableValidateur,String referenceComptableCreateur,Long idMin,Long idMax,BigDecimal totalChargeMin,BigDecimal totalChargeMax,BigDecimal totalGainMin,BigDecimal totalGainMax,BigDecimal profitMin,BigDecimal profitMax,BigDecimal montantTotalMin,BigDecimal montantTotalMax,BigDecimal montantBaseIsMin,BigDecimal montantBaseIsMax,BigDecimal montantRetardMin,BigDecimal montantRetardMax,BigDecimal montantMajorationMin,BigDecimal montantMajorationMax,BigDecimal montantPenaliteMin,BigDecimal montantPenaliteMax,Integer nomberMoisRetardMin,Integer nomberMoisRetardMax,Integer anneMin,Integer anneMax,Integer moisMin,Integer moisMax,BigDecimal honoraireMin,BigDecimal honoraireMax,BigDecimal penaliteMin,BigDecimal penaliteMax,BigDecimal majorationMin,BigDecimal majorationMax,Date dateValidationMin,Date dateValidationMax,Date dateSoumissionMin,Date dateSoumissionMax,Date dateAffectationComptableMin,Date dateAffectationComptableMax,Date dateFinalisationMin,Date dateFinalisationMax,Date dateSaisieMin,Date dateSaisieMax);

}
