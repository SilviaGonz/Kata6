package software.ulpgc;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Iterator;

public record Calendary() {
    public Iterable<LocalDate> getDaysFrom(LocalDate from) {
        return new Iterable<LocalDate>() {
            @Override
            public Iterator<LocalDate> iterator() {
                return new Iterator<LocalDate>() {
                    @Override
                    public boolean hasNext() {
                        return true;
                    }

                    @Override
                    public LocalDate next() {
                        LocalDate next = current;
                        current = next.plusDays(1);
                        return next;
                    }

                    private LocalDate current = from;
                };
            }
        };
    }

    public long getNumberOfDaysBetween(LocalDate fromDate, LocalDate toDate) {
        return ChronoUnit.DAYS.between(fromDate, toDate);
    }
}
