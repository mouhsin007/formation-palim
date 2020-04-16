package com.zsmart.is.ws.rest.converter;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.zsmart.is.service.util.*;
import com.zsmart.is.bean.IsFacture; 
import com.zsmart.is.ws.rest.vo.IsFactureVo; 

 @Component 
public class IsFactureConverter extends AbstractConverter<IsFacture,IsFactureVo>{ 

private boolean impotSociete; 

 @Autowired
 private ImpotSocieteConverter impotSocieteConverter ; 

 @Override 
 public IsFacture toItem(IsFactureVo vo) {
 if (vo == null) {
    return null;
      } else {
IsFacture item = new IsFacture();

 if(impotSociete&& vo.getImpotSocieteVo() != null) {
 item.setImpotSociete(impotSocieteConverter.toItem(vo.getImpotSocieteVo()));
} 
 
 if (StringUtil.isNotEmpty(vo.getReferenceFacture())) {
 item.setReferenceFacture(vo.getReferenceFacture());
} 

 if (StringUtil.isNotEmpty(vo.getReferenceSociete())) {
 item.setReferenceSociete(vo.getReferenceSociete());
} 

 if (vo.getId() != null) {
 item.setId(NumberUtil.toLong(vo.getId()));
} 

return item;
 }
 }

  @Override 
 public IsFactureVo toVo(IsFacture item) {
 if (item == null) {
    return null;
      } else {
IsFactureVo vo = new IsFactureVo();

 if(impotSociete&& item.getImpotSociete() != null) {
 vo.setImpotSocieteVo(impotSocieteConverter.toVo(item.getImpotSociete()));
} 
 
 if (StringUtil.isNotEmpty(item.getReferenceFacture())) {
 vo.setReferenceFacture(item.getReferenceFacture());
} 

 if (StringUtil.isNotEmpty(item.getReferenceSociete())) {
 vo.setReferenceSociete(item.getReferenceSociete());
} 

 if (item.getId() != null) {
 vo.setId(NumberUtil.toString(item.getId()));
} 

return vo;
 }
 }
public void init() { 

impotSociete = true; 
}
 } 
