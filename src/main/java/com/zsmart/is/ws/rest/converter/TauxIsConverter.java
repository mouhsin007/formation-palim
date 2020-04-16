package com.zsmart.is.ws.rest.converter;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.zsmart.is.service.util.*;
import com.zsmart.is.bean.TauxIs; 
import com.zsmart.is.ws.rest.vo.TauxIsVo; 

 @Component 
public class TauxIsConverter extends AbstractConverter<TauxIs,TauxIsVo>{ 


 @Override 
 public TauxIs toItem(TauxIsVo vo) {
 if (vo == null) {
    return null;
      } else {
TauxIs item = new TauxIs();

 if (vo.getId() != null) {
 item.setId(NumberUtil.toLong(vo.getId()));
} 

 if (vo.getProfitMin() != null) {
 item.setProfitMin(NumberUtil.toBigDecimal(vo.getProfitMin()));
} 

 if (vo.getProfitMax() != null) {
 item.setProfitMax(NumberUtil.toBigDecimal(vo.getProfitMax()));
} 

 if (vo.getPercentage() != null) {
 item.setPercentage(NumberUtil.toBigDecimal(vo.getPercentage()));
} 

 if (vo.getMajoration() != null) {
 item.setMajoration(NumberUtil.toBigDecimal(vo.getMajoration()));
} 

 if (vo.getPenalite() != null) {
 item.setPenalite(NumberUtil.toBigDecimal(vo.getPenalite()));
} 

 if (vo.getDateApplicationDebut() != null) {
 item.setDateApplicationDebut(DateUtil.parse(vo.getDateApplicationDebut()));
} 

 if (vo.getDateApplicationFin() != null) {
 item.setDateApplicationFin(DateUtil.parse(vo.getDateApplicationFin()));
} 

return item;
 }
 }

  @Override 
 public TauxIsVo toVo(TauxIs item) {
 if (item == null) {
    return null;
      } else {
TauxIsVo vo = new TauxIsVo();

 if (item.getId() != null) {
 vo.setId(NumberUtil.toString(item.getId()));
} 

 if (item.getProfitMin() != null) {
 vo.setProfitMin(NumberUtil.toString(item.getProfitMin()));
} 

 if (item.getProfitMax() != null) {
 vo.setProfitMax(NumberUtil.toString(item.getProfitMax()));
} 

 if (item.getPercentage() != null) {
 vo.setPercentage(NumberUtil.toString(item.getPercentage()));
} 

 if (item.getMajoration() != null) {
 vo.setMajoration(NumberUtil.toString(item.getMajoration()));
} 

 if (item.getPenalite() != null) {
 vo.setPenalite(NumberUtil.toString(item.getPenalite()));
} 

 if (item.getDateApplicationDebut() != null) {
 vo.setDateApplicationDebut(DateUtil.formateDate(item.getDateApplicationDebut()));
} 

 if (item.getDateApplicationFin() != null) {
 vo.setDateApplicationFin(DateUtil.formateDate(item.getDateApplicationFin()));
} 

return vo;
 }
 }
public void init() { 
}
 } 
