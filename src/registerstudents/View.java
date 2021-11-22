package registerstudents;

import java.util.ArrayList;
import java.util.Scanner;

public class View {

    String menu = "--------------------------- \n"
            + "REGISTER STUDENTS MENU: \n"
            + "--------------------------- \n"
            + "[1] - Cadastrar. \n"
            + "[2] - Atualizar Cadastro. \n"
            + "[3] - Buscar Cadastros. \n"
            + "[4] - Remover Cadastro. \n"
            + "[5] - Sair. \n";
    int option;
    String aux;
    Scanner sc = new Scanner(System.in);

    public int systemMenu() {
        System.out.println(menu);
        do {
            aux = sc.nextLine();
        } while (checkLetters(aux) || aux.equals(""));
        option = Integer.parseInt(aux);
        return option;
    }

    public boolean checkLetters(String str) {
        boolean response=false;
        String aux;
        for (int index=0;index < str.length(); index++) {
            boolean res;
            aux =str.charAt(index)+"";
            res = aux.matches("[^0-9]+");
            if(res){
                response = true;
            }
        }
        if (response) {
            System.out.println(this.clean(2));
            System.out.println("Desculpe Entrada Inválida, Digite apenas números... \n" + menu);
        }
        return response;
    }

    public boolean checkLetters(String str, String value) {
         boolean response=false;
        String aux;
        for (int index=0;index < str.length(); index++) {
            boolean res;
            aux =str.charAt(index)+"";
            res = aux.matches("[^0-9]+");
            if(res){
                response = true;
            }
        }
        if (response) {
            System.out.println(this.clean(2));
            System.out.println("Desculpe Entrada Inválida, Digite apenas " + value + "...");
        }
        return response;
    }

    public int compactRecord(ArrayList students,String text) {
        String value;
        System.out.println(this.clean(2)
                + "-------------------------------------------------------- \n"
                + " Lista de Estudantes: \n"
                + "-------------------------------------------------------- \n");
        Student desmember = new Student();
        ArrayList<ArrayList<Object>> newList = desmember.desmemberData(students);
        for (int index = 0; index < newList.size(); index++) {
            System.out.println("[" + (index + 1) + "] " + "CPF: " + newList.get(index).get(0) + " - " + "NOME: " + newList.get(index).get(3));
        }
        do {
            System.out.println("");
            System.out.print("Selecione um Estudante pelo indice "+text+": ");
            value = sc.nextLine();
        } while (this.checkLetters(value, "Números") || value.equals(""));
        return Integer.parseInt(value);
    }

    public void studentRecord(Student students) {
        System.out.println(
                this.clean(20)
                + "-------------------------------------------------------- \n"
                + " Registro do Estudante: " + this.splitStringName(students.fullName) + "\n"
                + " -------------------------------------------------------- \n"
                + " Usuário: " + students.userName + "\n"
                + " Senha: " + students.password + "\n"
                + " Nome Completo: " + students.fullName + "\n"
                + " E-Mail: " + students.email + "\n"
                + " Gênero: " + students.genre + "\n"
                + " Data de Nascimento: " + students.birth + "\n"
                + " Endereço: " + students.address + "\n"
                + " Renda Mensal: " + students.monthlyIncome + "\n"
                + " CPF: " + students.cpf + "\n");
    }

    public String splitStringName(String fullName) {
        String[] name = fullName.split(" ");
        return name[0] + " " + name[name.length - 1];
    }

    public String clean(int value) {
        String clean = "";
        for (int index = 0; index < value; index++) {
            clean += "\n ";
        }
        return clean;
    }
}
