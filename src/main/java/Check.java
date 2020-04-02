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
            if (patient.getName().equals(name) && patient.getSurname().equals(surname)) {
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

    public Patient findPatient(String pesel) {
        Patient patientTemp = null;

        for (Patient patient : patientList) {
            if (patient.getPesel().equals(pesel)) {
                patientTemp = patient;
            }
        }

        return patientTemp;
    }

    public Patient findPatient(String name, String surname) {
        Patient patientTemp = null;

        for (Patient patient : patientList) {
            if (patient.getName().equals(name) && patient.getSurname().equals(surname)) {
                patientTemp = patient;
            }
        }
        return patientTemp;
    }

}
