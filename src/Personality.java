/*
*   Personality.java
*
*   Created by David O'Sullivan - T00139303
*
*   This file creates the Personality class that will assimilate a persons Personality
*
 */

public class Personality {

    private int empathy;
    private int humour;
    private int intelligence;
    private int curiosity;
    private int honesty;
    private int courage;
    private int integrity;
    private int selfAwareness;
    private int creativity;
    private String type;


    public int getEmpathy()
    {
        return empathy;
    }

    public int getHumour()
    {
        return humour;
    }

    public int getIntelligence()
    {
        return intelligence;
    }

    public int getCuriosity()
    {
        return curiosity;
    }

    public int getHonesty()
    {
        return honesty;
    }

    public int getCourage()
    {
        return courage;
    }

    public int getIntegrity()
    {
        return integrity;
    }

    public int getSelfAwareness()
    {
        return selfAwareness;
    }

    public int getCreativity()
    {
        return creativity;
    }

    public String getType() {
        return type;
    }

    public void setEmpathy(int empathy)
    {
        this.empathy = empathy;
    }

    public void setHumour(int humour)
    {
        this.humour = humour;
    }

    public void setIntelligence(int intelligence)
    {
        this.intelligence = intelligence;
    }

    public void setCuriosity(int curiosity)
    {
        this.curiosity = curiosity;
    }

    public void setHonesty(int honesty)
    {
        this.honesty = honesty;
    }

    public void setCourage(int courage)
    {
        this.courage = courage;
    }

    public void setIntegrity(int integrity)
    {
        this.integrity = integrity;
    }

    public void setSelfAwareness(int selfAwareness)
    {
        this.selfAwareness = selfAwareness;
    }

    public void setCreativity(int creativity)
    {
        this.creativity = creativity;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Personality()
    {
        this(0,0,0,0,0,0,0,0,0, "");
    }

    public Personality(int empathy, int humour, int intelligence, int curiosity, int honesty,
                       int courage, int integrity, int selfAwareness, int creativity, String type) {
        setEmpathy(empathy);
        setHumour(humour);
        setIntelligence(intelligence);
        setCuriosity(curiosity);
        setHonesty(honesty);
        setCourage(courage);
        setIntegrity(integrity);
        setSelfAwareness(selfAwareness);
        setCreativity(creativity);
    }

    public String toString() {
        String personalityTraits;

        personalityTraits =
                String.format("%-20s%10d\n%-20s%10d\n%-20s%10d\n%-20s%10d\n%-20s%10d\n%-20s%10d\n%-20s%10d\n%-20s%10d\n%-20s%10d\n%-20s%10s\n",
                        "Empathy: ", getEmpathy(), "Humour: ", getHumour(), "Intelligence: ", getIntelligence(), "Curiosity: " ,
                        getCuriosity(), "Honesty: ", getHonesty(), "Courage: ", getCourage(), "Integrity: ", getIntegrity(),
                        "Self Awareness: ", getSelfAwareness(), "Creativity: " , getCreativity(),"Personality Type: ", getType());

        return personalityTraits;
    }
}
