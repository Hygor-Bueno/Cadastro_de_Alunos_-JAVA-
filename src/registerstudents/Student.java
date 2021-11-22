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

    /* userName= nome de usuário, fullName = nome completo, email=e-amil,genre=gênero, birth=nascimento, address=endereço, monthlyIncome = renda mensal, cpf; */
    View view = new View();
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
        int cont = 0;
        if (value - 1 == 0) {
            cont++;
        }
        for (int index = 0; index < arrayList.size(); index++) {
            if (index != value - 1) {
                ArrayList<Object> list = new ArrayList();
                ArrayList<ArrayList<Object>> listDesmember;
                list.add(arrayList.get(index));
                listDesmember = this.desmemberData(list);
                Student newFile = this.createObj(listDesmember);
                if (index == cont) {
                    newFile.createFile(false);
                } else {
                    newFile.createFile(true);
                }
            }
        }
        System.out.println("***********************************");
        System.out.println("Excluído com sucesso!");
    }

    public void update(ArrayList<ArrayList<Object>> listDesmember) {
        for (int index = 0; index < listDesmember.size(); index++) {
            Student newFile = new Student(
                    (String) listDesmember.get(index).get(1),
                    Integer.parseInt(listDesmember.get(index).get(2).toString()),
                    (String) listDesmember.get(index).get(3),
                    (String) listDesmember.get(index).get(4),
                    (String) listDesmember.get(index).get(5),
                    (String) listDesmember.get(index).get(6),
                    (String) listDesmember.get(index).get(7),
                    Double.parseDouble(listDesmember.get(0).get(8).toString()),
                    (String) listDesmember.get(index).get(0));
            if (index == 02
                    ) {
                newFile.createFile(false);
            } else {
                newFile.createFile(true);
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
}
