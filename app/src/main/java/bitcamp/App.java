package bitcamp;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BookClub bookClub = new BookClub();

        while (true) {
            System.out.println("=== 독서 모임 프로그램 ===");
            System.out.println("1. 로그인");
            System.out.println("2. 회원가입");
            System.out.println("3. 종료");
            System.out.print("선택: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    bookClub.login();
                    break;
                case 2:
                    System.out.println("회원가입 유형을 선택하세요:");
                    System.out.println("1. 일반 회원가입");
                    System.out.println("2. 관리자 회원가입");
                    System.out.print("선택: ");
                    int registerChoice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    if (registerChoice == 1) {
                        bookClub.registerMember();
                    } else if (registerChoice == 2) {
                        bookClub.registerAdmin();
                    } else {
                        System.out.println("잘못된 입력입니다. 다시 시도하세요.");
                    }
                    break;
                case 3:
                    System.out.println("프로그램을 종료합니다.");
                    System.exit(0);
                default:
                    System.out.println("잘못된 입력입니다. 다시 시도하세요.");
            }
        }
    }
}