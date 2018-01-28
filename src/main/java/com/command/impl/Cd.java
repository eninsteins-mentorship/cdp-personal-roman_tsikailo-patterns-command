package com.command.impl;

import com.command.view.View;

import java.nio.file.Files;
import java.nio.file.Path;

import static com.command.PathHandler.getPath;
import static com.command.PathHandler.*;
import static com.command.view.Constants.*;

public class Cd implements Command {

    /**
     * Changes current directory to other directory.
     *
     * @param view output view.
     */
    @Override
    public void execute(final View view) {
        final String directory = loadPropertieValue(COMMAND_ARGUMENTS_PATH, CD);
        if (directory.equals(".."))
            goBack();
        else
            changeDirectory(view, directory);
    }

    public static String getCommandArgument (String input) {
        return input.contains(" ") && !input.endsWith(" ") ? input.split(" ")[1] : "";
    }

    private void goBack() {
        Path currentPath = getPath();
        savePathToProperties(CURRENT_DIRECTORY_PATH, PATH, currentPath.getParent());
    }

    /**
     * Changes current directory if it is allowed.
     *
     * @param view      output view.
     * @param directory child directory.
     */
    private void changeDirectory(final View view, final String directory) {
        if (checkDirectory(directory))
            change(directory);
        else
            view.display(NO_DIRECTORY);
    }

    /**
     * Checks if the directory exists.
     *
     * @param directory directory to be checked.
     * @return true if directory exists, false if not.
     */
    private boolean checkDirectory(final String directory) {
        return Files.isDirectory(getPath().resolve(directory));
    }

    /**
     * Changes the path to the current directory to the new path.
     *
     * @param directory child directory.
     */
    private void change(final String directory) {
        savePathToProperties(CURRENT_DIRECTORY_PATH, PATH, getPath().resolve(directory));
    }
}