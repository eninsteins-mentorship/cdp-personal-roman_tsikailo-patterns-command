package com.command.impl;

import com.command.view.View;

import java.util.HashMap;
import java.util.Map;

import static com.command.impl.Operation.*;

public class CommandExecutor {

    private static Map<Operation, Command> operationCommandMap;

    static {
        operationCommandMap = new HashMap<>();
        operationCommandMap.put(EMPTY, new Empty());
        operationCommandMap.put(DIR, new Dir());
        operationCommandMap.put(CD, new Cd());
        operationCommandMap.put(EXIT, new Exit());
    }

    /**
     * This class can't be instantiated.
     */
    private CommandExecutor() {
    }

    /**
     * Executes the impl according to the {@code operationCommandMap}.
     *
     * @param operation {@code Operation} to be performed.
     */
    public static void execute(Operation operation, View view) {
        Command executedCommand = operationCommandMap.get(operation);
        executedCommand.execute(view);
    }
}
