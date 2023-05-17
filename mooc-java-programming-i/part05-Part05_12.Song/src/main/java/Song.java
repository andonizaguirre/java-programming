
public class Song {

    private String artist;
    private String name;
    private int durationInSeconds;

    public Song(String artist, String name, int durationInSeconds) {
        this.artist = artist;
        this.name = name;
        this.durationInSeconds = durationInSeconds;
    }

    public boolean equals(Object object) {
        // if the variables exist in the same place, then they are equal
        if (this == object) {
            return true;
        }
        // if the compared object is not and instance of Song, 
        // then the objects are not equal
        if (!(object instanceof Song)) {
            return false;
        }
        // let's cast the object to type Song
        Song compared = (Song) object;
        // if the values of object variables for the two objects are equal, them the objects are equal
        if (this.artist.equals(compared.artist) && this.name.equals(compared.name) && this.durationInSeconds == compared.durationInSeconds) {
            return true;
        }
        // otherwise they are not equal
        return false;
    }

    @Override
    public String toString() {
        return this.artist + ": " + this.name + " (" + this.durationInSeconds + " s)";
    }
}
