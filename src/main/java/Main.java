import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {

        List<Patient> patientList = new ArrayList<>();
        Patient patient1 = new Patient("Adam", "Kowalski", "6565646", 400,"brak");
        Patient patient2 = new Patient("Piotr", "Piotrowski", "5435663", 800,"brak");
        Patient patient3 = new Patient("Ewa", "Ewacka", "534646564", 4000,"brak");
        Patient patient4 = new Patient("Ada", "Kowal", "6557446", 400,"brak");
        Patient patient5 = new Patient("Piotr", "Pijowski", "5475663", 1700,"brak");
        Patient patient6 = new Patient("Ela", "Lewacka", "53400564", 4000,"brak");
        Patient patient7 = new Patient("Ela", "Lewacka", "53400564", 4000,"brak");

        patientList.add(patient1);
        patientList.add(patient2);
        patientList.add(patient3);
        patientList.add(patient4);
        patientList.add(patient5);
        patientList.add(patient6);
        patientList.add(patient7);

        WritePatientsData writePatientsData = new WritePatientsData();
        writePatientsData.createFile(patientList);
        Patient patient = new Patient("Justyna", "Justynowska", "465633636", 800,"brak");
        patientList.add(patient);

        writePatientsData.createFile(patientList);


//        System.out.println(check.isPatientRegistered("6565646"));
//        System.out.println(check.isPatientRegistered("45453535"));
//        System.out.println(check.isPatientRegistered("Adam", "Kowalski"));
//        System.out.println(check.isPatientRegistered("Tomasz", "Tomaszewski"));
//        System.out.println("\n");
//        System.out.println(check.isPatientRegistered("Justyna", "Justynowska"));
//        System.out.println(check.isPatientRegistered("Adam", "Tomasiak"));
    }
}