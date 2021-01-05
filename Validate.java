/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Doctor;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Validate {

    private final static Scanner in = new Scanner(System.in);
    private static final String STRING = "[A-Za-z]*";

    //check user input number limit
    public static int checkInputIntLimit(int min, int max) {
        //loop until user input correct
        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine().trim());
                if (result < min || result > max) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please input number in rage [" + min + ", " + max + "]");
                System.out.print("Enter again: ");
            }
        }
    }

    //check user input string
    public static String checkInputString() {
        //loop until user input correct
        while (true) {
            String result = in.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Not empty");
                System.out.print("Enter again: ");
            } else {
                return result;
            }
        }
    }

    public static String checkInputName1() {
        while (true) {
            String result = in.nextLine().trim();
            if (result.matches(STRING)) {
                return result;
            } else {
                System.err.println("Re-input");
            }

        }
    }

    public static String checkInputName2(String oldName) {
        while (true) {
            String result = in.nextLine().trim();
            if (result.isEmpty()) {
                return oldName;
            }
            if (result.matches(STRING)) {
                return result;
            } else {
                System.err.println("Re-input");
            }

        }
    }

    //check user input int
    public static int inputIntUpdate(int min, int max, int oldAvalabi) {
        //loop until user input correct       
        while (true) {
             try {
                 String result = in.nextLine().trim();
                 if(result.isEmpty()){
                     return oldAvalabi;
                 }else if (Integer.parseInt(result) < min || Integer.parseInt(result) > max) {            
                    throw new NumberFormatException();
                }
                int resel = Integer.parseInt(result);
                return resel;
            } catch (NumberFormatException e) {
                System.err.println("Please input number integer");
                System.out.print("Enter again: ");
            }
        }
    }

    //check code exist or not
    public static boolean checkCodeExist(ArrayList<Doctor> ld, String code) {
        //check from first to last list doctor
        for (int i = 0; i < ld.size(); i++) {
            if (code.equalsIgnoreCase(ld.get(i).getCode())) {
                return false;
            }
        }
        return true;
    }

    //check doctor duplicate // check lặp lại
    public static boolean checkDuplicate(ArrayList<Doctor> ld,
            String name, String specialization, int availability) {
        //check from first to last list doctor
        for (Doctor doctor : ld) {
            if (name.equalsIgnoreCase(doctor.getName())
                    && specialization.equalsIgnoreCase(doctor.getSpecialization())
                    && availability == doctor.getAvailability()) {
                return false;
            }
        }
        return true;
    }
}
