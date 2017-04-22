package zeus.minhquan.dictionary.model;

/**
 * Created by QuanT on 4/22/2017.
 */

public class Word {
    private int id;
    private String word;
    private String type;
    private String meaning;
    private String image;
    private String example;
    private boolean isFavorite;

    public Word(int id, String word, String type, String meaning, String image, String example, boolean isFavorite) {
        this.id = id;
        this.word = word;
        this.type = type;
        this.meaning = meaning;
        this.image = image;
        this.example = example;
        this.isFavorite = isFavorite;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }

    @Override
    public String toString() {
        return "Word{" +
                "id=" + id +
                ", word='" + word + '\'' +
                ", type='" + type + '\'' +
                ", meaning='" + meaning + '\'' +
                ", image='" + image + '\'' +
                ", example='" + example + '\'' +
                ", isFavorite=" + isFavorite +
                '}';
    }
}
