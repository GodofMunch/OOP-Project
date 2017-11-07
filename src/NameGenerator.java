public class NameGenerator {

    private String femaleName;
    private String maleName;
    private String surname;
    private String forname;

    public void setMaleNames(String maleNames)
    {
        this.maleName = maleNames;
    }

    public void setForname(String forename)
    {
        this.forname = forename;
    }

    public void setFemaleNames(String femaleNames)
    {
        this.femaleName = femaleNames;
    }

    public void setSurnames(String surnames)
    {
        this.surname = surnames;
    }

    public String getMaleName()
    {
        return maleName;
    }

    public String getFemaleName()
    {
        return femaleName;
    }

    public String getSurname()
    {
        return surname;
    }

    public String getForname()
    {
        return forname;
    }

    public String maleToString()
    {
        return String.format("%s%s%s", "Name", getMaleName(), getSurname());
    }

    public String femaleToString()
    {
        return String.format("%s%s%s", "Name", getFemaleName(), getSurname());
    }

    public String toString()
    {
        return String.format("%s%s%s", "Name: ", getForname(), getSurname());
    }
}
