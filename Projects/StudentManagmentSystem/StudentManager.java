import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class StudentManager {
    ArrayList<Student> students = new ArrayList<>();

    public StudentManager() {
        loadFromFile();
    }

    public void addStudent(Student s) {
        students.add(s);
        saveToFile();
    }

    public void displayStudents() {

        for (Student s : students) {
            System.out.println(s.rollNo + " " + s.name + " " + s.branch);
        }

    }

    public void searchStudent(int rollNo) {
        boolean found = false;
        for (Student s : students) {
            if (s.rollNo == rollNo) {
                System.out.println(s.rollNo + " " + s.name + " " + s.branch);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Not Found");
        }
    }

    public void delete(int rollNo) {
        boolean found = false;
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).rollNo == rollNo) {
                students.remove(i);
                System.out.println("Student Deleted Successfully");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Not Found");
        }
    }

    public void update(int rollNo, String newName, String newBranch) {
        boolean found = false;
        for (Student s : students) {
            if (s.rollNo == rollNo) {
                s.name = newName;
                s.branch = newBranch;
                System.out.println("Student updated Successfully");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Not Found");
        }
    }

    public boolean studentExists(int rollNo) {
        for (Student s : students) {

            if (s.rollNo == rollNo) {
                return true;
            }

        }

        return false;
    }

    public void saveToFile() {
        try {
            FileWriter fw = new FileWriter("StudentManagmentSystem/students.txt");

            for (Student s : students) {

                fw.write(s.rollNo + "," + s.name + "," + s.branch + "\n");
            }

            fw.close();
        } catch (Exception e) {
            System.out.println("Error Saving File");
        }
    }

    public void loadFromFile() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("StudentManagmentSystem/students.txt"));

            String line;

            while ((line = br.readLine()) != null) {
                String parts[] = line.split(",");

                int rollNo = Integer.parseInt(parts[0]);
                String name = parts[1];
                String branch = parts[2];

                Student s = new Student(rollNo, name, branch);

                students.add(s);
            }

            br.close();
        } catch (Exception e) {
            System.out.println("Error Loading File");
        }
    }
}
