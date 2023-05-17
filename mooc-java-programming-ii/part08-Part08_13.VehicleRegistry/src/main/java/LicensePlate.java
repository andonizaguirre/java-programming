
import java.util.Objects;

public class LicensePlate {

    // don't modify existing parts of this class
    // these instance variables have been defined as final, meaning 
    // that once set, their value can't be changed
    private final String liNumber;
    private final String country;

    public LicensePlate(String country, String liNumber) {
        this.liNumber = liNumber;
        this.country = country;
    }

    @Override
    public String toString() {
        return country + " " + liNumber;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof LicensePlate)) {
            return false;
        }
        LicensePlate compared = (LicensePlate) object;
        if (this.country == compared.country && this.liNumber == compared.liNumber) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.country.hashCode() + this.liNumber.hashCode();
//        int hash = 7;
//        hash = 89 * hash + Objects.hashCode(this.liNumber);
//        hash = 89 * hash + Objects.hashCode(this.country);
//        return hash;
    }
}
