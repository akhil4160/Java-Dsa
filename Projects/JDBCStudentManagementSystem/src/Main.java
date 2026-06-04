import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentDAO dao = new StudentDAO();

        while (true) {

            System.out.println("\n===== STUDENT MENU =====");
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");

            System.out.print("Enter Choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();

                    dao.addStudent(id, name, age);
                    break;

                case 2:
                    dao.displayStudents();
                    break;

                case 3:
                    System.out.print("Enter ID: ");
                    id = sc.nextInt();

                    dao.searchStudent(id);
                    break;

                case 4:
                    System.out.print("Enter ID: ");
                    id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter New Name: ");
                    name = sc.nextLine();

                    System.out.print("Enter New Age: ");
                    age = sc.nextInt();

                    dao.updateStudent(id, name, age);
                    break;

                case 5:
                    System.out.print("Enter ID: ");
                    id = sc.nextInt();

                    dao.deleteStudent(id);
                    break;

                case 6:
                    System.out.println("Thank You!");
                    return;

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}