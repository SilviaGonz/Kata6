package software.ulpgc;

import org.eclipse.jetty.util.ajax.JSON;

import java.time.LocalDate;

public class CalculateDaysCommand implements Command {
    private final Input input;
    private final Output output;
    private final LocalDate fromDate;
    private final LocalDate toDate;

    public CalculateDaysCommand(Input input, Output output) {
        this.input = input;
        this.output = output;
        this.fromDate = LocalDate.parse(this.input.getInput("date-from"));
        this.toDate = LocalDate.parse(this.input.getInput("date-to"));

    }

    @Override
    public void execute() {
        long numberOfDaysBetween = new Calendary().getNumberOfDaysBetween(fromDate, toDate);
        int count = 0;
        for (LocalDate date : getDaysFrom() ) {
            if (numberOfDaysBetween < 0) {
                break;
            }
            count++;
            numberOfDaysBetween--;
        }
        this.output.setOutput(Json(count));
    }

    private String Json(int count) {
        return String.format("{\"days\":[%d]}", count);
    }

    private Iterable<LocalDate> getDaysFrom() {
        return new Calendary().getDaysFrom(fromDate);
    }
}
