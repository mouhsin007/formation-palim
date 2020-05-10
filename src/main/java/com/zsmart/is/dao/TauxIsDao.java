package com.zsmart.is.dao;
import com.zsmart.is.bean.TauxIs;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
 public interface TauxIsDao extends JpaRepository<TauxIs,Long> {
@Query( "SELECT tis FROM TauxIs tis WHERE  profitMin< :profit AND profitMax> :profit ")
public TauxIs findTauxIsByProfit(@Param("profit") BigDecimal profit);


}
