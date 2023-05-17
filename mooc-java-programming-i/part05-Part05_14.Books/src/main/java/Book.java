
public class Book {

    private String name;
    private int publicationYear;

    public Book(String name, int publicationYear) {
        this.name = name;
        this.publicationYear = publicationYear;
    }

    public String getName() {
        return name;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Book)) {
            return false;
        }
        Book compared = (Book) object;
        if (this.name.equals(compared.name) && this.publicationYear == compared.publicationYear) {
            return true;
        }
        return false;
    }
}
