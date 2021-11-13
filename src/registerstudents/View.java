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
public class View {
    int option;
    public int systemMenu(){
        Scanner scan = new Scanner(System.in);
        System.out.println
                ("---------------------------"
                + "REGISTER STUDENTS MENU: "
                + "---------------------------"
                + "[1] - Cadastrar."
                + "[2] - Atualizar Cadastro."
                + "[3] - Buscar Cadastro."
                + "[4] - Remover Cadastro."
                + "[5] - Sair.");
        option = scan.nextInt();
        return option;
    }
    
}
