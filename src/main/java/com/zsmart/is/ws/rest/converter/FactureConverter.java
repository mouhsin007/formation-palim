package com.zsmart.is.ws.rest.converter;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.zsmart.is.service.util.*;
import com.zsmart.is.bean.Facture; 
import com.zsmart.is.ws.rest.vo.FactureVo; 

 @Component 
public class FactureConverter extends AbstractConverter<Facture,FactureVo>{ 


 @Override 
 public Facture toItem(FactureVo vo) {
 if (vo == null) {
    return null;
      } else {
Facture item = new Facture();

 if (StringUtil.isNotEmpty(vo.getReference())) {
 item.setReference(vo.getReference());
} 

 if (StringUtil.isNotEmpty(vo.getTypeFacture())) {
 item.setTypeFacture(vo.getTypeFacture());
} 

 if (StringUtil.isNotEmpty(vo.getReferenceSociete())) {
 item.setReferenceSociete(vo.getReferenceSociete());
} 

 if (vo.getId() != null) {
 item.setId(NumberUtil.toLong(vo.getId()));
} 

 if (vo.getAnnee() != null) {
 item.setAnnee(NumberUtil.toInt(vo.getAnnee()));
} 

 if (vo.getMois() != null) {
 item.setMois(NumberUtil.toInt(vo.getMois()));
} 

 if (vo.getTrimester() != null) {
 item.setTrimester(NumberUtil.toInt(vo.getTrimester()));
} 

 if (vo.getTotalHt() != null) {
 item.setTotalHt(NumberUtil.toBigDecimal(vo.getTotalHt()));
} 

 if (vo.getTotalTtc() != null) {
 item.setTotalTtc(NumberUtil.toBigDecimal(vo.getTotalTtc()));
} 

 if (vo.getTva() != null) {
 item.setTva(NumberUtil.toBigDecimal(vo.getTva()));
} 

 if (vo.getTotalPayerHt() != null) {
 item.setTotalPayerHt(NumberUtil.toBigDecimal(vo.getTotalPayerHt()));
} 

 if (vo.getTotalRestantHt() != null) {
 item.setTotalRestantHt(NumberUtil.toBigDecimal(vo.getTotalRestantHt()));
} 

 if (vo.getDateFacture() != null) {
 item.setDateFacture(DateUtil.parse(vo.getDateFacture()));
} 

 if (vo.getDateSaisie() != null) {
 item.setDateSaisie(DateUtil.parse(vo.getDateSaisie()));
} 

return item;
 }
 }

  @Override 
 public FactureVo toVo(Facture item) {
 if (item == null) {
    return null;
      } else {
FactureVo vo = new FactureVo();

 if (StringUtil.isNotEmpty(item.getReference())) {
 vo.setReference(item.getReference());
} 

 if (StringUtil.isNotEmpty(item.getTypeFacture())) {
 vo.setTypeFacture(item.getTypeFacture());
} 

 if (StringUtil.isNotEmpty(item.getReferenceSociete())) {
 vo.setReferenceSociete(item.getReferenceSociete());
} 


 if (item.getId() != null) {
 vo.setId(NumberUtil.toString(item.getId()));
} 

 if (item.getAnnee() != null) {
 vo.setAnnee(NumberUtil.toString(item.getAnnee()));
} 

 if (item.getMois() != null) {
 vo.setMois(NumberUtil.toString(item.getMois()));
} 

 if (item.getTrimester() != null) {
 vo.setTrimester(NumberUtil.toString(item.getTrimester()));
} 

 if (item.getTotalHt() != null) {
 vo.setTotalHt(NumberUtil.toString(item.getTotalHt()));
} 

 if (item.getTotalTtc() != null) {
 vo.setTotalTtc(NumberUtil.toString(item.getTotalTtc()));
} 

 if (item.getTva() != null) {
 vo.setTva(NumberUtil.toString(item.getTva()));
} 

 if (item.getTotalPayerHt() != null) {
 vo.setTotalPayerHt(NumberUtil.toString(item.getTotalPayerHt()));
} 

 if (item.getTotalRestantHt() != null) {
 vo.setTotalRestantHt(NumberUtil.toString(item.getTotalRestantHt()));
} 

 if (item.getDateFacture() != null) {
 vo.setDateFacture(DateUtil.formateDate(item.getDateFacture()));
} 

 if (item.getDateSaisie() != null) {
 vo.setDateSaisie(DateUtil.formateDate(item.getDateSaisie()));
} 

return vo;
 }
 }
public void init() { 
}
 } 
