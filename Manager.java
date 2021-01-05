/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Doctor;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class Manager {

    //allow user add doctor
    public static void addDoctor(ArrayList<Doctor> ld) {
        System.out.print("Enter code: ");
        String code = Validate.checkInputString();
        //check code exist or not
        while (!Validate.checkCodeExist(ld, code)) {
            //check code đã tồn tại hay chưa
            System.out.println("Code already exists.");
            return;
        }
        System.out.print("Enter name: ");
        String name = Validate.checkInputName1();
        System.out.print("Enter specialization: ");//chuyên môn
        String specialization = Validate.checkInputString();
        System.out.print("Enter availability: ");// hiệu lực
        int availability = Validate.checkInputIntLimit(1, 100);
        //check worker duplicate  check giống nhau ! phủ định
        if (Validate.checkDuplicate(ld, name, specialization, availability)) {
            System.err.println("Duplicate.");
            return;
        }
        ld.add(new Doctor(code, name, specialization, availability));
        System.err.println("Add successful.");
    }

    //allow user update doctor
    public static void updateDoctor(ArrayList<Doctor> ld) {
        System.out.print("Enter code: ");
        String code = Validate.checkInputString();
        //check code exist or not
        if (Validate.checkCodeExist(ld, code)) {
            // không tồn tại 
            System.err.println("Not found doctor");
            return;
        }
        Doctor doctor = getDoctorByCode(ld, code);
        System.out.print("Enter name: ");
        String name = Validate.checkInputName2(doctor.getName());
        System.out.print("Enter specialization: ");
        String specialization = Validate.checkInputName2(doctor.getSpecialization());
        System.out.print("Enter availability: ");
        int availability = Validate.inputIntUpdate(0, 100, doctor.getAvailability());
        //check user change infomation or not
        // tồn tại rồi thì k change
        if (!Validate.checkDuplicate(ld, name, specialization, availability)) {
            System.err.println("No change");
            return;
        }
        doctor.setName(name);
        doctor.setSpecialization(specialization);
        doctor.setAvailability(availability);
        System.err.println("Update successful");
    }

    //allow user delete doctor
    public static void deleteDoctor(ArrayList<Doctor> ld) {
        System.out.print("Enter code: ");
        String code = Validate.checkInputString();
        Doctor doctor = getDoctorByCode(ld, code);
        if (doctor == null) {
            System.err.println("Not found doctor.");
            return;
        } else {
            ld.remove(doctor);
        }
        System.err.println("Delete successful.");
    }

    //allow user search doctor
    public static void searchDoctor(ArrayList<Doctor> ld) {
        System.out.print("Enter name: ");
        String name = Validate.checkInputName1();
        ArrayList<Doctor> listFoundByName = listFoundByName(ld, name);
        if (listFoundByName.isEmpty()) {
            System.err.println("List empty.");
        } else {
            System.out.printf("%-10s%-15s%-25s%-20s\n", "Code", "Name",
                    "Specialization", "Availability");
            for (Doctor doctor : listFoundByName) {
                System.out.printf("%-10s%-15s%-25s%-20d\n", doctor.getCode(),
                        doctor.getName(), doctor.getSpecialization(),
                        doctor.getAvailability());
            }
        }
    }

    //get docter by code
    public static Doctor getDoctorByCode(ArrayList<Doctor> ld, String code) {
        for (Doctor doctor : ld) {
            if (doctor.getCode().equalsIgnoreCase(code)) {
                return doctor;
            }
        }
        return null;
    }

    //get list found by name
    public static ArrayList<Doctor> listFoundByName(ArrayList<Doctor> ld, String name) {
        ArrayList<Doctor> listFoundByName = new ArrayList<>();
        for (Doctor doctor : ld) {
            if (doctor.getName().contains(name)) {
                listFoundByName.add(doctor);
            }
        }
        return listFoundByName;
    }

    static void displayDoctor(ArrayList<Doctor> le) {
        // if array list = 0 list empty
        if (le.isEmpty()) {
            System.err.println("List Expenses empty");
            return;
        }

        System.out.printf("%-10s%-15s%-25s%-20s\n", "Code", "Name", "specialization", "availability");
        //loop from 0 - size array list -1
        for (int i = 0; i < le.size(); i++) {
            //print detailed expense
            System.out.printf("%-10s%-15s%-25s%-20d\n", le.get(i).getCode(), le.get(i).getName(),
                    le.get(i).getSpecialization(), le.get(i).getAvailability());
        }
    }
}
