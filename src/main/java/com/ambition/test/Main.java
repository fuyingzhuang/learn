package com.ambition.test;

import java.io.*;
import java.util.*;

class Student implements Serializable {
    private String id;
    private String name;
    private int age;
    private String grade;
    private String className;
    private String major;
    private String dormitory;

    public Student(String id, String name, int age, String grade, String className, String major, String dormitory) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.className = className;
        this.major = major;
        this.dormitory = dormitory;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGrade() {
        return grade;
    }

    public String getClassName() {
        return className;
    }

    public String getMajor() {
        return major;
    }

    public String getDormitory() {
        return dormitory;
    }
}

class Admin implements Serializable {
    private String id;
    private String username;
    private String password;

    public Admin(String id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}


 class StudentManagementSystem {
    private List<Student> students;
    private List<Admin> admins;
    private Scanner scanner;

    public StudentManagementSystem() {
        students = new ArrayList<>();
        admins = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void start() {
        loadAdminsFromFile(); // 从文件加载管理员信息

        boolean exit = false;
        while (!exit) {
            System.out.println("欢迎使用学生信息管理系统");
            System.out.println("1. 登录");
            System.out.println("2. 注册");
            System.out.println("3. 退出");
            System.out.print("请选择操作：");

            int choice = scanner.nextInt();
            scanner.nextLine(); // 清空输入缓冲区

            switch (choice) {
                case 1:
                    login();
                    break;
                case 2:
                    register();
                    break;
                case 3:
                    exit = true;
                    break;
                default:
                    System.out.println("无效的选择，请重新输入！");
                    break;
            }
        }
    }

    private void login() {
        System.out.print("请输入用户名：");
        String username = scanner.nextLine();
        System.out.print("请输入密码：");
        String password = scanner.nextLine();

        Admin admin = findAdminByUsername(username);
        if (admin != null && admin.getPassword().equals(password)) {
            System.out.println("登录成功！");
            showAdminMenu();
        } else {
            System.out.println("用户名或密码错误！");
        }
    }

    private void register() {
        System.out.print("请输入管理员ID：");
        String id = scanner.nextLine();
        System.out.print("请输入用户名：");
        String username = scanner.nextLine();
        System.out.print("请输入密码：");
        String password = scanner.nextLine();

        Admin admin = new Admin(id, username, password);
        admins.add(admin);
        saveAdminsToFile(); // 将管理员信息保存到文件中
        System.out.println("注册成功！");
    }

    private void showAdminMenu() {
        boolean logout = false;
        while (!logout) {
            System.out.println("\n管理员菜单");
            System.out.println("1. 新增学生信息");
            System.out.println("2. 查询学生信息");
            System.out.println("3. 修改学生信息");
            System.out.println("4. 删除学生信息");
            System.out.println("5. 查看所有学生信息");
            System.out.println("6. 注销登录");
            System.out.print("请选择操作：");

            int choice = scanner.nextInt();
            scanner.nextLine(); // 清空输入缓冲区

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    searchStudent();
                    break;
                case 3:
                    updateStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    displayAllStudents();
                    break;
                case 6:
                    logout = true;
                    break;
                default:
                    System.out.println("无效的选择，请重新输入！");
                    break;
            }
        }
    }

    private void addStudent() {
        System.out.print("请输入学号：");
        String id = scanner.nextLine();
        System.out.print("请输入姓名：");
        String name = scanner.nextLine();
        System.out.print("请输入年龄：");
        int age = scanner.nextInt();
        scanner.nextLine(); // 清空输入缓冲区
        System.out.print("请输入年级：");
        String grade = scanner.nextLine();
        System.out.print("请输入班级：");
        String className = scanner.nextLine();
        System.out.print("请输入专业：");
        String major = scanner.nextLine();
        System.out.print("请输入宿舍号：");
        String dormitory = scanner.nextLine();

        Student student = new Student(id, name, age, grade, className, major, dormitory);
        students.add(student);
        System.out.println("学生信息添加成功！");
    }

