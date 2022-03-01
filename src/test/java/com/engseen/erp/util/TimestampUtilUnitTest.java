package com.engseen.erp.util;

import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

class TimestampUtilUnitTest {

    private static final Instant NOW = Instant.now();

    @Test
    public void nowInstantShouldReturnNowTimestamp() {
        assertEquals(Timestamp.from(NOW), TimestampUtil.fromInstant(NOW));
    }

    @Test
    public void nullInstantShouldReturnNull() {
        assertNull(TimestampUtil.fromInstant(null));
    }
}