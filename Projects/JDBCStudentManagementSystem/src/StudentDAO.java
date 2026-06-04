import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StudentDAO {

    public void addStudent(int id, String name, int age) {

        try {

            Connection con = DBConnection.getConnection();

            String query = "INSERT INTO students VALUES (?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setInt(3, age);

            ps.executeUpdate();

            System.out.println("Student Added Successfully");

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void displayStudents() {

        try {

            Connection con = DBConnection.getConnection();

            String query = "SELECT * FROM students";

            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                System.out.println(
                        rs.getInt("id") + " " +
                                rs.getString("name") + " " +
                                rs.getInt("age"));
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void searchStudent(int id) {

        try {

            Connection con = DBConnection.getConnection();
            String query = "SELECT * FROM students WHERE id = ?";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                System.out.println(
                        rs.getInt("id") + " " +
                                rs.getString("name") + " " +
                                rs.getInt("age"));

            } else {
                System.out.println("Student Not Found");
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateStudent(int id, String name, int age) {

        try {

            Connection con = DBConnection.getConnection();

            String query = "UPDATE students SET name = ?, age = ? WHERE id = ?";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, name);
            ps.setInt(2, age);
            ps.setInt(3, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Student Updated Successfully");
            } else {
                System.out.println("Student Not Found");
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteStudent(int id) {

        try {

            Connection con = DBConnection.getConnection();

            String query = "DELETE FROM students WHERE id = ?";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Student Deleted Successfully");
            } else {
                System.out.println("Student Not Found");
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}