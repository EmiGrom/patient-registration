public class PatientAlreadyExist extends Exception {

    @Override
    public String getMessage() {

        return "A patient with this name and surname or PESEL number already exists!";
    }
}

