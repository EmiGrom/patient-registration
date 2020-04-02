import java.util.List;
import java.util.Scanner;

public class MainApp {

    private static Scanner scan;
    private static Check check;
    private static List<Patient> patientList;

    //TODO Dopisać możliwość usunięcia z rejestru pacjenta oraz dodać pole do Pacjenta z ceną wizyty

    public static void main(String[] args) {
        ReadPatientData readPatientData = new ReadPatientData();
        patientList = readPatientData.getPatientList();
        check = new Check(patientList);
        scan = new Scanner(System.in);
        System.out.println("Choose an action: \n0 - Finish the action \n1 - Check patient's registration status \n2 - Register the patient \n3 - Check your bank acount status \n4 - Removing patients");
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
                registerPatient();
                System.out.println("New patient is registered");
                System.out.println(patientList);
                break;
            case 3:
                checkingAccountBalance();
                System.out.println("New patient is registered");
                System.out.println(patientList);
                break;
            default:
                break;
        }
    }

    private static void checkingAccountBalance() {
        CheckingAccountBalance checkingAccountBalance = new CheckingAccountBalance(new Patient("Jan", "Nowak", "5453544"));
        System.out.println("How much money do you have?");
        double money = scan.nextInt();
        checkingAccountBalance.wallet(money);
        System.out.println(checkingAccountBalance.getAmountOfMoney());

        try {
            checkingAccountBalance.retraction(2000);

        } catch (Exception e) {
            System.out.println("You don't have money for the service");
        }
    }

    private static void registerPatient() {
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

        Patient newPatient = new Patient(firstName, lastName, pesel);
        patientList.add(newPatient);
        System.out.println(patientList);
        writePatientsData.createFile(patientList);
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