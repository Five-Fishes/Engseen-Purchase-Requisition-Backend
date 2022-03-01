package com.engseen.erp.util;

import org.springframework.lang.Nullable;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Objects;

public final class TimestampUtil {

    /**
     * Utility function as temporary work around to solve null Instant to Timestamp conversion
     * @param instant Instant to be converted to Timestamp
     * @return Timestamp or null
     */
    @Nullable
    public static Timestamp fromInstant(@Nullable Instant instant) {
        if (Objects.isNull(instant)){
            return null;
        } else {
            return Timestamp.from(instant);
        }
    }

}
