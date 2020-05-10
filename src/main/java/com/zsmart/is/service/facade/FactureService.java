package com.zsmart.is.service.facade;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.repository.query.Param;

import java.util.Date; 
import java.math.BigDecimal; 
import com.zsmart.is.bean.Facture;
public interface FactureService {

public Facture save(Facture facture); 
public List<Facture>  findAll();
public Facture findById(Long id);
public Facture  findByReference(String  reference);
public int delete(Facture facture);
public void  deleteById(Long id);
public void  deleteByReference(String  reference);
public void clone(Facture facture,Facture factureClone);
public Facture clone(Facture facture);
public List<Facture> clone(List<Facture>factures);
 public List<Facture>  findByCriteria(String reference,String typeFacture,String referenceSociete,long serialVersionUIDMin,long serialVersionUIDMax,Long idMin,Long idMax,Integer anneeMin,Integer anneeMax,Integer moisMin,Integer moisMax,Integer trimesterMin,Integer trimesterMax,BigDecimal totalHtMin,BigDecimal totalHtMax,BigDecimal totalTtcMin,BigDecimal totalTtcMax,BigDecimal tvaMin,BigDecimal tvaMax,BigDecimal totalPayerHtMin,BigDecimal totalPayerHtMax,BigDecimal totalRestantHtMin,BigDecimal totalRestantHtMax,Date dateFactureMin,Date dateFactureMax,Date dateSaisieMin,Date dateSaisieMax);
 public List<Facture> factureCharge( Integer anne);
 public List<Facture> factureGain( Integer anne);
 public Facture ajouter(Facture facture);
 public int saveListFacture(List<Facture> factures);
 
 
}
