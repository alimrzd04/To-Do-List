import java.sql.*;

public class PostreSQL {

    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER = "postgres";
    private static final String PASSWORD = "ali12313";

    private static Connection connect() {

        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Baglanti baglandi");
        } catch (SQLException err) {
            System.out.println("Baglantida xeta bas verdi" + err.getMessage());
            err.printStackTrace();
        }
        return conn;
    }

    public static void insertUser(String task, String date ,int priority){
       String sql= "INSERT INTO java_users(task,date,priority) VALUES (?, ?, ?)";

       try (
               Connection conn = PostreSQL.connect();
               PreparedStatement stm = conn.prepareStatement(sql);
       ){
           stm.setString(1,task);
           stm.setString(2,date);
           stm.setInt(3,priority);
           stm.executeUpdate();
           System.out.println("Data insert edildi");
       }catch (SQLException error){
           error.printStackTrace();
       }
    }

    public static void getUsers(){
        String sql = "SELECT *FROM java_users";

        try (
                Connection conn = PostreSQL.connect();
                PreparedStatement stm = conn.prepareStatement(sql);
                ResultSet rs = stm.executeQuery()
        ){
           while(rs.next()) {
               int id = rs.getInt("id");
               String task = rs.getString("task");
               String date = rs.getString("date");
               int priority = rs.getInt("priority");

               System.out.println("Id:"+id + ".Task:"+task);
               System.out.println("Date:"+date);
               System.out.println("Priority:"+priority);
           }
        }catch (SQLException error){
            error.printStackTrace();
        }
    }

    public static void updateUser(int id ,String task, String date ,int priority){
        String sql= "UPDATE java_users SET task = ?, date = ?, priority = ? WHERE id = ?";

        try (
                Connection conn = PostreSQL.connect();
                PreparedStatement stm = conn.prepareStatement(sql);
        ){
            stm.setString(1,task);
            stm.setString(2,date);
            stm.setInt(3,priority);
            stm.setInt(4,id);

            int rowCount = stm.executeUpdate();

            if(rowCount>0) System.out.println("Melumatlar deyisdi!");
            else System.out.println("Melumatlar deyise bilmedi!");

            System.out.println("Data insert edildi");
        }catch (SQLException error){
            error.printStackTrace();
        }
    }

    public static void deleteUser(int id){
        String sql= "DELETE FROM java_users WHERE id = ?";
        try (
                Connection conn = PostreSQL.connect();
                PreparedStatement stm = conn.prepareStatement(sql);
        ){
            stm.setInt(1,id);
            stm.executeUpdate();
            System.out.println("Data Silindi");
        }catch (SQLException error){
            error.printStackTrace();
        }
    }
}

