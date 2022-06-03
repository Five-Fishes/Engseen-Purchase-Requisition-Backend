package com.engseen.erp.aop.sql;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
@RequiredArgsConstructor
public class LinkedServerQueryAspect {

    private final JdbcTemplate jdbcTemplate;

    @Pointcut("@annotation(com.engseen.erp.aop.sql.annotation.LinkedServerQuery)")
    private void linkedServerQueryPointCut() { /* Pointcut method */ }

    @AfterReturning("com.engseen.erp.aop.sql.LinkedServerQueryAspect.linkedServerQueryPointCut()")
    public void linkedServerQueryReturn() {
        jdbcTemplate.execute("SET XACT_ABORT OFF;");
    }
}
