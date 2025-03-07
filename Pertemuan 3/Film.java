public class Film {
    private final String judul;
    private final int minAge;
    private final float rating;

    public Film(String judul, int minAge, float rating) {
        this.judul = judul;
        this.minAge = minAge;
        this.rating = rating;
    }

    public String getJudul() {
        return judul;
    }

    public int getMinAge() {
        return minAge;
    }

    public float getRating() {
        return rating;
    }
}
