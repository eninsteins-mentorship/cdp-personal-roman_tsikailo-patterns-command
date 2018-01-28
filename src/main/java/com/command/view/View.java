package com.command.view;

public interface View {

    /**
     * Displays a string to the output view.
     *
     * @param statement the string to be displayed.
     */
    void display(String statement);

    /**
     * Reads a string.
     *
     * @return The string that was read.
     */
    String readString();
}
