package studentmanager;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManager manager = new StudentManager();

        while (true) {
            System.out.println("\n=== QUẢN LÝ SINH VIÊN ===");
            System.out.println("1. Thêm sinh viên");
            System.out.println("2. Hiển thị tất cả sinh viên");
            System.out.println("3. Tìm kiếm sinh viên theo tên");
            System.out.println("4. Cập nhật thông tin sinh viên");
            System.out.println("5. Xóa sinh viên");
            System.out.println("0. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addStudent(scanner, manager);
                    break;
                case 2:
                    manager.displayAllStudents();
                    break;
                case 3:
                    searchStudentByName(scanner, manager);
                    break;
                case 4:
                    updateStudent(scanner, manager);
                    break;
                case 5:
                    deleteStudent(scanner, manager);
                    break;
                case 0:
                    System.out.println("Thoát chương trình!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    private static void addStudent(Scanner scanner, StudentManager manager) {
        System.out.println("Thêm sinh viên mới:");
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Tên: ");
        String name = scanner.nextLine();

        System.out.print("Tuổi: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        manager.addStudent(new Student(id, name, age, email));
    }

    private static void searchStudentByName(Scanner scanner, StudentManager manager) {
        System.out.print("Nhập tên sinh viên cần tìm: ");
        String name = scanner.nextLine();
        manager.searchStudentsByName(name);
    }

    private static void updateStudent(Scanner scanner, StudentManager manager) {
        System.out.print("Nhập ID sinh viên cần cập nhật: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Tên mới: ");
        String newName = scanner.nextLine();

        System.out.print("Tuổi mới: ");
        int newAge = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Email mới: ");
        String newEmail = scanner.nextLine();

        manager.updateStudent(id, new Student(id, newName, newAge, newEmail));
    }

    private static void deleteStudent(Scanner scanner, StudentManager manager) {
        System.out.print("Nhập ID sinh viên cần xóa: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        manager.deleteStudent(id);
    }
}




