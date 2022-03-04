package by.it.academy.Mk_JD2_88_22.model.airpotsDB;

public class NameLang {
    private String en;
    private String ru;

    public String getEn() {
        return en;
    }

    public void setEn(String en) {
        this.en = en;
    }

    public String getRu() {
        return ru;
    }

    public void setRu(String ru) {
        this.ru = ru;
    }

    @Override
    public String toString() {
        return "{" +
                "en='" + en + '\'' +
                ", ru='" + ru + '\'' +
                '}';
    }
}
