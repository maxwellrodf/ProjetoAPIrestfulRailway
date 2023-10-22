package com.maxwell.projetoapinuvem.service;

import com.maxwell.projetoapinuvem.model.User;
import com.maxwell.projetoapinuvem.service.impl.UserServiceImpl;
import org.springframework.stereotype.Service;

public interface UserService{
    User findById(Long id);
    User create (User userToCreate);







}
