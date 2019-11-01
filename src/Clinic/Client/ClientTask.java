package Clinic.Client;

import Clinic.Core.Payload;

public class ClientTask extends Thread {

    Payload paylaod;
    Object returnValue;
    Boolean flag;
    int count;
    public ClientTask(Payload paylaod) {
        this.paylaod = paylaod;
        this.flag = false;
        this.count = 10;
    }

    @Override
    public void run() {
        while(!this.flag || count < 0) {
            count--;
            try {
                this.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //Situation 1: Count is 0, therefore no answer from sever, set return value to error message;
        if (count < 0)
            this.returnValue = (Object)"Error Server didnt answer";

        //Situation 2: The flag was raised. This means the server responded.  The secretary will update the return value;
    }

    public Object getReturnValue() {
        return returnValue;
    }

    public void setReturnValue(Object returnValue) {
        this.returnValue = returnValue;
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public Payload getPaylaod() {
        return paylaod;
    }

    public void setPaylaod(Payload paylaod) {
        this.paylaod = paylaod;
    }
}
