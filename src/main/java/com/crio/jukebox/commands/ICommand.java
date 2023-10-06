package com.crio.jukebox.commands;

import java.io.FileNotFoundException;
import java.util.List;

public interface ICommand {
    void execute(List<String> tokens) throws FileNotFoundException;
}

