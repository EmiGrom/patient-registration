import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {

        List<Patient> patientList = new ArrayList<>();
        Patient patient1 = new Patient("Adam", "Kowalski", "6565646", 400);
        Patient patient2 = new Patient("Piotr", "Piotrowski", "5435663", 800);
        Patient patient3 = new Patient("Ewa", "Ewacka", "534646564", 4000);
        patientList.add(patient1);
        patientList.add(patient2);
        patientList.add(patient3);

        WritePatientsData apachePOIExcelWrite = new WritePatientsData();

        apachePOIExcelWrite.createFile(patientList);

        Check check = new Check(patientList);

        System.out.println(check.isPatientRegistered("6565646"));
        System.out.println(check.isPatientRegistered("45453535"));

        System.out.println(check.isPatientRegistered("Adam", "Kowalski"));
        System.out.println(check.isPatientRegistered("Tomasz", "Tomaszewski"));

        System.out.println("\n");

        Patient patient = new Patient("Justyna", "Justynowska", "465633636", 800);
        System.out.println(check.isPatientRegistered("Justyna", "Justynowska"));

        patientList.add(patient);

        apachePOIExcelWrite.createFile(patientList);

        System.out.println(check.isPatientRegistered("Adam", "Tomasiak"));
    }
}