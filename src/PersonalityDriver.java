public class PersonalityDriver {

    public static void main(String args[])
    {

        Personality testPersonality = new Personality();

        testPersonality.setEmpathy(randomNumber());
        testPersonality.setHumour(randomNumber());
        testPersonality.setIntelligence(randomNumber());
        testPersonality.setCuriosity(randomNumber());
        testPersonality.setHonesty(randomNumber());
        testPersonality.setCourage(randomNumber());
        testPersonality.setIntegrity(randomNumber());
        testPersonality.setSelfAwareness(randomNumber());
        testPersonality.setCreativity(randomNumber());

        System.out.print(testPersonality.toString());
    }

    public static int randomNumber()
    {
        int random = (int)(Math.random()*10)+1;

        if(random<=2)
            random = (int)(Math.random()*5)+1;

        else if(random>=8)
            random = (int)(Math.random()*5)+6;

        return random;
    }
}
