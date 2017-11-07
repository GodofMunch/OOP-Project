public class Person {

    private Personality myPersonality;
    private Name myName;
    private String gender;

    public void setMyPersonality(Personality myPersonality)
    {
        this.myPersonality = myPersonality;
    }

    public void setMyName(Name myName)
    {
        this.myName = myName;
    }

    public void setGender()
    {
        this.gender = gender;
    }

    public Personality getMyPersonality()
    {
        return myPersonality;
    }

    public Name getMyName()
    {
        return myName;
    }

    public String getGender()
    {
        return gender;
    }

    public String toString()
    {
        String person;

        person = String.format(myName.toString() + "\n\n" + myPersonality.toString() + "\n\n%-20s", getGender());

        return person;
    }
}
