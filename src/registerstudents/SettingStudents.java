/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registerstudents;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Administrator
 */
public class SettingStudents {

    Student student = new Student();
    View view = new View();
    Scanner sc = new Scanner(System.in);
    Validator validation = new Validator();

    public void querryStudents() {
        String response;
        do {
            ArrayList<ArrayList<Object>> list = student.getFile();
            int index;
            do {
                index = view.compactRecord(list, "para mais informações");
            } while (!validation.maxLength(index, list.size()));
            view.studentRecord(student.createObj(student.desmemberData(student.selectUser(index - 1, list))));
            System.out.println("Deseja realizar uma nova Busaca? [S/N]: ");
            response = sc.nextLine();
            if (response.equals("")) {
                response = "n";
            } else {
                response = response.toUpperCase().charAt(0) + "";
            }
        } while (response.equals("S"));
    }

    public void deleteStudents() {
        String response;
        do {
            ArrayList<ArrayList<Object>> list = student.getFile();
            int index;
            do {
                index = view.compactRecord(list, "para exclusão");
            } while (!validation.maxLength(index, list.size()));
            student.delete(index, list);
            System.out.println("Deseja Excluír? [S/N]: ");
            response = sc.nextLine().toUpperCase().charAt(0) + "";
        } while (response.equals("S") && !response.equals(""));
    }
}
