package bitcamp;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BookClub bookClub = new BookClub();

        while (true) {
            System.out.println("\033[0;34m―――――――――――――――――――――――――――――――――――――\033[0m");
            System.out.println("🥔📖 \033[0;33m건지 감자껍질파이 북클럽\033[0m 📖🥔");
            System.out.println("\033[0;34m―――――――――――――――――――――――――――――――――――――\033[0m");
            System.out.println("\033[0;33m ①\033[0m 로그인");
            System.out.println("\033[0;33m ②\033[0m 회원가입");
            System.out.println("\033[0;33m ③\033[0m 종료");
            System.out.println("\033[0;34m―――――――――――――――――――――――――――――――――――――\033[0m");
            System.out.print("▶️ ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    bookClub.login();
                    break;
                case 2:
                    System.out.println("\033[0;34m―――――――――――――――――――――――――――――――――――――\033[0m");
                    System.out.println("    ⭐ \033[0;33m회원가입 유형 선택하기\033[0m ⭐    ");
                    System.out.println("\033[0;34m―――――――――――――――――――――――――――――――――――――\033[0m");
                    System.out.println("\033[0;33m ①\033[0m 일반 회원가입");
                    System.out.println("\033[0;33m ②\033[0m 관리자 회원가입");
                    System.out.println("\033[0;34m―――――――――――――――――――――――――――――――――――――\033[0m");
                    System.out.print("▶️ ");
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