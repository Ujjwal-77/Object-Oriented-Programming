import java.util.ArrayList;
import java.util.List;


abstract class Patient {
    private String patientId;
    private String name;
    private int age;
    protected double baseCharge = 500; 

    
    public Patient(String patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }

    
    public String getPatientId() {
        return patientId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public abstract double calculateBill();

    
    public void getPatientDetails() {
        System.out.println("Patient ID: " + patientId);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}


interface MedicalRecord {
    void addRecord(String record);

    void viewRecords();
}


class InPatient extends Patient implements MedicalRecord {
    private int daysAdmitted;
    private double dailyCharge = 1000; 
    private List<String> medicalHistory = new ArrayList<>();

    public InPatient(String patientId, String name, int age, int daysAdmitted) {
        super(patientId, name, age);
        this.daysAdmitted = daysAdmitted;
    }

    
    @Override
    public double calculateBill() {
        return baseCharge + (daysAdmitted * dailyCharge);
    }

    
    @Override
    public void addRecord(String record) {
        medicalHistory.add(record);
    }

    @Override
    public void viewRecords() {
        System.out.println("Medical Records for " + getName() + ":");
        for (String record : medicalHistory) {
            System.out.println("- " + record);
        }
    }
}


class OutPatient extends Patient implements MedicalRecord {
    private double consultationFee = 300; 
    private List<String> medicalHistory = new ArrayList<>();

    public OutPatient(String patientId, String name, int age) {
        super(patientId, name, age);
    }

   
    @Override
    public double calculateBill() {
        return baseCharge + consultationFee;
    }

    
    @Override
    public void addRecord(String record) {
        medicalHistory.add(record);
    }

    @Override
    public void viewRecords() {
        System.out.println("Medical Records for " + getName() + ":");
        for (String record : medicalHistory) {
            System.out.println("- " + record);
        }
    }
}


public class HospitalManagement {
    public static void main(String[] args) {
        
        List<Patient> patients = new ArrayList<>();

        
        InPatient patient1 = new InPatient("P101", "John Doe", 45, 5);
        OutPatient patient2 = new OutPatient("P202", "Jane Smith", 30);

        
        patients.add(patient1);
        patients.add(patient2);

        
        patient1.addRecord("Diagnosed with Pneumonia");
        patient1.addRecord("Prescribed Antibiotics");

        patient2.addRecord("Routine Checkup");
        patient2.addRecord("Blood Test Done");

        
        for (Patient patient : patients) {
            patient.getPatientDetails();
            System.out.println("Total Bill: $" + patient.calculateBill());

            
            if (patient instanceof MedicalRecord) {
                MedicalRecord medicalPatient = (MedicalRecord) patient;
                medicalPatient.viewRecords();
            }

            System.out.println("----------------------------");
        }
    }
}
