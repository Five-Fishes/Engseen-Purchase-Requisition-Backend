package com.engseen.erp.repository;

import com.engseen.erp.domain.CounterTable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CounterTableRepository extends JpaRepository<CounterTable, Integer> {

    CounterTable findOneByCounterCode(String counterCode);

    CounterTable findOneById(Integer id);

    /*
    UnusedReturnValue warning is suppressed because return value works in SQL Server 2019, NOT in SQL Server 2005
     */
    @SuppressWarnings("UnusedReturnValue")
    @Query(value = "EXEC CounterTableUpdate :ID, :CounterCode, :CounterMask, :DefaultCounter, :LastCounter, :FileName", nativeQuery = true)
    CounterTable updateCounterTable(@Param("ID") Integer id, @Param("CounterCode") String counterCode, @Param("CounterMask") String counterMask,
                                    @Param("DefaultCounter") String defaultCounter, @Param("LastCounter") Integer lastCounter, @Param("FileName") String fileName);

}
