package registerstudents;

public class RegisterStudents {
    public static void main(String[] args) {
      
      Student student = new Student("ana_kha",1234,"Ana Catarina", "kha@gmail.com","Feminino","24/12/1997","Rua Azaleia 155. Vargem Grande - SP",1200,"12345678989");
      //student.createFile();
      //student.getFile();
      student.selectUser(2, student.getFile());
      //student.desmemberData(student.getFile());
      //System.out.println(student.getFile());
      //student.fileControll(true);
      /*
        String userName,fullName, email,genre, birth, address;
        double monthlyIncome;
        int cpf;
      */
    }  
}
