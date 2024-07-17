package bitcamp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookClub {
    private List<Member> members;
    private List<Admin> admins;
    private List<Book> books;
    private List<Book> pendingBooks;
    private Scanner scanner;

    public BookClub() {
        this.members = new ArrayList<>();
        this.admins = new ArrayList<>();
        this.books = new ArrayList<>();
        this.pendingBooks = new ArrayList<>();
        this.scanner = new Scanner(System.in);
        // 기본 관리자 계정 추가
        this.admins.add(new Admin("book", "book@gmail.com", "1111"));
        // 기본 회원 계정 추가
        this.members.add(new Member("apple", "apple@gmail.com", "1111"));
        this.members.add(new Member("cherry", "cherry@gmail.com", "1111"));
        this.members.add(new Member("olive", "olive@gmail.com", "1111"));
        this.members.add(new Member("plum", "plum@gmail.com", "1111"));
        this.members.add(new Member("berry", "berry@gmail.com", "1111"));
        // 책 더미 데이터

        // 책 더미 데이터 추가
        this.books.add(new Book("라스트 젤리 샷           ", "청예             ", 2023, 16800));
        this.books.get(0).setReview("인간과 비인간의 경계");

        this.books.add(new Book("스밀라의 눈에 대한 감각  ", "페터 회          ", 1992, 16000));
        this.books.get(1).setReview("그린란드의 눈처럼 차갑고 아름다운 이야기");

        this.books.add(new Book("우리는 언제나 성에 살았다", "셜리 잭슨        ", 1962, 11800));
        this.books.get(2).setReview("팽창하는 집착과 광기");

        this.books.add(new Book("브람스를 좋아하세요...   ", "프랑수아즈 사강", 1959, 8500 ));
        this.books.get(3).setReview("이제 이만하면 충분해");

        this.books.add(new Book("미키7                    ", "에드워드 애슈턴", 2022, 17000));
        this.books.get(4).setReview("자아와 존재에 대한 짧은 고찰");

        this.books.add(new Book("돌이킬 수 있는           ", "문목하           ", 2018, 14800));
        this.books.get(5).setReview("왜겠어요");

        this.books.add(new Book("구의 증명                ", "최진영           ", 2015, 12000));
        this.books.get(6).setReview("디스토피아적 사랑");

        this.books.add(new Book("소유냐 존재냐            ", "에리히 프롬      ", 1976, 13500));
        this.books.get(7).setReview("소유하지 않을 때 더 값진 존재");

        this.books.add(new Book("데미안                   ", "헤르만 헤세      ", 1919, 8000 ));
        this.books.get(8).setReview("깨고 싶지 않은 세계");

        this.books.add(new Book("트로피컬 나이트          ", "조예은           ", 2022, 15000));
        this.books.get(9).setReview("매혹적인 두려움");

    }

    public void login() {
        System.out.println("\033[0;34m―――――――――――――――――――――――――――――――――――――\033[0m");
        System.out.println("     ⭐ \033[0;33m로그인 유형 선택하기\033[0m ⭐     ");
        System.out.println("\033[0;34m―――――――――――――――――――――――――――――――――――――\033[0m");
        System.out.println("\u001B[0;33m ①\u001B[0m 관리자 로그인");
        System.out.println("\u001B[0;33m ②\u001B[0m 회원 로그인");
        System.out.println("\033[0;34m―――――――――――――――――――――――――――――――――――――\033[0m");
        System.out.print("▶️ ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                loginAdmin();
                break;
            case 2:
                loginMember();
                break;
            default:
                System.out.println("잘못된 입력입니다. 다시 시도하세요.");
        }
    }

    public void registerMember() {
        System.out.print("NAME: ");
        String name = scanner.nextLine();
        System.out.print("E-MAIL: ");
        String email = scanner.nextLine();
        System.out.print("PASSWORD: ");
        String password = scanner.nextLine();

        members.add(new Member(name, email, password));
        System.out.println("회원가입이 완료되었습니다.");
    }

    public void registerAdmin() {
        System.out.print("NAME: ");
        String name = scanner.nextLine();
        System.out.print("E-MAIL: ");
        String email = scanner.nextLine();
        System.out.print("PASSWORD: ");
        String password = scanner.nextLine();

        admins.add(new Admin(name, email, password));
        System.out.println("관리자 가입이 완료되었습니다.");
    }

    private void loginAdmin() {
        System.out.print("NAME: ");
        String name = scanner.nextLine();
        System.out.print("PASSWORD: ");
        String password = scanner.nextLine();

        for (Admin admin : admins) {
            if (admin.getName().equals(name) && admin.getPassword().equals(password)) {
                adminMenu(admin);
                return;
            }
        }
        System.out.println("로그인 정보가 잘못되었습니다.");
    }

    private void loginMember() {
        System.out.print("NAME: ");
        String name = scanner.nextLine();
        System.out.print("PASSWORD: ");
        String password = scanner.nextLine();

        for (Member member : members) {
            if (member.getName().equals(name) && member.getPassword().equals(password)) {
                memberMenu(member);
                return;
            }
        }
        System.out.println("로그인 정보가 잘못되었습니다.");
    }

    private void adminMenu(Admin admin) {
        while (true) {
            System.out.println("\033[0;34m―――――――――――――――――――――――――――――――――――――\033[0m");
            System.out.println("         📖 \033[0;33m관리자 메뉴\033[0m 📖         ");
            System.out.println("\033[0;34m―――――――――――――――――――――――――――――――――――――\033[0m");
            System.out.println("\033[0;33m ①\033[0m 회원 관리");
            System.out.println("\033[0;33m ②\033[0m 도서 관리");
            System.out.println("\033[0;33m ③\033[0m 로그아웃");
            System.out.println("\033[0;34m―――――――――――――――――――――――――――――――――――――\033[0m");
            System.out.print("▶️ ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    manageMembers();
                    break;
                case 2:
                    manageBooks();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("잘못된 입력입니다. 다시 시도하세요.");
            }
        }
    }

    private void manageMembers() {
        while (true) {
            System.out.println("\033[0;34m―――――――――――――――――――――――――――――――――――――\033[0m");
            System.out.println("          📖 \033[0;33m회원 관리\033[0;33m 📖          ");
            System.out.println("\033[0;34m―――――――――――――――――――――――――――――――――――――\033[0m");
            System.out.println("\033[0;33m ①\033[0m 회원 조회");
            System.out.println("\033[0;33m ②\033[0m 회원 등록");
            System.out.println("\033[0;33m ③\033[0m 회원 정보 수정");
            System.out.println("\033[0;33m ④\033[0m 회원 삭제");
            System.out.println("\033[0;33m ⑤\033[0m 이전");
            System.out.println("\033[0;34m―――――――――――――――――――――――――――――――――――――\033[0m");

            System.out.print("▶️ ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    listMembers();
                    break;
                case 2:
                    registerMember();
                    break;
                case 3:
                    updateMember();
                    break;
                case 4:
                    deleteMember();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("잘못된 입력입니다. 다시 시도하세요.");
            }
        }
    }

    private void listMembers() {
        System.out.println("\033[0;34m―――――――――――――――――――――――――――――――――――――\033[0m");
        System.out.println("          📖 \033[0;33m회원 목록\033[0m 📖          ");
        System.out.println("\033[0;34m―――――――――――――――――――――――――――――――――――――\033[0m");
        for (Member member : members) {
            System.out.println("NAME: " + member.getName() + ", E-MAIL: " + member.getEmail());
        }
    }

    private void manageBooks() {
        while (true) {
            System.out.println("\033[0;34m―――――――――――――――――――――――――――――――――――――\033[0m");
            System.out.println("          📖 \033[0;33m도서 관리\033[0m 📖          ");
            System.out.println("\033[0;34m―――――――――――――――――――――――――――――――――――――\033[0m");
            System.out.println("\033[0;33m ①\033[0m 신청 관리");
            System.out.println("\033[0;33m ②\033[0m 도서 등록");
            System.out.println("\033[0;33m ③\033[0m 도서 수정");
            System.out.println("\033[0;33m ④\033[0m 도서 삭제");
            System.out.println("\033[0;33m ⑤\033[0m 이전");
            System.out.println("\033[0;34m―――――――――――――――――――――――――――――――――――――\033[0m");
            System.out.print("▶️ ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    managePendingBooks();
                    break;
                case 2:
                    registerBook();
                    break;
                case 3:
                    updateBook();
                    break;
                case 4:
                    deleteBook();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("잘못된 입력입니다. 다시 시도하세요.");
            }
        }
    }

    private void registerBook() {
        System.out.print("TITLE: ");
        String title = scanner.nextLine();
        System.out.print("AUTHOR: ");
        String author = scanner.nextLine();
        System.out.print("YEAR OF PUBLICATION: ");
        int year = scanner.nextInt();
        System.out.print("PRICE: ");
        int price = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        books.add(new Book(title, author, year, price));
        System.out.println("책이 등록되었습니다.");
    }

    private void updateBook() {
        if (books.isEmpty()) {
            System.out.println("아직 등록된 책이 없습니다.");
            return;
        }

        System.out.println("\033[0;34m―――――――――――――――――――――――――――――――――――――\033[0m");
        System.out.println("          📖 \033[0;33m도서 목록\033[0m 📖          ");
        System.out.println("\033[0;34m―――――――――――――――――――――――――――――――――――――\033[0m");
        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            System.out.println((i + 1) + ". TITLE: " + book.getTitle() + ", AUTHOR: " + book.getAuthor());
        }

        System.out.print("▶️ ");
        int bookIndex = scanner.nextInt();
        scanner.nextLine(); // 개행 문자 처리

        if (bookIndex >= 1 && bookIndex <= books.size()) {
            Book selectedBook = books.get(bookIndex - 1);

            System.out.print("TITLE: ");
            selectedBook.setTitle(scanner.nextLine());
            System.out.print("AUTHOR: ");
            selectedBook.setAuthor(scanner.nextLine());
            System.out.print("YEAR OF PUBLICATION: ");
            selectedBook.setPublicationYear(scanner.nextInt());
            System.out.print("PRICE: ");
            selectedBook.setPrice(scanner.nextInt());
            scanner.nextLine(); // 개행 문자 처리

            System.out.println("책 정보가 수정되었습니다.");
        } else {
            System.out.println("잘못된 책 번호입니다. 다시 시도하세요.");
        }
    } 

    private void deleteBook() {
        System.out.print("삭제할 책 제목: ");
        String title = scanner.nextLine();

        books.removeIf(book -> book.getTitle().equals(title));
        System.out.println("책이 삭제되었습니다.");
    }

    private void managePendingBooks() {
        System.out.println("\033[0;34m―――――――――――――――――――――――――――――――――――――\033[0m");
        System.out.println("        📖 \033[0;33m신청 도서 목록\033[0m 📖        ");
        System.out.println("\033[0;34m―――――――――――――――――――――――――――――――――――――\033[0m");
        for (Book book : pendingBooks) {
            System.out.println(book);
        }

        System.out.println("\033[0;34m―――――――――――――――――――――――――――――――――――――\033[0m");
        System.out.println("        ✏️ \033[0;33m승인할 책 제목\033[0m ✏️        ");
        System.out.println("\033[0;34m―――――――――――――――――――――――――――――――――――――\033[0m");
        String title = scanner.nextLine();

        if (title.isEmpty()) {
            return;
        }

        for (Book book : pendingBooks) {
            if (book.getTitle().equals(title)) {
                System.out.print("승인하시겠습니까? [y/n]: ");
                String response = scanner.nextLine();
                if (response.equalsIgnoreCase("y")) {
                    book.approve();
                    books.add(book);
                    pendingBooks.remove(book);
                    System.out.println("도서가 승인되었습니다.");
                } else {
                    pendingBooks.remove(book);
                    System.out.println("도서가 거부되었습니다.");
                }
                return;
            }
        }

        System.out.println("해당 도서를 찾을 수 없습니다.");
    }

    private void memberMenu(Member member) {
        while (true) {
            System.out.println("\033[0;34m―――――――――――――――――――――――――――――――――――――\033[0m");
            System.out.println("          🥔 \033[0;33m회원 메뉴\033[0m 🥔          ");
            System.out.println("\033[0;34m―――――――――――――――――――――――――――――――――――――\033[0m");
            System.out.println("\033[0;33m ①\033[0m 도서 신청");
            System.out.println("\033[0;33m ②\033[0m 도서 조회");
            System.out.println("\033[0;33m ③\033[0m 도서 평가");
            System.out.println("\033[0;33m ④\033[0m 관심 도서");
            System.out.println("\033[0;33m ⑤\033[0m 로그아웃");
            System.out.println("\033[0;33m ⑥\033[0m 종료");
            System.out.println("\033[0;34m―――――――――――――――――――――――――――――――――――――\033[0m");
            System.out.print("▶️ ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    applyBook();
                    break;
                case 2:
                    viewBooks();
                    break;
                case 3:
                    reviewBook();
                    break;
                case 4:
                    wishlistBook();
                    break;
                case 5:
                    return;
                case 6:
                    System.exit(0);
                default:
                    System.out.println("잘못된 입력입니다. 다시 시도하세요.");
            }
        }
    }

    private void applyBook() {
        System.out.print("TITLE: ");
        String title = scanner.nextLine();
        System.out.print("AUTHOR: ");
        String author = scanner.nextLine();
        System.out.print("YEAR OF PUBLICATION: ");
        int year = scanner.nextInt();
        System.out.print("PRICE: ");
        int price = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        pendingBooks.add(new Book(title, author, year, price));
        System.out.println("도서가 신청되었습니다. 관리자의 승인이 필요합니다.");
    }

    private void viewBooks() {
        String[] calm = {"책 제목", "저자", "출판", "가격", "위시  ", "한줄평가"};
        System.out.println("\033[0;34m―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――\033[0m");
        System.out.println("                                                         📖 \033[0;33m목록\033[0m 📖                                                         ");
        System.out.println("\033[0;34m―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――\033[0m");
        System.out.print(tableFormat(calm));
        System.out.println("\033[0;34m*****************************************************************************************************************************\033[0m");
        for (Book book : books) {
            System.out.print(tableFormat(book.getTitle(),
                    book.getAuthor(),
                    book.getPublicationYear(),
                    book.getPrice(),
                    book.getWishlistCount(),
                    book.getReview()));
        System.out.println("\033[0;34m―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――\033[0m");
        }
    }

    private String tableFormat(String[] title){
        int[] width = {22, 15, 5, 5, 5, 10};

        return String.format("%-"+width[0]+"s ｜ %-"+width[1]+"s ｜ %-"+width[2]+"s ｜ %-"+width[3]+"s ｜ %-"+width[4]+"s ｜ %-"+width[5]+"s\n", title[0], title[1], title[2], title[3], title[4], title[5]);
    }

    private String tableFormat(String title, String author, int year, int price, int cnt, String review){
        int[] width = {10, 10, 5, 5, 5, 10};

        return String.format("%-"+width[0]+"s ｜ %-"+width[1]+"s ｜ %-"+width[2]+"d년 ｜ %-"+width[3]+"d원 ｜ ⭐%-"+width[4]+"d ｜ %-"+width[5]+"s\n", title, author, year, price, cnt, review);
    }

    private void reviewBook() {
        System.out.println("\033[0;34m―――――――――――――――――――――――――――――――――――――\033[0m");
        System.out.println("          📖 \033[0;33m도서 목록\033[0m 📖          ");
        System.out.println("\033[0;34m―――――――――――――――――――――――――――――――――――――\033[0m");
        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            System.out.printf("%d. %s%n", i + 1, book.getTitle());
        }
        System.out.println("\033[0;34m―――――――――――――――――――――――――――――――――――――\033[0m");
        System.out.print("▶️ ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine(); // Consume newline

        if (index >= 0 && index < books.size()) {
            Book book = books.get(index);
            System.out.print("평가하기: ");
            book.setReview(scanner.nextLine());
            System.out.println("평가가 등록되었습니다.");
        } else {
            System.out.println("잘못된 책 번호입니다.");
        }
    }

    private void wishlistBook() {
        System.out.println("\033[0;34m―――――――――――――――――――――――――――――――――――――\033[0m");
        System.out.println("          📖 \033[0;33m도서 목록\033[0m 📖          ");
        System.out.println("\033[0;34m―――――――――――――――――――――――――――――――――――――\033[0m");
        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            System.out.printf("%d. %s ｜ %s%n", i + 1, book.getTitle(), book.getAuthor());
        }
        System.out.println("\033[0;34m―――――――――――――――――――――――――――――――――――――\033[0m");
        System.out.print("▶️ ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine(); // Consume newline

        if (index >= 0 && index < books.size()) {
            books.get(index).incrementWishlistCount();
            System.out.println("책이 위시리스트에 추가되었습니다.");
        } else {
            System.out.println("잘못된 책 번호입니다.");
        }
    }

    private void updateMember() {
        System.out.println("\033[0;34m―――――――――――――――――――――――――――――――――――――\033[0m");
        System.out.println("          🥔 \033[0;33m회원 목록\033[0m 🥔          ");
        System.out.println("\033[0;34m―――――――――――――――――――――――――――――――――――――\033[0m");
        // 회원 목록 출력
        for (int i = 0; i < members.size(); i++) {
            Member member = members.get(i);
            System.out.println((i + 1) + ". NAME: " + member.getName() + ", E-MAIL: " + member.getEmail());
        }

        // 선택할 회원 번호 입력 받기
        System.out.println("\033[0;34m―――――――――――――――――――――――――――――――――――――\033[0m");
        System.out.print("▶️ ");
        int memberIndex = scanner.nextInt();
        scanner.nextLine(); // 개행 문자 처리

        // 입력한 번호에 해당하는 회원 찾기
        if (memberIndex >= 1 && memberIndex <= members.size()) {
            Member selectedMember = members.get(memberIndex - 1);

            // 수정할 정보 입력 받기
            System.out.println("\033[0;34m―――――――――――――――――――――――――――――――――――――\033[0m");
            System.out.println("          🥔 \033[0;33m현재 회원 정보\033[0m 🥔          ");
            System.out.println("\033[0;34m―――――――――――――――――――――――――――――――――――――\033[0m");
            System.out.println("NAME: " + selectedMember.getName());
            System.out.println("E-MAIL: " + selectedMember.getEmail());
            System.out.println("PASSWORD: " + selectedMember.getPassword());
            System.out.println("\033[0;34m―――――――――――――――――――――――――――――――――――――\033[0m");
            System.out.println(" 변경을 원하지 않는 항목은 엔터 입력 ");
            System.out.println("\033[0;34m―――――――――――――――――――――――――――――――――――――\033[0m");
            System.out.print("NEW NAME: ");
            String newName = scanner.nextLine();
            if (!newName.isEmpty()) {
                selectedMember.setName(newName);
            }

            System.out.print("NEW E-MAIL: ");
            String newEmail = scanner.nextLine();
            if (!newEmail.isEmpty()) {
                selectedMember.setEmail(newEmail);
            }

            System.out.print("NEW PASSWORD: ");
            String newPassword = scanner.nextLine();
            if (!newPassword.isEmpty()) {
                selectedMember.setPassword(newPassword);
            }

            System.out.println("회원 정보가 수정되었습니다.");
        } else {
            System.out.println("잘못된 회원 번호입니다. 다시 시도하세요.");
        }
    }

    private void deleteMember() {
        System.out.println("\033[0;34m―――――――――――――――――――――――――――――――――――――\033[0m");
        System.out.println("          🥔 \033[0;33m회원 목록\033[0m 🥔          ");
        System.out.println("\033[0;34m―――――――――――――――――――――――――――――――――――――\033[0m");
        // 회원 목록 출력
        System.out.println("삭제할 회원을 선택하세요:");
        for (int i = 0; i < members.size(); i++) {
            Member member = members.get(i);
            System.out.println((i + 1) + ". NAME: " + member.getName() + ", E-MAIL: " + member.getEmail());
        }

        // 선택할 회원 번호 입력 받기
        System.out.print("▶️ ");
        int memberIndex = scanner.nextInt();
        scanner.nextLine(); // 개행 문자 처리

        // 입력한 번호에 해당하는 회원 삭제
        if (memberIndex >= 1 && memberIndex <= members.size()) {
            Member selectedMember = members.get(memberIndex - 1);
            members.remove(selectedMember);
            System.out.println("회원이 삭제되었습니다.");
        } else {
            System.out.println("잘못된 회원 번호입니다. 다시 시도하세요.");
        }
    }

    public static void main(String[] args) {
        BookClub bookClub = new BookClub();
        Scanner scanner = new Scanner(System.in);

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
                    bookClub.registerMember();
                    break;
                case 3:
                    bookClub.registerAdmin();
                    break;
                default:
                    System.out.println("잘못된 입력입니다. 다시 시도하세요.");
            }
        }
    }
}