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
public class Main {

    public static void main(String[] args) {
        ArrayList<Doctor> ld = new ArrayList<>();
        ld.add(new Doctor("Doc 1", "abc", "Chỉnh hình", 3));
        ld.add(new Doctor("Doc 2", "xyz", "Phẫu thuật", 3));
        ld.add(new Doctor("Doc 3", "abcd", "Chỉnh hình", 3));
        Manager.displayDoctor(ld);
        while (true) {
            System.out.println("============Doctor Management==========");
            System.out.println("1. Add doctor");
            System.out.println("2. Update doctor");
            System.out.println("3. Delete doctor");
            System.out.println("4. Search doctor");           
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = Validate.checkInputIntLimit(1, 5);
            switch (choice) {
                case 1:
                    System.out.println("==========Add Doctor==========");
                    Manager.addDoctor(ld);
                    break;
                case 2:
                    System.out.println("==========Update Doctor========");
                    Manager.updateDoctor(ld);
                    break;
                case 3:
                    System.out.println("==========Delete Doctor=======");
                    Manager.deleteDoctor(ld);
                    break;
                case 4:
                    System.out.println("==========Search Doctor=======");
                    Manager.searchDoctor(ld);
                    break;
                case 5:                   
                    return;              
            }

        }
    }
}
