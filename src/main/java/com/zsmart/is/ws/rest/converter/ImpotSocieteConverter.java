package com.zsmart.is.ws.rest.converter;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.zsmart.is.service.util.*;
import com.zsmart.is.bean.ImpotSociete; 
import com.zsmart.is.ws.rest.vo.ImpotSocieteVo; 

 @Component 
public class ImpotSocieteConverter extends AbstractConverter<ImpotSociete,ImpotSocieteVo>{ 

private boolean tauxIs; 

 @Autowired
 private TauxIsConverter tauxIsConverter ; 
private boolean etatIs; 

 @Autowired
 private EtatIsConverter etatIsConverter ; 
private boolean isFactures; 

 @Autowired
 private IsFactureConverter isFactureConverter ; 

 @Override 
 public ImpotSociete toItem(ImpotSocieteVo vo) {
 if (vo == null) {
    return null;
      } else {
ImpotSociete item = new ImpotSociete();

 if(tauxIs&& vo.getTauxIsVo() != null) {
 item.setTauxIs(tauxIsConverter.toItem(vo.getTauxIsVo()));
} 
 
 if(etatIs&& vo.getEtatIsVo() != null) {
 item.setEtatIs(etatIsConverter.toItem(vo.getEtatIsVo()));
} 
 
 if (StringUtil.isNotEmpty(vo.getDescription())) {
 item.setDescription(vo.getDescription());
} 

 if (StringUtil.isNotEmpty(vo.getReference())) {
 item.setReference(vo.getReference());
} 

 if (StringUtil.isNotEmpty(vo.getReferenceComptableValidateur())) {
 item.setReferenceComptableValidateur(vo.getReferenceComptableValidateur());
} 

 if (StringUtil.isNotEmpty(vo.getReferenceComptableCreateur())) {
 item.setReferenceComptableCreateur(vo.getReferenceComptableCreateur());
} 

 if (vo.getId() != null) {
 item.setId(NumberUtil.toLong(vo.getId()));
} 

 if (vo.getTotalCharge() != null) {
 item.setTotalCharge(NumberUtil.toBigDecimal(vo.getTotalCharge()));
} 

 if (vo.getTotalGain() != null) {
 item.setTotalGain(NumberUtil.toBigDecimal(vo.getTotalGain()));
} 

 if (vo.getProfit() != null) {
 item.setProfit(NumberUtil.toBigDecimal(vo.getProfit()));
} 

 if (vo.getMontantTotal() != null) {
 item.setMontantTotal(NumberUtil.toBigDecimal(vo.getMontantTotal()));
} 

 if (vo.getMontantBaseIs() != null) {
 item.setMontantBaseIs(NumberUtil.toBigDecimal(vo.getMontantBaseIs()));
} 

 if (vo.getMontantRetard() != null) {
 item.setMontantRetard(NumberUtil.toBigDecimal(vo.getMontantRetard()));
} 

 if (vo.getMontantMajoration() != null) {
 item.setMontantMajoration(NumberUtil.toBigDecimal(vo.getMontantMajoration()));
} 

 if (vo.getMontantPenalite() != null) {
 item.setMontantPenalite(NumberUtil.toBigDecimal(vo.getMontantPenalite()));
} 

 if (vo.getNomberMoisRetard() != null) {
 item.setNomberMoisRetard(NumberUtil.toInt(vo.getNomberMoisRetard()));
} 

 if (vo.getAnne() != null) {
 item.setAnne(NumberUtil.toInt(vo.getAnne()));
} 

 if (vo.getMois() != null) {
 item.setMois(NumberUtil.toInt(vo.getMois()));
} 

 if (vo.getHonoraire() != null) {
 item.setHonoraire(NumberUtil.toBigDecimal(vo.getHonoraire()));
} 

 if (vo.getPenalite() != null) {
 item.setPenalite(NumberUtil.toBigDecimal(vo.getPenalite()));
} 

 if (vo.getMajoration() != null) {
 item.setMajoration(NumberUtil.toBigDecimal(vo.getMajoration()));
} 

 if (vo.getDateValidation() != null) {
 item.setDateValidation(DateUtil.parse(vo.getDateValidation()));
} 

 if (vo.getDateSoumission() != null) {
 item.setDateSoumission(DateUtil.parse(vo.getDateSoumission()));
} 

 if (vo.getDateAffectationComptable() != null) {
 item.setDateAffectationComptable(DateUtil.parse(vo.getDateAffectationComptable()));
} 

 if (vo.getDateFinalisation() != null) {
 item.setDateFinalisation(DateUtil.parse(vo.getDateFinalisation()));
} 

 if (vo.getDateSaisie() != null) {
 item.setDateSaisie(DateUtil.parse(vo.getDateSaisie()));
} 

 if (ListUtil.isNotEmpty(vo.getIsFacturesVo ()) && isFactures) {
 item.setIsFactures(isFactureConverter.toItem(vo.getIsFacturesVo())); 
} 

return item;
 }
 }

