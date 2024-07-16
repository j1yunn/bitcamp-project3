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
        System.out.println("로그인 유형을 선택하세요:");
        System.out.println("1. 관리자 로그인");
        System.out.println("2. 회원 로그인");
        System.out.print("선택: ");
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
        System.out.print("이름: ");
        String name = scanner.nextLine();
        System.out.print("이메일: ");
        String email = scanner.nextLine();
        System.out.print("비밀번호: ");
        String password = scanner.nextLine();

        members.add(new Member(name, email, password));
        System.out.println("회원가입이 완료되었습니다.");
    }

    public void registerAdmin() {
        System.out.print("관리자 이름: ");
        String name = scanner.nextLine();
        System.out.print("이메일: ");
        String email = scanner.nextLine();
        System.out.print("비밀번호: ");
        String password = scanner.nextLine();

        admins.add(new Admin(name, email, password));
        System.out.println("관리자 가입이 완료되었습니다.");
    }

    private void loginAdmin() {
        System.out.print("관리자 이름: ");
        String name = scanner.nextLine();
        System.out.print("비밀번호: ");
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
        System.out.print("회원 이름: ");
        String name = scanner.nextLine();
        System.out.print("비밀번호: ");
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
            System.out.println("=== 관리자 메뉴 ===");
            System.out.println("1. 회원 관리");
            System.out.println("2. 도서 관리");
            System.out.println("3. 로그아웃");
            System.out.print("선택: ");
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
            System.out.println("=== 회원 관리 ===");
            System.out.println("1. 회원 조회");
            System.out.println("2. 회원 등록");
            System.out.println("3. 회원 정보 수정");
            System.out.println("4. 회원 삭제");
            System.out.println("5. 이전");
            System.out.print("선택: ");
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
        System.out.println("=== 회원 목록 ===");
        for (Member member : members) {
            System.out.println("이름: " + member.getName() + ", 이메일: " + member.getEmail());
        }
    }

    private void manageBooks() {
        while (true) {
            System.out.println("=== 도서 관리 ===");
            System.out.println("1. 신청 도서 관리");
            System.out.println("2. 도서 등록");
            System.out.println("3. 도서 수정");
            System.out.println("4. 도서 삭제");
            System.out.println("5. 이전");
            System.out.print("선택: ");
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
        System.out.print("책 제목: ");
        String title = scanner.nextLine();
        System.out.print("저자: ");
        String author = scanner.nextLine();
        System.out.print("출판 연도: ");
        int year = scanner.nextInt();
        System.out.print("가격: ");
        int price = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        books.add(new Book(title, author, year, price));
        System.out.println("책이 등록되었습니다.");
    }

    private void updateBook() {
        System.out.print("수정할 책 제목: ");
        String title = scanner.nextLine();

        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                System.out.print("새 제목: ");
                book.setTitle(scanner.nextLine());
                System.out.print("새 저자: ");
                book.setAuthor(scanner.nextLine());
                System.out.print("새 출판 연도: ");
                book.setPublicationYear(scanner.nextInt());
                System.out.print("새 가격: ");
                book.setPrice(scanner.nextInt());
                scanner.nextLine(); // Consume newline

                System.out.println("책 정보가 수정되었습니다.");
                return;
            }
        }

        System.out.println("책을 찾을 수 없습니다.");
    }

    private void deleteBook() {
        System.out.print("삭제할 책 제목: ");
        String title = scanner.nextLine();

        books.removeIf(book -> book.getTitle().equals(title));
        System.out.println("책이 삭제되었습니다.");
    }

    private void managePendingBooks() {
        System.out.println("신청 도서 목록:");
        for (Book book : pendingBooks) {
            System.out.println(book);
        }

        System.out.print("승인할 책 제목: ");
        String title = scanner.nextLine();

        if (title.isEmpty()) {
            return;
        }

        for (Book book : pendingBooks) {
            if (book.getTitle().equals(title)) {
                System.out.print("승인하시겠습니까? (y/n): ");
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

        System.out.println("도서를 찾을 수 없습니다.");
    }

    private void memberMenu(Member member) {
        while (true) {
            System.out.println("=== 회원 메뉴 ===");
            System.out.println("1. 도서 신청");
            System.out.println("2. 도서 조회");
            System.out.println("3. 도서 평가");
            System.out.println("4. 관심 도서");
            System.out.println("5. 로그아웃");
            System.out.println("6. 종료");
            System.out.print("선택: ");
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
        System.out.print("신청할 책 제목: ");
        String title = scanner.nextLine();
        System.out.print("저자: ");
        String author = scanner.nextLine();
        System.out.print("출판 연도: ");
        int year = scanner.nextInt();
        System.out.print("가격: ");
        int price = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        pendingBooks.add(new Book(title, author, year, price));
        System.out.println("도서가 신청되었습니다. 관리자의 승인이 필요합니다.");
    }

    private void viewBooks() {
        String[] calm = {"책 제목", "저자", "출판", "가격", "위시", "한줄평가"};

        System.out.println("책 목록:");
        System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
        System.out.print(tableFormat(calm));
        System.out.println("*****************************************************************************************************************************");
        for (Book book : books) {
            System.out.print(tableFormat(book.getTitle(),
                    book.getAuthor(),
                    book.getPublicationYear(),
                    book.getPrice(),
                    book.getWishlistCount(),
                    book.getReview()));
        System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
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
        System.out.println("책 목록:");
        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            System.out.printf("%d. %s%n", i + 1, book.getTitle());
        }

        System.out.print("평가할 책 번호: ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine(); // Consume newline

        if (index >= 0 && index < books.size()) {
            Book book = books.get(index);
            System.out.print("한줄 평가: ");
            book.setReview(scanner.nextLine());
            System.out.println("평가가 등록되었습니다.");
        } else {
            System.out.println("잘못된 책 번호입니다.");
        }
    }

    private void wishlistBook() {
        System.out.println("책 목록:");
        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            System.out.printf("%d. %s | %s%n", i + 1, book.getTitle(), book.getAuthor());
        }

        System.out.print("위시리스트에 추가할 책 번호: ");
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
        System.out.print("수정할 회원 이름: ");
        String name = scanner.nextLine();

        for (Member member : members) {
            if (member.getName().equals(name)) {
                System.out.print("새 이름: ");
                member.setName(scanner.nextLine());
                System.out.print("새 이메일: ");
                member.setEmail(scanner.nextLine());
                System.out.print("새 비밀번호: ");
                member.setPassword(scanner.nextLine());

                System.out.println("회원 정보가 수정되었습니다.");
                return;
            }
        }

        System.out.println("회원을 찾을 수 없습니다.");
    }

    private void deleteMember() {
        System.out.print("삭제할 회원 이름: ");
        String name = scanner.nextLine();

        members.removeIf(member -> member.getName().equals(name));
        System.out.println("회원이 삭제되었습니다.");
    }

    public static void main(String[] args) {
        BookClub bookClub = new BookClub();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("=== 메인 화면 ===");
            System.out.println("1. 로그인");
            System.out.println("2. 일반 회원가입");
            System.out.println("3. 관리자 회원가입");
            System.out.print("선택: ");
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