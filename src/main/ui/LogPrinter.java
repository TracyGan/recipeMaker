package ui;

import model.EventLog;
import model.exception.LogException;

public interface LogPrinter {

    void printLog(EventLog e) throws LogException;
}
