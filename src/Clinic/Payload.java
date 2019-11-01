package Clinic;

import com.sun.xml.internal.bind.v2.runtime.reflect.Lister;

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
 * identify the package.
 *
 * <h3>Type</h3>
 * The type defines the quest from the client.  The type of requests from the client can be broken down into these categories:
 *      <div>
 *      <b>Error checking</b>
 *      <ul style="list-style-type:none;">
 *          <li>Type 0: Update confirmation</li>
 *          <li>Type 99: Error - Clinic.Server Object contains error information</li>
 *      </ul>
 *      <b>Appointments</b>
 *      <ul style="list-style-type:none;">
 *          <li>Type 1: Request all appointments</li>
 *          <li>Type 2: Request all appointments from specific patient</li>
 *          <li>Type 3: Request all appointments from specific doctor</li>
 *          <li>Type 4: Update appointment with given appointment</li>
 *          <li>Type 5: Create new appointment with given appointment</li>
 *          <li>Type 6: Remove appointment with given appointment as reference</li>
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
 *          <li>Type 20: Doctor login confirmation</li>
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
 *          <li>Type 30: Patient login confirmation</li>
 *          <li>Type 31: Request all patients</li>
 *          <li>Type 32: Request list of patients given a specific doctor</li>
 *          <li>Type 33: </li>
 *      </ul>
 *      </div>
 *
 *
 *
 *
 * @author Aidan Johnston
 * @version 1.0
 */
public class Payload {

    private int id;
    private int type;
    Object object;

    public Payload(int id, int type, Object object) {
        this.id = id;
        this.type = type;
        this.object = object;
    }

    public Payload(int id, int type) {
        this.id = id;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
