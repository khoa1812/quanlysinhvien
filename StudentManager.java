package studentmanager;

public class StudentManager {
    private Student[] students = new Student[100];
    private int studentCount = 0;

    public StudentManager() {
        students[studentCount++] = new Student(1, "Nguyễn Văn A", 18, "nguyena@gmail.com");
        students[studentCount++] = new Student(2, "Trần Thị B", 19, "tranb@gmail.com");
        students[studentCount++] = new Student(3, "Hoàng Văn C", 22, "hoangc@gmail.com");
        students[studentCount++] = new Student(4, "Lê Thị D", 21, "led@gmail.com");
    }

    public void addStudent(Student student) {
        if (studentCount < students.length) {
            students[studentCount] = student;
            studentCount++;
        } else {
            System.out.println("Danh sách đầy. Không thể thêm sinh viên mới.");
        }
    }

    public void displayAllStudents() {
        for (int i = 0; i < studentCount; i++) {
            System.out.println(students[i]);
        }
    }

    public void searchStudentsByName(String name) {
        boolean found = false;
        for (int i = 0; i < studentCount; i++) {
            if (students[i].getName().equalsIgnoreCase(name)) {
                System.out.println(students[i]);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy sinh viên có tên: " + name);
        }
    }

    public void updateStudent(int id, Student updatedStudent) {
        for (int i = 0; i < studentCount; i++) {
            if (students[i].getId() == id) {
                students[i] = updatedStudent;
                System.out.println("Cập nhật thông tin sinh viên thành công.");
                return;
            }
        }
        System.out.println("Không tìm thấy sinh viên với ID: " + id);
    }

    public void deleteStudent(int id) {
        for (int i = 0; i < studentCount; i++) {
            if (students[i].getId() == id) {
                for (int j = i; j < studentCount - 1; j++) {
                    students[j] = students[j + 1];
                }
                studentCount--;
                System.out.println("Xóa sinh viên thành công.");
                return;
            }
        }
        System.out.println("Không tìm thấy sinh viên với ID: " + id);
    }
}


