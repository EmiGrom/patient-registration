
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class MainApp {

    private static Scanner scan;
    private static Check check;
    private static List<Patient> patientList;
    private static WritePatientsData writePatientsData;

    public static void main(String[] args) {
        ReadPatientData readPatientData = new ReadPatientData();
        writePatientsData = new WritePatientsData();
        patientList = readPatientData.getPatientList();
        check = new Check(patientList);
        scan = new Scanner(System.in);
        System.out.println("Choose an action: \n0 - Finish the action \n1 - Check patient's registration status \n2 - Register the patient \n3 - Testing for coronavirus  \n4 - Removing patients");
        Integer action = scan.nextInt();
        chooseTypeSearching(action);
    }

    private static void chooseTypeSearching(Integer typeNumber) {
        switch (typeNumber) {
            case 0:
                break;
            case 1:
                isRegistered();
                break;
            case 2:
                try {
                    registerPatient();
                } catch (PatientAlreadyExist e) {
                    System.out.println(e.getMessage());
                }
                break;
            case 3:
                coronavirustest();
                break;
            case 4:
                removePatient();
                break;
            default:
                break;
        }
    }

    private static void removePatient() {
        System.out.println(patientList);
        Patient patientTemp = findPatient();
        patientList.remove(patientTemp);
        System.out.println(patientList);
        writePatientsData.createFile(patientList);
        System.out.println("Patient deleted.");
    }

    private static Patient findPatient() {
        System.out.println("Search patient by: \n0 - Finish the action \n1 - name and surname \n2 - PESEL number");
        Integer action = scan.nextInt();

        Patient patientTemp = null;

        switch (action) {
            case 0:
                break;
            case 1:
                System.out.println("Enter a name: ");
                String name = scan.next();
                System.out.println("Enter a surname: ");
                String surname = scan.next();
                patientTemp = check.findPatient(name, surname);
                break;
            case 2:
                System.out.println("Enter a PESEL number: ");
                String pesel = scan.next();
                patientTemp = check.findPatient(pesel);
                break;
            default:
                break;
        }
        return patientTemp;
    }

    private static void coronavirustest() {

        System.out.println("Enter the price of the test: ");
        Double price = scan.nextDouble();
        for (Patient patient : patientList) {
            if (patient.getPrice() <= price) {
                patient.setCoronavirus("brak");

                System.out.println("Patient: " + patient + "Patient has not enough money, the test hasn't been done.");

            } else {

                double temp = patient.getPrice();
                patient.setPrice(temp - price);

                Random rand = new Random();
                Boolean value = rand.nextBoolean();

                if (value == true) {
                    patient.setCoronavirus("pozytywny");
                } else {
                    patient.setCoronavirus("negatywny");
                }

                System.out.println("Patient: " + patient + " The test was done.");

            }
        }

        writePatientsData.createFile(patientList);
    }

    private static void registerPatient() throws PatientAlreadyExist {
        WritePatientsData writePatientsData = new WritePatientsData();
        writePatientsData.createFile(patientList);
        Check check = new Check(patientList);
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter first name: ");
        String firstName = scan.nextLine();
        System.out.println("Enter last name: ");
        String lastName = scan.nextLine();
        System.out.println("Enter PESEL number: ");
        String pesel = scan.nextLine();
        System.out.println("Enter the amount of money: ");
        Double price = scan.nextDouble();

        if (check.isPatientRegistered(pesel)) {
            throw new PatientAlreadyExist();
        }

        Patient newPatient = new Patient(firstName, lastName, pesel, price, null);
        patientList.add(newPatient);
        writePatientsData.createFile(patientList);
        System.out.println("Patient registered");
        System.out.println(patientList);
    }

    private static void isRegistered() {
        System.out.println("Check patient's registration status via: \n0 - Finish the action \n1 - name and surname \n2 - PESEL number");
        Integer action = scan.nextInt();

        switch (action) {
            case 0:
                break;
            case 1:
                System.out.println("Enter a name: ");
                String name = scan.next();
                System.out.println("Enter a surname: ");
                String surname = scan.next();
                boolean a = check.isPatientRegistered(name, surname);
                System.out.println(check.isPatientRegistered(name, surname));


                break;
            //TODO W przypadku dopasowań więcej niż 1 rzucić użytkownikowi błąd
            case 2:
                System.out.println("Enter a PESEL number: ");
                String pesel = scan.next();
                System.out.println(check.isPatientRegistered(pesel));
                break;
            default:
                break;
        }

    }
}