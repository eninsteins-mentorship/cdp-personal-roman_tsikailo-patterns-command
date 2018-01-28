package com.command.impl;


import com.command.PathHandler;
import com.command.view.Constants;
import com.command.view.View;
import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;


import static com.command.view.Constants.COMMAND_ARGUMENTS_PATH;
import static com.command.view.Constants.NOT_VALID;

/**
 * Describes all types of operations in this application.
 */
public enum Operation {
    DIR,
    CD,
    EMPTY,
    EXIT;

    /**
     * Returns all allowed operations in this application.
     *
     * @param arg  entered string.
     * @param view the displayed {@code View}.
     * @return {@code Operation}.
     */
    public static Operation getOperation(final String arg, final View view) {
        Operation target = EMPTY;
        if (arg.equals("0")) {
            target = EXIT;
        }
        else if (arg.equals("dir"))
            target = DIR;
        //enter key
        else if (arg.equals("\u23CE")) {
            target = EMPTY;
        }else if (arg.startsWith("cd")) {
            PathHandler.saveValueToProperties(COMMAND_ARGUMENTS_PATH, Constants.CD, Cd.getCommandArgument(arg));
            target = CD;
        } else {
            view.display(String.format(NOT_VALID, arg));
        }
        return target;
    }
}
