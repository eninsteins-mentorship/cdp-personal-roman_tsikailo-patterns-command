package com.command.impl;


import com.command.view.View;

public interface Command {

    void execute(final View view);
}
