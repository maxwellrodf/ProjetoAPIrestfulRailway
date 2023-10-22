package com.maxwell.projetoapinuvem.service.impl;

import com.maxwell.projetoapinuvem.model.User;
import com.maxwell.projetoapinuvem.repository.UserRepository;
import com.maxwell.projetoapinuvem.service.UserService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User userToCreate) {
        if (userRepository.existsByAccountNumber(userToCreate.getAccount().getNumber())){
            throw new IllegalArgumentException("Essa conta já existe.");
        }
        return userRepository.save(userToCreate);
    }
}
