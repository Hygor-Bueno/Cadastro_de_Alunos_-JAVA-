package registerstudents;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Student {

    /*
    userName= nome de usuário, fullName = nome completo, email=e-amil,genre=gênero, birth=nascimento, address=endereço
    monthlyIncome = renda mensal, cpf;
     */
    Scanner sc = new Scanner(System.in);
    Validator validation = new Validator();
    String userName, fullName, email, genre, birth, address, cpf;
    double monthlyIncome;
    int password;

    public Student(String userName, int password, String fullName, String email, String genre, String birth, String address, double monthlyIncome, String cpf) {
        this.userName = userName;
        this.password = password;
        this.fullName = fullName;
        this.email = email;
        this.genre = genre;
        this.birth = birth;
        this.address = address;
        this.monthlyIncome = monthlyIncome;
        this.cpf = cpf;
    }

    public Student() {
    }

    public void createFile(boolean value) {
        try {
            FileWriter fw = new FileWriter("record.txt", value);
            PrintWriter pw = new PrintWriter(fw);
            pw.println("User: "
                    + this.cpf + ","
                    + this.userName + ","
                    + this.password + ","
                    + this.fullName + ","
                    + this.email + ","
                    + this.genre + ","
                    + this.birth + ","
                    + this.address + ","
                    + this.monthlyIncome
            );
            pw.flush();
            pw.close();
            fw.close();
        } catch (IOException error) {
            System.out.println("Falha ao Gerar Arquivo:" + error);
        }
    }

    public void delete(int value, ArrayList arrayList) {
        for (int index = 0; index < arrayList.size(); index++) {
            if (index != value - 1) {
                ArrayList<Object> list = new ArrayList();
                ArrayList<ArrayList<Object>> listDesmember;
                list.add(arrayList.get(index));
                listDesmember = this.desmemberData(list);
                Student newFile = this.createObj(listDesmember);
                if (index == 0) {
                    newFile.createFile(false);
                } else {
                    newFile.createFile(true);
                }
            }
        }
    }

    public Student createObj(ArrayList<ArrayList<Object>> listDesmember) {
        Student newFile = new Student(
                (String) listDesmember.get(0).get(1),
                Integer.parseInt(listDesmember.get(0).get(2).toString()),
                (String) listDesmember.get(0).get(3),
                (String) listDesmember.get(0).get(4),
                (String) listDesmember.get(0).get(5),
                (String) listDesmember.get(0).get(6),
                (String) listDesmember.get(0).get(7),
                Double.parseDouble(listDesmember.get(0).get(8).toString()),
                (String) listDesmember.get(0).get(0));
        return newFile;
    }

    public ArrayList getFile() {
        String path = "record.txt";
        ArrayList<String> list = new ArrayList();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();
            while (line != null) {
                list.add(line);
                line = br.readLine();
            }
        } catch (IOException error) {
            System.out.println("Falha ao ler Arquivo:" + error);
        }
        return list;
    }

    public ArrayList selectUser(int value, ArrayList arrayList) {
        ArrayList<Object> list = new ArrayList();
        for (int index = 0; index < arrayList.size(); index++) {
            if (index == value) {
                list.add(arrayList.get(index));
            }
        }
        return list;
    }

    public ArrayList<ArrayList<Object>> desmemberData(ArrayList arrayList) {
        ArrayList<ArrayList<Object>> listUser = new ArrayList<>();
        for (int index = 0; index < arrayList.size(); index++) {
            ArrayList<Object> list = new ArrayList();
            String[] value = arrayList.get(index).toString().replaceAll("User: ", "").split(",");
            list.addAll(Arrays.asList(value));
            listUser.add(list);
        }
        return listUser;
    }

    public void getData() {

        System.out.print("Digite o Nome de Usuário: ");
        this.userName = sc.nextLine();

        System.out.print("Digite o Nome completo do Estudante: ");
        this.fullName = sc.nextLine();

        System.out.println("Esta é a senha do aluno: " + passwordGenerator());

        System.out.print("Digite o E-mail Estudante: ");
        this.email = sc.nextLine();

        System.out.print("Digite o Gênero do Estudante: ");
        this.genre = sc.nextLine();

        System.out.print("Digite a data de Nascimento do Estudante: ");
        this.birth = sc.nextLine();

        System.out.print("Digite o Endereço do Estudante: ");
        this.address = sc.nextLine();

        System.out.print("Digite o valor da renda mensal do Estudante: ");
        this.monthlyIncome = sc.nextDouble();
        sc.nextLine();

        System.out.print("Digite o CPF do Estudante: ");
        this.cpf = sc.nextLine();

        Student students = new Student(this.userName, this.password, this.fullName, this.email, this.genre, this.birth, this.address, this.monthlyIncome, this.cpf);
        View view = new View();
        view.studentRecord(students);

        System.out.println("CONFIRMAR OS DADOS DO USUÁRIO? [S/N]: ");
        String confirm = sc.nextLine();

        if (confirm.equals("s") || confirm.equals("S")) {
            students.createFile(true);
            System.out.println("CADASTRO DE USUÁRIO REALIZADO COM SUCESSO...");
        } else {
            System.out.println("CADASTRO DE USUÁRIO CANCELADO...");
        }
    }

    public int passwordGenerator() {
        int[] value = new int[3];
        for (int index = 0; index < value.length; index++) {
            do {
                System.out.print(" Digite o " + (index + 1) + "º Valor. \n ATEÇÃO: valor deve estar entre 1000 e 9999:");
                value[index] = Integer.parseInt(sc.nextLine());
            } while (!(validation.equalLength(Integer.toString(value[index]), 4) && validation.equalValue(value)));
        }
        return validation.lowerValue(value);
    }
}
