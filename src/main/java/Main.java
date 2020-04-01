import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        List<Patient> patientList = new ArrayList<>();
        Patient patient1 = new Patient("Piotr", "Piotrowski", "54055500454");
        Patient patient2 = new Patient("Adam", "Adamski", "74395840391");
        Patient patient3 = new Patient("Kacper", "Kacperski", "83291830495");
        Patient patient4 = new Patient("Zuzanna", "Zuzannowska", "840712948354");
        patientList.add(patient1);
        patientList.add(patient2);
        patientList.add(patient3);
        patientList.add(patient4);

        WritePatientsData writePatientsData = new WritePatientsData();
        writePatientsData.createFile(patientList);

        Check check = new Check(patientList);

        System.out.println("Is the patient registered? " + check.isPatientRegistered("Piotr", "Nowacki"));
        System.out.println("Is the patient registered? " + check.isPatientRegistered("83291830495"));
        System.out.println("Is the patient registered? " + check.isPatientRegistered("Robert", "Robertowski"));
        System.out.println("Is the patient registered? " + check.isPatientRegistered("Zuzanna", "Zuzannowska"));
        System.out.println("Is the patient registered? " + check.isPatientRegistered("840712948354"));

        System.out.println("\n");

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter first name: ");
        String firstName = scan.nextLine();
        System.out.println("Enter last name: ");
        String lastName = scan.nextLine();
        System.out.println("Enter PESEL number: ");
        String pesel = scan.nextLine();

        Patient patient5 = new Patient(firstName, lastName, pesel);

        if (check.isPatientRegistered(firstName, lastName) || check.isPatientRegistered(pesel) == true) {
            System.out.println("The patient is registered");

        } else {
            System.out.println("Register the patient");
        }

        if (patientList.stream().anyMatch(patient -> patient.getName().equals(firstName) && patient.getSurname().equals(lastName) || patient.getPesel().equals(pesel))) {
            System.out.println("Unable to register");

        } else {
            patientList.add(patient5);
            System.out.println(patientList);
            writePatientsData.createFile(patientList);
        }
    }
}