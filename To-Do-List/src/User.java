import java.util.Scanner;

public class User extends PostreSQL{

    public static void insert(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Tapşırıq daxil edin: ");
        String task = scanner.nextLine();

        System.out.print("Tarixi daxil edin");
        String date = scanner.nextLine();

        System.out.print("Prioriteti daxil edin: ");
        int priority = scanner.nextInt();

        insertUser(task, date, priority);

        scanner.close();
    }

    public static void update(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Deyistirmek istediyiniz task-in id-ni qeyd edin: ");
        int id = scanner.nextInt();

        System.out.print("Yeni tapşırıq daxil edin: ");
        scanner.nextLine();
        String task = scanner.nextLine();

        System.out.print("Yeni tarixi daxil edin:");
        String date = scanner.nextLine();

        System.out.print("Yeni prioriteti daxil edin: ");
        int priority = scanner.nextInt();

        updateUser(id,task, date, priority);

        scanner.close();
    }

    public static void delete() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Silmek istediyiniz id-ni qeyd edin: ");
        int id = scanner.nextInt();

        deleteUser(id);
        scanner.close();
    }
}
