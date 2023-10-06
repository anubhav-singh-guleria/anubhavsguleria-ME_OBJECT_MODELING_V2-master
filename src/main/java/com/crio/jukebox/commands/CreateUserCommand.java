package com.crio.jukebox.commands;

import java.io.FileNotFoundException;
import java.util.List;

import com.crio.jukebox.entities.User;
import com.crio.jukebox.repositories.IUserRepository;

public class CreateUserCommand implements ICommand{
    private final IUserRepository userRepository;
    public CreateUserCommand(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public void execute(List<String> tokens) throws FileNotFoundException {
        // TODO Auto-generated method stub
        User entity = new User(tokens.get(1));
        System.out.println(userRepository.save(entity));
    }
    
}
