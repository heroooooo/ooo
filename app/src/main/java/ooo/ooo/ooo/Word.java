package ooo.ooo.ooo;

/**
 * Created by hang on 2017/3/6.
 */

public class Word {
    public String id;
    public String word;
    public String _en;
    public String _am;
    public String meaning;

    public Word(String word, String _en, String _am, String meaning) {
        this.word = word;
        this._en = _en;
        this._am = _am;
        this.meaning = meaning;
    }

    public Word(String id, String word, String _en, String _am, String meaning) {
        this.id = id;
        this.word = word;
        this._en = _en;
        this._am = _am;
        this.meaning = meaning;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String get_en() {
        return _en;
    }

    public void set_en(String _en) {
        this._en = _en;
    }

    public String get_am() {
        return _am;
    }

    public void set_am(String _am) {
        this._am = _am;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    @Override
    public String toString() {
        return "Word{" +
                "word='" + word + '\'' +
                ", _en='" + _en + '\'' +
                ", _am='" + _am + '\'' +
                ", meaning='" + meaning + '\'' +
                '}';
    }
}
