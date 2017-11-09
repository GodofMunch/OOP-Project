public class Name {

    private static String[] femaleNames;
    private static String[] maleNames;
    private static String[] surnames;

    public static String getName(Person myPerson)
    {
        String forename;

        femaleNames = new String[] {"Chloe", "Aoife", "Sarah", "Niamh", "Emma", "Rachel",
                                    "Rebecca", "Lauren", "Megan", "Amy", "Laura", "Katie",
                                    "Emily", "Shauna", "Nicole", "Roisin", "Sophie", "Kate",
                                    "Shannon", "Maire"};

        maleNames = new String[]   {"Conor", "Sean", "Jack", "James", "Adam", "Michael", "David",
                                    "Aaron", "Daniel", "Dylan", "Shane", "Cian", "Ryan", "Luke",
                                    "John", "Eoin", "Mark", "Patrick", "Thomas", "Liam"};

        surnames = new String[]    {"Murphy", "Kelly", "Byrne", "Ryan", "O'Brien", "Walsh", "O'Sullivan",
                                    "O'Conner", "Doyle", "McCarthy", "O'Neill", "Lynch", "O'Reilly",
                                    "Dunne", "McDonagh", "Brennan", "Fitzgerald", "Daly", "Kavanagh",
                                    "Nolan"};


        if(myPerson.getGender()=='M')
        {
            forename = maleNames[randomNumber()];
        }

        else
        {
            forename = femaleNames[randomNumber()];
        }


        return  forename + " " +  surnames[randomNumber()];
    }

    public static int randomNumber()
    {
        return (int)(Math.random()*19)+1;
    }
}
