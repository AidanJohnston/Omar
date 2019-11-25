package Clinic.Client.fxGUI.util;

import Clinic.Client.Client;
import Clinic.Client.ClientSecretary;
import Clinic.Core.Token;

public class Session {
    private Token token;
    private ClientSecretary client;
    private Object dataObject;

    public Session(Token _token, ClientSecretary _client, Object _dataObject){
        token = _token;
        client = _client;
        dataObject = _dataObject;
    }

    public Object getDataObject(){
        return dataObject;
    }
    public void setDataObject(Object o){
        dataObject = o;
    }

    public Token getToken(){
        return token;
    }

    public void setToken(Token _token){
        token = _token;
    }

    public ClientSecretary getClient() {
        return client;
    }
}
