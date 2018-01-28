package com.command.impl;

import com.command.view.View;

public class Empty implements Command {
    @Override
    public void execute(View view) {
        // do nothing
    }
}
