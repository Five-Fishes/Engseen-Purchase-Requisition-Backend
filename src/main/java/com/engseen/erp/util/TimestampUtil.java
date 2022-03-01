package com.engseen.erp.util;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Objects;

public final class TimestampUtil {

    /**
     * <P>Utility function as temporary work around to solve null Instant to Timestamp conversion
     *
     * <P>Only use this Utility when <B>interacting with Legacy Databases</B>.
     * Because legacy database is running <B>SQL Server 2005</B> while we are linking <B>SQL Server 2019</B>
     * to it as a hack to interact with legacy database's tables (Using Stored Procedure).
     *
     * <P>The issue that this Utility solves is the {@code datetime} datatype compatibility as {@code Instant} cannot be used as {@code datetime} type in <B>SQL Server 2005</B>
     *
     * @param instant Instant to be converted to Timestamp
     * @return Timestamp or null
     */
    public static Timestamp fromInstant(Instant instant) {
        if (Objects.isNull(instant)) {
            return null;
        } else {
            return Timestamp.from(instant);
        }
    }

}
