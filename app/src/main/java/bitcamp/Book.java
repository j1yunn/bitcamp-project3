package bitcamp;

public class Book {
    private String title;
    private String author;
    private int publicationYear;
    private int price;
    private int wishlistCount;
    private String review;
    private boolean approved;

    public Book(String title, String author, int publicationYear, int price) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.price = price;
        this.wishlistCount = 0;
        this.review = "";
        this.approved = false; // 초기값은 승인되지 않은 상태
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getWishlistCount() {
        return wishlistCount;
    }

    public void incrementWishlistCount() {
        this.wishlistCount++;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public boolean isApproved() {
        return approved;
    }

    public void approve() {
        this.approved = true;
    }

    @Override
    public String toString() {
        return String.format("%s | %s | %d | %d | %d | %s",
                title, author, publicationYear, price, wishlistCount, review);
    }
}