public class Person {


    private char gender;

    public char getGender()
    {
        return gender;
    }

    public void setGender(char gender)
    {
        this.gender = gender;
    }

    public Person() {
        this('M');
    }

    public Person(char gender)
    {
        setGender(gender);
    }

    public String toString() {
        return String.format("\n\n%-20s%s","Gender", getGender());
    }
}
