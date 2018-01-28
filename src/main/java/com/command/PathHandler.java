package com.command;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

import static com.command.view.Constants.DEFAULT_PATH;
import static com.command.view.Constants.PATH;
import static com.command.view.Constants.CURRENT_DIRECTORY_PATH;


public final class PathHandler {

    /**
     * Replaces terminal path in the properties file with a default path.
     */
    public static void setDefaultPath() {
        savePathToProperties(CURRENT_DIRECTORY_PATH, PATH, DEFAULT_PATH);
    }

    /**
     * Returns a {@code path} attribute from a properties file.
     *
     * @return  an absolute representation of the {@code Path}.
     */
    public static Path getPath() {
        return Paths.get(loadPropertieValue(
                CURRENT_DIRECTORY_PATH, PATH)
        ).toAbsolutePath();
    }

    /**
     * Reads a {@code path} attribute from a properties file.
     *
     * @param propertiesPath path of the properties file.
     * @return String representation of {@code path} attribute
     * from a properties file.
     */
    public static String loadPropertieValue(final Path propertiesPath, final String key) {
        final Properties prop = new Properties();
        try (InputStream in = new FileInputStream(new File(propertiesPath.toString()))) {
            prop.load(in);
            return prop.getProperty(key);
        } catch (IOException f) {
            f.printStackTrace();
            return "";
        }
    }

    /**
     * Writes current path of terminal to the properties file.
     *
     * @param propertiesPath path of the properties file.
     * @param path           current path of terminal.
     */
    public static void savePathToProperties(final Path propertiesPath, final String propertieName, final Path path) {
        final Properties prop = new Properties();
        try (OutputStream out = new FileOutputStream(new File(propertiesPath.toString()))) {
            prop.setProperty(propertieName, path.toString());
            prop.store(out, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveValueToProperties(final Path propertiesPath, final String propertieName, final String value) {
        final Properties prop = new Properties();
        try (OutputStream out = new FileOutputStream(new File(propertiesPath.toString()))) {
            prop.setProperty(propertieName, value);
            prop.store(out, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
