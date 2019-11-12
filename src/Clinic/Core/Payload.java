package Clinic.Core;

import java.io.Serializable;

import Util.RequestType;

/**
 * Package.java - The Package is used to generalize the sending and receiving of data between client and server
 *
 * The package contains three variables:
 *      -id
 *      -type
 *      -object
 *
 *<h3>ID</h3>
 * The id serves as a method for the client to track which request it is receiving the server.  The client could place
 * more than one request towards the server before receiving a response.  When the server is done fulfilling the request
 * and has sent a package back, the server will label its returning package with the same ID.  This lets the client correctly
 * identify import com.sun.xml.internal.bind.v2.runtime.reflect.Lister;the package.
 *
 * <h3>Type</h3>
 * The type defines the request from the client.  The type of requests from the client can be broken down into these categories:
 *      <div>
 *      <b>Error checking</b>
 *      <ul style="list-style-type:none;">
 *          <li>Type 0: Update confirmation</li>
 *          <li>Type 1: Login - Returns login token token</li>
 *          <li>Type 2: Logout - Uses the given token to log the user out</li>
 *          <li>Type 3: Error - Unknown type</li>
 *      </ul>
 *      <b>Diagnosis</b>
 *      <ul style="list-style-type:none;">
 *          <li>Type 10: Request all diagnosis form specific patient</li>
 *          <li>Type 11: Request all diagnosis from specific doctor</li>
 *          <li>Type 12: Update a diagnosis with a given diagnosis</li>
 *          <li>Type 13: Create a new diagnosis with a given diagnosis</li>
 *          <li>Type 14: Remove a diagnosis with a given diagnosis as reference</li>
 *      </ul>
 *      <b>Doctor</b>
 *      <ul style="list-style-type:none;">
 *          <li>Type 20: Request doctor given patient</li>
 *          <li>Type 21: Request all doctors</li>
 *          <li>Type 22: Update a doctor with a given doctor</li>
 *          <li>Type 23: Create a doctor with a given doctor</li>
 *          <li>Type 24: Request list of doctors given a search criteria - <i>name</i></li>
 *          <li>Type 25: Request list of doctors given a search criteria - <i>time</i></li>
 *          <li>Type 26: Request list of doctors given a search criteria - <i>date</i></li>
 *          <li>Type 27: Remove a doctor given a doctor as reference </li>
 *      </ul>
 *      <b>Patient</b>
 *      <ul style="list-style-type:none;">
 *          <li>Type 30: Request all patients</li>
 *          <li>Type 31: Request list of patients given a specific doctor</li>
 *          <li>Type 31: </li>
 *      </ul>
 *      <b>Appointments</b>
 *  *      <ul style="list-style-type:none;">
 *  *          <li>Type 41: Request all appointments</li>
 *  *          <li>Type 42: Request all appointments from specific patient</li>
 *  *          <li>Type 43: Request all appointments from specific doctor</li>
 *  *          <li>Type 44: Update appointment with given appointment</li>
 *  *          <li>Type 45: Create new appointment with given appointment</li>
 *  *          <li>Type 46: Remove appointment with given appointment as reference</li>
 *  *      </ul>
 *      </div>
 *
 *
 *
 *
 * @author Aidan Johnston
 * @version 1.0
 */
public class Payload implements Serializable {

    private int id;
    private String type;
    private Token token;
    Object object;
    /**
     * Constructor used for login
     * @param id
     * @param type
     * @param object
     */
    public Payload(int id, String type, Object object) {
        this.id = id;
        this.type = type;
        this.object = object;
    }

    /**
     * Constructor used for requesting data
     * @param id
     * @param type
     * @param token
     * @param object
     */
    public Payload(int id, String type, Token token, Object object) {
        this.id = id;
        this.type = type;
        this.token = token;
        this.object = object;
    }


    /**
     * Constructor used for requested data when no parameters are needed, or the server is responding with error/update confirmation
     * @param id
     * @param type
     * @param token
     */
    public Payload(int id, String type, Token token) {
        this.id = id;
        this.type = type;
        this.token = token;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public Token getToken() {
        return token;
    }

    public void setToken(Token token) {
        this.token = token;
    }
}
