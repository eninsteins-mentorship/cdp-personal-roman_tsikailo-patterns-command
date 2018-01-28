package com.command.impl;

import com.command.view.View;

import java.io.IOException;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;

import static com.command.PathHandler.getPath;
import static com.command.view.Constants.CONTENT;

public class Dir implements Command {

    /**
     * Displays a content of current directory and file attributes
     * to the output view
     *
     * @param view output view.
     */
    @Override
    public void execute(final View view) {
        final Path dir = getPath();
        view.display(CONTENT);
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
            for (Path file : stream) {
                view.display(String.format(
                        "%-20s\t%30s", file.getFileName().toString(),
                        getAttributes(file)));
            }
            view.display("");
        } catch (IOException | DirectoryIteratorException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns attributes of the file.
     *
     * @param file destination file.
     * @return formatted string with  list of attributes.l
     * @throws IOException if some I/O error occur.
     */
    private String getAttributes(final Path file) throws IOException {
        final BasicFileAttributes attr =
                Files.readAttributes(file, BasicFileAttributes.class);
        return String.format("created: %-10s, size: %d bytes. Access[read: %s, write: %s, hidden: %s]",
                attr.creationTime().toString().substring(0, 10),
                attr.size(),
                Files.isReadable(file),
                Files.isWritable(file),
                Files.isHidden(file));
    }
}
