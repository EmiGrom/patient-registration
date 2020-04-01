import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Check {

    private List<Patient> patientList;

    public boolean isPatientRegistered(String name, String surname) {
        boolean isPatientRegistered = false;

        for (Patient patient : patientList) {
            if (patient.getName().equals(name)&& patient.getSurname().equals(surname)) {
                isPatientRegistered = Boolean.TRUE;
            }
        }
        return isPatientRegistered;
    }

    public boolean isPatientRegistered(String pesel) {
        boolean isPatientRegistered = false;

        for (Patient patient : patientList) {
            if (patient.getPesel().equals(pesel)) {
                isPatientRegistered = Boolean.TRUE;
            }
        }
        return isPatientRegistered;
    }

}