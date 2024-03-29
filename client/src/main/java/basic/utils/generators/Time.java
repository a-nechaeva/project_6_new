package basic.utils.generators;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.time.ZonedDateTime;

/**
 * Time class. Used to get current time. +3 hours from UTC
 *
 */
public final class Time {
    /**
     * Get current time +3 hours from UTC (Moscow time)
     *
     * @return current time +3 hours from UTC
     */
    @Contract(" -> new")
    public static java.time.@NotNull LocalDateTime getTime() {
        return java.time.LocalDateTime.now(java.time.ZoneId.of("Europe/Moscow"));
    }

    /**
     * Get current time +3 hours from UTC (Moscow time)
     *
     * @return current time +3 hours from UTC
     */
    public static ZonedDateTime getZonedDateTime() {
        return ZonedDateTime.now(java.time.ZoneId.of("Europe/Moscow"));
    }
}
