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
 *      <b>Error checking</b>
 *      Type 0: Update confirmation
 *      Type 99: Error - Server Object contains error information
 *
 *      <b>Appointments</b>
 *      Type 1: Request all appointments
 *      Type 2: Request all appointments from specific patient
 *      Type 3: Request all appointments from specific doctor
 *      Type 4: Update appointment with given appointment
 *      Type 5: Create new appointment with given appointment
 *      Type 6: Remove appointment with given appointment as reference
 *
 *      <b>Diagnosis</b>
 *      Type 10: Request all diagnosis form specific patient
 *      Type 11: Request all diagnosis from specific doctor
 *      Type 12: Update a diagnosis with a given diagnosis
 *      Type 13: Create a new diagnosis with a given diagnosis
 *      Type 14: Remove a diagnosis with a given diagnosis as reference
 *
 *      <b>Doctor</b>
 *      Type 20: Doctor login confirmation
 *      Type 21: Request all doctors
 *      Type 22: Update a doctor with a given doctor
 *      Type 23: Create a doctor with a given doctor
 *      Type 24: Request list of doctors given a search criteria - name
 *      Type 25: Request list of doctors given a search criteria - time
 *      Type 26: Request list of doctors given a search criteria - date
 *      Type 27: Remove a doctor given a doctor as reference
 *
 *      <b>Patient</b>
 *      Type 30: Patient login confirmation
 *      Type 31: Request all patients
 *      Type 32: Request list of patients given a specific doctor
 *      Type 33:
 *
 *
 *
 *
 *
 * @author Aidan Johnston
 * @version 1.0
 */
public class Package {

    private int id;
    private int type;
    Object object;

    public Package(int id, int type, Object object) {
        this.id = id;
        this.type = type;
        this.object = object;
    }

    public Package(int id, int type) {
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
