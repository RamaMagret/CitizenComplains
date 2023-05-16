package com.rama.services;


import com.rama.model.Signup;

public interface SignupInterface {
    public Signup saveAccount(Signup signup);
    public Signup findAccount(String password);
    public boolean userCheck(String email, String password );
}
