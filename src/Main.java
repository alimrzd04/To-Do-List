import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Menu();

    }

    public static void Menu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("TO-DO-LIST:");
        System.out.println("1:New task\n2:Display all task\n3:Update task\n4:Delete a task\n0:Exit");
        System.out.print("Secim edin:");
        int secim = sc.nextInt();
        sc.nextLine();

        switch (secim) {
            case 1:
                User.insert();
                break;
            case 2:
                PostreSQL.getUsers();
                break;
            case 3:
                User.update();
                break;
            case 4:
                User.delete();
                break;
            default:
                System.out.println("Sistemden cixildi...");
        }
    }
}



