package com.zsmart.is.service.facade;

import java.util.ArrayList;
import java.util.List;
import java.util.Date; 
import java.math.BigDecimal; 
import com.zsmart.is.bean.IsFacture;
import com.zsmart.is.bean.ImpotSociete; 
public interface IsFactureService {

public IsFacture save(IsFacture isfacture); 
public List<IsFacture>  findAll();
public IsFacture findById(Long id);
public int delete(IsFacture isfacture);
public void  deleteById(Long id);
public void clone(IsFacture isfacture,IsFacture isfactureClone);
public IsFacture clone(IsFacture isfacture);
public List<IsFacture> clone(List<IsFacture>isfactures);
 public List<IsFacture>  findByCriteria(String referenceFacture,String referenceSociete,long serialVersionUIDMin,long serialVersionUIDMax,Long idMin,Long idMax);

}
