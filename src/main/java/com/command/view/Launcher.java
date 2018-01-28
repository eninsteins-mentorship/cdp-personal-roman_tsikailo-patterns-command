package com.command.view;

import com.command.PathHandler;
import com.command.impl.CommandExecutor;
import com.command.impl.Operation;

import static com.command.PathHandler.getPath;
import static com.command.impl.Operation.EMPTY;
import static com.command.impl.Operation.EXIT;
import static com.command.view.Constants.WELCOME;


public class Launcher {

    /**
     * Asks user input and performs user commands
     * until the {@code Exit} impl.
     */
    public static void main(String[] args) {
        View view = new Console();
        view.display(WELCOME);
        PathHandler.setDefaultPath();
        Operation operation = EMPTY;
        while (!operation.equals(EXIT)) {
            view.display(getPath().toString());
            operation = Operation.getOperation(view.readString(), view);
            CommandExecutor.execute(operation, view);
        }
        CommandExecutor.execute(operation, view);
    }
}
