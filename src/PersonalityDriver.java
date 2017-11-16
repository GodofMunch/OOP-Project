public class PersonalityDriver {

    public static void main(String args[]) {

        Personality testPersonality = new Personality();

        testPersonality.setEmpathy(PersonDriver.randomNumber());
        testPersonality.setHumour(PersonDriver.randomNumber());
        testPersonality.setIntelligence(PersonDriver.randomNumber());
        testPersonality.setCuriosity(PersonDriver.randomNumber());
        testPersonality.setHonesty(PersonDriver.randomNumber());
        testPersonality.setCourage(PersonDriver.randomNumber());
        testPersonality.setIntegrity(PersonDriver.randomNumber());
        testPersonality.setSelfAwareness(PersonDriver.randomNumber());
        testPersonality.setCreativity(PersonDriver.randomNumber());

        System.out.print(testPersonality.toString());
    }

}
