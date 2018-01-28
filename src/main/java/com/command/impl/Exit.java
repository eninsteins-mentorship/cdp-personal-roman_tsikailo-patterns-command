package com.command.impl;

import com.command.view.View;

public class Exit implements Command {
    @Override
    public void execute(View view) {
        view.display("good bye");
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e) {
            System.exit(1);
        }
        System.exit(0);
    }
}