    private void searchStudent() {
        System.out.println("请选择查询方式：");
        System.out.println("1. 根据学号查询");
        System.out.println("2. 根据姓名查询");
        System.out.print("请选择操作：");

        int choice = scanner.nextInt();
        scanner.nextLine(); // 清空输入缓冲区

        switch (choice) {
            case 1:
                System.out.print("请输入学号：");
                String id = scanner.nextLine();
                Student studentById = findStudentById(id);
                if (studentById != null) {
                    displayStudentInfo(studentById);
                } else {
                    System.out.println("未找到该学生！");
                }
                break;
            case 2:
                System.out.print("请输入姓名：");
                String name = scanner.nextLine();
                List<Student> studentsByName = findStudentsByName(name);
                if (!studentsByName.isEmpty()) {
                    for (Student student : studentsByName) {
                        displayStudentInfo(student);
                    }
                } else {
                    System.out.println("未找到该学生！");
                }
                break;
            default:
                System.out.println("无效的选择，请重新输入！");
                break;
        }
    }

    private void updateStudent() {
        System.out.print("请输入学号：");
        String id = scanner.nextLine();
        Student student = findStudentById(id);
        if (student != null) {
            System.out.print("请输入新的姓名（原姓名：" + student.getName() + "）：");
            String name = scanner.nextLine();
            System.out.print("请输入新的年龄（原年龄：" + student.getAge() + "）：");
            int age = scanner.nextInt();
            scanner.nextLine(); // 清空输入缓冲区
            System.out.print("请输入新的年级（原年级：" + student.getGrade() + "）：");
            String grade = scanner.nextLine();
            System.out.print("请输入新的班级（原班级：" + student.getClassName() + "）：");
            String className = scanner.nextLine();
            System.out.print("请输入新的专业（原专业：" + student.getMajor() + "）：");
            String major = scanner.nextLine();
            System.out.print("请输入新的宿舍号（原宿舍号：" + student.getDormitory() + "）：");
            String dormitory = scanner.nextLine();

            student = new Student(id, name, age, grade, className, major, dormitory);
            students.remove(student);
            students.add(student);
            System.out.println("学生信息修改成功！");
        } else {
            System.out.println("未找到该学生！");
        }
    }

    private void deleteStudent() {
        System.out.print("请输入学号：");
        String id = scanner.nextLine();
        Student student = findStudentById(id);
        if (student != null) {
            students.remove(student);
            System.out.println("学生信息删除成功！");
        } else {
            System.out.println("未找到该学生！");
        }
    }

    private void displayStudentInfo(Student student) {
        System.out.println("\n学生信息");
        System.out.println("学号：" + student.getId());
        System.out.println("姓名：" + student.getName());
        System.out.println("年龄：" + student.getAge());
        System.out.println("年级：" + student.getGrade());
        System.out.println("班级：" + student.getClassName());
        System.out.println("专业：" + student.getMajor());
        System.out.println("宿舍号：" + student.getDormitory());
    }

    private void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("暂无学生信息！");
            return;
        }
        System.out.println("\n所有学生信息：");
        for (Student student : students) {
            displayStudentInfo(student);
        }
    }

    private Admin findAdminByUsername(String username) {
        for (Admin admin : admins) {
            if (admin.getUsername().equals(username)) {
                return admin;
            }
        }
        return null;
    }

    private void loadAdminsFromFile() {
        try {
            File file = new File("admin.txt");
            if (file.exists()) {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(",");
                    Admin admin = new Admin(parts[0], parts[1], parts[2]);
                    admins.add(admin);
                }
                reader.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveAdminsToFile() {
        try {
            File file = new File("admin.txt");
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            for (Admin admin : admins) {
                writer.write(admin.getId() + "," + admin.getUsername() + "," + admin.getPassword());
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Student findStudentById(String id) {
        for (Student student : students) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        return null;
    }

    private List<Student> findStudentsByName(String name) {
        List<Student> result = new ArrayList<>();
        for (Student student : students) {
            if (student.getName().equals(name)) {
                result.add(student);
            }
        }
        return result;
    }
}

public class Main {
    public static void main(String[] args) {
        StudentManagementSystem system = new StudentManagementSystem();
        system.start();
    }
}

