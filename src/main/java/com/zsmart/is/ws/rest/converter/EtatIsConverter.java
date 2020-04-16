package com.zsmart.is.ws.rest.converter;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.zsmart.is.service.util.*;
import com.zsmart.is.bean.EtatIs; 
import com.zsmart.is.ws.rest.vo.EtatIsVo; 

 @Component 
public class EtatIsConverter extends AbstractConverter<EtatIs,EtatIsVo>{ 


 @Override 
 public EtatIs toItem(EtatIsVo vo) {
 if (vo == null) {
    return null;
      } else {
EtatIs item = new EtatIs();

 if (StringUtil.isNotEmpty(vo.getLibelle())) {
 item.setLibelle(vo.getLibelle());
} 

 if (StringUtil.isNotEmpty(vo.getCode())) {
 item.setCode(vo.getCode());
} 

 if (vo.getId() != null) {
 item.setId(NumberUtil.toLong(vo.getId()));
} 

return item;
 }
 }

  @Override 
 public EtatIsVo toVo(EtatIs item) {
 if (item == null) {
    return null;
      } else {
EtatIsVo vo = new EtatIsVo();

 if (StringUtil.isNotEmpty(item.getLibelle())) {
 vo.setLibelle(item.getLibelle());
} 

 if (StringUtil.isNotEmpty(item.getCode())) {
 vo.setCode(item.getCode());
} 

 if (item.getId() != null) {
 vo.setId(NumberUtil.toString(item.getId()));
} 

return vo;
 }
 }
public void init() { 
}
 } 
