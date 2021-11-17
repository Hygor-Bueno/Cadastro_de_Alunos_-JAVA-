/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registerstudents;

import java.util.Scanner;

/**
 *
 * @author Administrator
 */
public class Router {

    Student student = new Student();
    
    public void main(int index) {
        switch (index) {
            case 1:
                student.getData();
                break;
            case 2:
                System.out.println(" Opção Nº " + index + ".\n Foi Selecionada!");
                break;
            case 3:
                System.out.println(" Opção Nº " + index + ".\n Foi Selecionada!");
                break;
            case 4:
                System.out.println(" Opção Nº " + index + ".\n Foi Selecionada!");
                break;
            case 5:
                System.out.println(" Opção Nº " + index + ".\n Foi Selecionada!");
                break;
            default:
                System.out.println("Desculpe Opção inválida!");
                break;
        }
    }

    
}
