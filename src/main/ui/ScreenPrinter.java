package ui;

import model.EventLog;
import model.exception.LogException;
import model.Event;

public class ScreenPrinter implements LogPrinter {

    public ScreenPrinter() {
    }

    @Override
    public void printLog(EventLog e) throws LogException {
        for (Event next: e) {
            System.out.println(next.toString() + "\n\n");
        }
    }
}
