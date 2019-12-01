package Clinic.Client;

import Clinic.Client.Connection.MyClient;
import Clinic.Client.GUI.MyGUI;
import Clinic.Core.*;
import Util.Exceptions.*;
import Util.RequestType;
import java.util.ArrayList;
import java.util.List;

//merge this test - Sean

/**
 * ClientSecretary.java - The client secretary stands as a mediator between the GUI and the connection to the server.
 * The secretary provides the business logic between the GUI and the connection to the server.  The GUI can invoke
 * specific functions and perform predetermined actions.
 *
 *
 *
 * @author Aidan Johnsotn
 * @version 1.0
 */
public class ClientSecretary {

    MyClient myClient;
    MyGUI myGUI;
    List<ClientTask> tasklist;
    int avaiableID;

    public ClientSecretary() {
        this.avaiableID = 0;
        tasklist = new ArrayList<ClientTask>();
    }

    public void setMyClient(MyClient myClient) {
        this.myClient = myClient;
    }

    public void setMyGUI(MyGUI myGUI) {
        this.myGUI = myGUI;
    }

    private ClientTask prepareTask(Payload payload) throws ServerException {

        System.out.println("Sending request to server.");
        ClientTask task = new ClientTask(payload);
        tasklist.add(task);
        task.start();

        myClient.sendMessageToServer(payload);

        try {
            task.join();
        }
        catch(InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Client: received response from server: ");
        System.out.println("Type: " + task.getPayload().getType());
        System.out.println("Ping: " +  task.getPayload().getPing() + "ms");
        if(task.getPayload().getType().equals(RequestType.ERROR)) {
            throw (ServerException)task.getPayload().getObject();
        }
        return task;
    }

    public void handleMessageFromServer(Object payloadFromServer) {
        System.out.println("Received a Payload");
        Payload payload = (Payload) payloadFromServer;
        Boolean flag = false;
        int i = 0;
        for(i = 0; i < tasklist.size(); i++) {
            if(tasklist.get(i).getPayload().getId() == payload.getId()) {
                ClientTask task = tasklist.get(i);

                task.setReturnValue(payload.getObject());
                if(payload.getType().equals(RequestType.ERROR)){
                    System.out.println("Incoming payload failed");
                }
                task.setFlag(true);
                tasklist.remove(i);
            }
        }

    }

    /**
     * Login interface between the GUI and client server.
     * @param username
     * @param password
     * @return will return a token that can be used for making other requests to the server
     * @throws IncorrectPayloadException
     */
    public Token login(String username, String password) throws ServerException {
        avaiableID++;
        Payload payload = new Payload(avaiableID, RequestType.LOGIN, new Credentials(username, password));
        Object o = prepareTask(payload).getReturnValue();
        return (Token)o;
    }

    
    /**
     * Logout interface between the GUI and the client server.  Returns true if logout was successful.
     * @param token
     * @return Boolean
     * @throws IncorrectPayloadException
     */
    public boolean logout(Token token) throws ServerException {
        avaiableID++;
        Payload payload = new Payload(avaiableID, RequestType.LOGOUT, token);

        return (boolean) prepareTask(payload).getReturnValue();
    }

    /**
     * make account will not do anything
     * @param object
     * @return
     */
    @Deprecated
    public boolean makeAccount(Object object) throws NotImplementedYetException {
        throw new NotImplementedYetException("You dumb fuck");
    }

    /**
     * Makes an appointment given an instance of an appointment
     * @param token
     * @param appointment
     * @return
     * @throws IncorrectPayloadException
     */
    public boolean makeAppointment(Token token, Appointment appointment) throws Exception {
        avaiableID++;
        Payload payload = new Payload(avaiableID, RequestType.APPOINTMENT_CREATE, token, appointment);
        return (boolean) prepareTask(payload).getReturnValue();
    }

    /**
     * Gets the schedule of all doctors
     * @param token
     * @return
     * @throws IncorrectPayloadException
     */
    public List<Schedule> getScheduleAll(Token token) throws Exception {
        avaiableID++;
        Payload payload = new Payload(avaiableID, RequestType.SCHEDULE_GET_ALL, token);
        return (List<Schedule>) prepareTask(payload).getReturnValue();
    }

    /**
     * Gets the schedule of a specific doctor
     * @param token
     * @param id
     * @return
     * @throws IncorrectPayloadException
     */
    public Schedule getScheduleDoctor(Token token, int id) throws Exception {
        avaiableID++;
        Payload payload = new Payload(avaiableID, RequestType.SCHEDULE_GET_DOCTOR, token, id);
        return (Schedule) prepareTask(payload).getReturnValue();
    }

    /**
     * getCurrentAppointmentPatient returns all current appointments the patient has.
     * @param token
     * @param patient
     * @return
     * @throws IncorrectPayloadException
     */
    public List<Appointment> getCurrentAppointmentPatient(Token token, Patient patient) throws ServerException {
        avaiableID++;
        Payload payload = new Payload(avaiableID, RequestType.APPOINTMENT_PATENT_CURRENT_ALL, token, patient);
        return (List<Appointment>) prepareTask(payload).getReturnValue();
    }

    /**
     * Gets a list of all appointments the patient has had
     * @param token
     * @param patient
     * @return
     * @throws IncorrectPayloadException
     */
    public ArrayList<Appointment> getAppointmentPatientAll(Token token, Patient patient) throws ServerException {
        avaiableID++;
        Payload payload = new Payload(avaiableID, RequestType.APPOINTMENT_PATIENT_ALL, token, patient);
        return (ArrayList<Appointment>) prepareTask(payload).getReturnValue();
    }
    /**
     * Returns a list of all doctors
     * @param token
     * @return ArrayList<Doctor>
     * @throws IncorrectPayloadException
     */
    public ArrayList<Doctor> getDoctorAll(Token token) throws ServerException {
        avaiableID++;
        Payload payload = new Payload(avaiableID, RequestType.DOCTOR_GET_ALL, token);
        Object docs = prepareTask(payload).getReturnValue();
        return(ArrayList<Doctor>)docs;
        //return (ArrayList<Doctor>) prepareTask(payload).getReturnValue();
    }

    /**
     * Returns a given doctor given a specific ID
     * @param id
     * @param token
     * @return Doctor
     * @throws IncorrectPayloadException
     */
    public Doctor getDoctorWithID(int id, Token token) throws ServerException {
        avaiableID++;
        Payload payload = new Payload(avaiableID, RequestType.DOCTOR_GET_GIVEN_ID, token, id);

        return (Doctor) prepareTask(payload).getReturnValue();
    }


    /**
     * Sets a doctor value in the database
     * @param doctor
     * @param token
     * @throws IncorrectPayloadException
     */
    public void setDoctor(Doctor doctor, Token token) throws ServerException {
        avaiableID++;
        Payload payload = new Payload(avaiableID, RequestType.DOCTOR_UPDATE_GIVEN_DOCTOR, token, doctor);
        prepareTask(payload);
    }

    public List<Prescription> getPrescriptionAll(Patient patient, Token token) throws ServerException {
        avaiableID++;
        Payload payload = new Payload(avaiableID, RequestType.PRESCRIPTION_GET_ALL_PATIENT, token, patient);
        return (List<Prescription>) prepareTask(payload);
    }

    public List<Diagnosis> getDiagnosisAll(Patient patient, Token token) throws ServerException {
        avaiableID++;
        Payload payload = new Payload(avaiableID, RequestType.DIAGNOSIS_GET_ALL_PATIENT, token, patient);
        return (List<Diagnosis>) prepareTask(payload);
    }

    public void setScheduleDoctor(Schedule schedule, Token token) throws ServerException {
        avaiableID++;
        Payload payload = new Payload(avaiableID, RequestType.SCHEDULE_SET_GIVEN_SCHEDULE, token, schedule);
        prepareTask(payload);
    }

    public List<Appointment> getAppointmentsCurrentDoctor(int id, Token token) throws ServerException {
        avaiableID++;
        Payload payload = new Payload(avaiableID, RequestType.APPOINTMENT_DOCTOR_CURRENT_ALL, token, id);
        return (List<Appointment>) prepareTask(payload);
    }

    public List<Patient> getPatientAll(Token token) throws ServerException {
        avaiableID++;
        Payload payload = new Payload(avaiableID, RequestType.PATIENT_GET_ALL, token);
        return (List<Patient>) prepareTask(payload);
    }
}
