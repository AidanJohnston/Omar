package Clinic.Server.Data;

import Clinic.Core.*;
import Util.UserType;
import Util.Exceptions.LoginFailedException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Queries {
    public Credentials login(Credentials creds) throws LoginFailedException{
        Credentials match = new DataReader()
            .readCredentials()
            .stream()
            .filter(c -> c.getUsername() == creds.getUsername())
            .filter(c -> c.getHashword() == creds.getHashword())
            .collect(Collectors.toList())
            .get(0);

        if(match == null){
            throw new LoginFailedException("Could not find matching credentials");
        }
        
        return match;
    }
}
