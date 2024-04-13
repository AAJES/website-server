package com.ajes.service;

import com.ajes.model.Login;
import com.ajes.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginService {

    @Autowired
    private LoginRepository loginRepository;

    public Login addLogin(Login login){
        return loginRepository.save(login);
    }

    public List<Login> getAllLogin(){
        return loginRepository.findAll();
    }

    public Login getLoginById(Integer loginId){
        return loginRepository.findById(loginId).get();
    }

    public Login deleteLoginById(Integer loginId){
        Login login = getLoginById(loginId);
        loginRepository.deleteById(loginId);
        return login;
    }


    public Login updateLoginId(Integer loginId, Login login){
        login.setLoginId(loginId);
        return loginRepository.save(login);
    }
}
