package com.command.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public final class Console implements View {

    private static final BufferedReader reader = new BufferedReader(
            new InputStreamReader(System.in)
    );

    Console() {
    }

    /**
     * Reads a string from console using {@code BufferedReader}.
     *
     * @return The string that was read.
     * @throws IOException if an I/O error occurs.
     */
    private static String readStringFromConsole() throws IOException {
        return reader.readLine();
    }

    public void display(String statement) {
        displayOnConsole(statement);
    }

    public String readString() {
        String result;
        try {
            result = readStringFromConsole();
        } catch (IOException e) {
            result = "";
        }
        return result;
    }

    /**
     * Displays a string on the console.
     *
     * @param statement the string to be displayed.
     */
    private void displayOnConsole(String statement) {
        System.out.println(statement);
    }
}
