package com.rama.services.ClaimServiceImp;

import com.rama.dao.userAuthentication;
import com.rama.model.Signup;
import com.rama.repository.SignupRepository;
import com.rama.services.SignupInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignupImp implements SignupInterface {
  userAuthentication dao=new userAuthentication();
    @Autowired
    SignupRepository signupRepository;

    public SignupImp() {
    }

    @Override
    public Signup saveAccount(Signup signup) {
        return signupRepository.save(signup);
    }

    @Override
    public Signup findAccount(String password) {
        return signupRepository.findById(password).get();
    }

    @Override
    public boolean userCheck(String email, String password) {

        return dao.loginUser(email, password);
    }
}