  @Override 
 public ImpotSocieteVo toVo(ImpotSociete item) {
 if (item == null) {
    return null;
      } else {
ImpotSocieteVo vo = new ImpotSocieteVo();

 if(tauxIs&& item.getTauxIs() != null) {
 vo.setTauxIsVo(tauxIsConverter.toVo(item.getTauxIs()));
} 
 
 if(etatIs&& item.getEtatIs() != null) {
 vo.setEtatIsVo(etatIsConverter.toVo(item.getEtatIs()));
} 
 
 if (StringUtil.isNotEmpty(item.getDescription())) {
 vo.setDescription(item.getDescription());
} 

 if (StringUtil.isNotEmpty(item.getReference())) {
 vo.setReference(item.getReference());
} 

 if (StringUtil.isNotEmpty(item.getReferenceComptableValidateur())) {
 vo.setReferenceComptableValidateur(item.getReferenceComptableValidateur());
} 

 if (StringUtil.isNotEmpty(item.getReferenceComptableCreateur())) {
 vo.setReferenceComptableCreateur(item.getReferenceComptableCreateur());
} 

 if (item.getId() != null) {
 vo.setId(NumberUtil.toString(item.getId()));
} 

 if (item.getTotalCharge() != null) {
 vo.setTotalCharge(NumberUtil.toString(item.getTotalCharge()));
} 

 if (item.getTotalGain() != null) {
 vo.setTotalGain(NumberUtil.toString(item.getTotalGain()));
} 

 if (item.getProfit() != null) {
 vo.setProfit(NumberUtil.toString(item.getProfit()));
} 

 if (item.getMontantTotal() != null) {
 vo.setMontantTotal(NumberUtil.toString(item.getMontantTotal()));
} 

 if (item.getMontantBaseIs() != null) {
 vo.setMontantBaseIs(NumberUtil.toString(item.getMontantBaseIs()));
} 

 if (item.getMontantRetard() != null) {
 vo.setMontantRetard(NumberUtil.toString(item.getMontantRetard()));
} 

 if (item.getMontantMajoration() != null) {
 vo.setMontantMajoration(NumberUtil.toString(item.getMontantMajoration()));
} 

 if (item.getMontantPenalite() != null) {
 vo.setMontantPenalite(NumberUtil.toString(item.getMontantPenalite()));
} 

 if (item.getNomberMoisRetard() != null) {
 vo.setNomberMoisRetard(NumberUtil.toString(item.getNomberMoisRetard()));
} 

 if (item.getAnne() != null) {
 vo.setAnne(NumberUtil.toString(item.getAnne()));
} 

 if (item.getMois() != null) {
 vo.setMois(NumberUtil.toString(item.getMois()));
} 

 if (item.getHonoraire() != null) {
 vo.setHonoraire(NumberUtil.toString(item.getHonoraire()));
} 

 if (item.getPenalite() != null) {
 vo.setPenalite(NumberUtil.toString(item.getPenalite()));
} 

 if (item.getMajoration() != null) {
 vo.setMajoration(NumberUtil.toString(item.getMajoration()));
} 

 if (item.getDateValidation() != null) {
 vo.setDateValidation(DateUtil.formateDate(item.getDateValidation()));
} 

 if (item.getDateSoumission() != null) {
 vo.setDateSoumission(DateUtil.formateDate(item.getDateSoumission()));
} 

 if (item.getDateAffectationComptable() != null) {
 vo.setDateAffectationComptable(DateUtil.formateDate(item.getDateAffectationComptable()));
} 

 if (item.getDateFinalisation() != null) {
 vo.setDateFinalisation(DateUtil.formateDate(item.getDateFinalisation()));
} 

 if (item.getDateSaisie() != null) {
 vo.setDateSaisie(DateUtil.formateDate(item.getDateSaisie()));
} 

 if(ListUtil.isNotEmpty(item.getIsFactures()) && isFactures) {
 vo.setIsFacturesVo(isFactureConverter.toVo(item.getIsFactures()));
} 

return vo;
 }
 }
public void init() { 

tauxIs = true; 

etatIs = true; 

isFactures = true; 
}
 } 
