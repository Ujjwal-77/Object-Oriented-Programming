import java.util.ArrayList;
import java.util.List;

class Patient {
    private String name;
    private List<Doctor> doctors;

    public Patient(String name) {
        this.name = name;
        this.doctors = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addDoctor(Doctor doctor) {
        if (!doctors.contains(doctor)) {
            doctors.add(doctor);
            doctor.addPatient(this);  // Establish bidirectional association
        }
    }

    public void displayDoctors() {
        System.out.println("Patient: " + name + " | Consulted Doctors:");
        for (Doctor doctor : doctors) {
            System.out.println(" - " + doctor.getName());
        }
    }
}

class Doctor {
    private String name;
    private String specialization;
    private List<Patient> patients;

    public Doctor(String name, String specialization) {
        this.name = name;
        this.specialization = specialization;
        this.patients = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getSpecialization() { // Getter method for specialization
        return specialization;
    }

    public void addPatient(Patient patient) {
        if (!patients.contains(patient)) {
            patients.add(patient);
            patient.addDoctor(this);  // Establish bidirectional association
        }
    }

    public void consult(Patient patient) {
        if (!patients.contains(patient)) {
            addPatient(patient);
        }
        System.out.println("Doctor " + name + " (" + specialization + ") is consulting patient " + patient.getName());
    }

    public void displayPatients() {
        System.out.println("Doctor: " + name + " (" + specialization + ") | Patients:");
        for (Patient patient : patients) {
            System.out.println(" - " + patient.getName());
        }
    }
}

class Hospital {
    private String name;
    private List<Doctor> doctors;
    private List<Patient> patients;

    public Hospital(String name) {
        this.name = name;
        this.doctors = new ArrayList<>();
        this.patients = new ArrayList<>();
    }

    public void addDoctor(Doctor doctor) {
        if (!doctors.contains(doctor)) {
            doctors.add(doctor);
        }
    }

    public void addPatient(Patient patient) {
        if (!patients.contains(patient)) {
            patients.add(patient);
        }
    }

    public void displayHospitalDetails() {
        System.out.println("Hospital: " + name);
        System.out.println("Doctors:");
        for (Doctor doctor : doctors) {
            System.out.println(" - " + doctor.getName() + " (" + doctor.getSpecialization() + ")");  // Use getter
        }

        System.out.println("Patients:");
        for (Patient patient : patients) {
            System.out.println(" - " + patient.getName());
        }
    }
}

public class HospitalManagementSystem {
    public static void main(String[] args) {
        Hospital hospital = new Hospital("City Hospital");

        Doctor doctor1 = new Doctor("Dr. John", "Cardiology");
        Doctor doctor2 = new Doctor("Dr. Emily", "Neurology");
        Doctor doctor3 = new Doctor("Dr. David", "Orthopedics");

        Patient patient1 = new Patient("Alice");
        Patient patient2 = new Patient("Bob");
        Patient patient3 = new Patient("Charlie");

        hospital.addDoctor(doctor1);
        hospital.addDoctor(doctor2);
        hospital.addDoctor(doctor3);

        hospital.addPatient(patient1);
        hospital.addPatient(patient2);
        hospital.addPatient(patient3);

        doctor1.consult(patient1);
        doctor1.consult(patient2);
        doctor2.consult(patient1);
        doctor3.consult(patient3);

        System.out.println();
        hospital.displayHospitalDetails();
        System.out.println();
        doctor1.displayPatients();
        doctor2.displayPatients();
        doctor3.displayPatients();
        System.out.println();
        patient1.displayDoctors();
        patient2.displayDoctors();
        patient3.displayDoctors();
    }
}
