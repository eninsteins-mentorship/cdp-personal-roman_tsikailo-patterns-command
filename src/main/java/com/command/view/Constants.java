package com.command.view;


import java.nio.file.Path;
import java.nio.file.Paths;

public final class Constants {

    public static final Path CURRENT_DIRECTORY_PATH = Paths.get("src\\main\\resources\\currentPath.properties");
    public static final Path COMMAND_ARGUMENTS_PATH = Paths.get("src\\main\\resources\\commandArguments.properties");
    public static final Path DEFAULT_PATH = Paths.get("src\\main\\java\\com\\command");
    public static final String CONTENT = "content:\n";
    public static final String NO_DIRECTORY = "There is no such directory.";
    public static final String NOT_VALID = "%s is not recognized as an internal or external command operable program or batch file";
    public static final String WELCOME = "\tWelcome!";
    public static final String PATH = "path";
    public static final String CD = "cd";
}
