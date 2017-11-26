import java.util.*;

public class Name {

    public static String[] femaleNames = new String[] {"Chloe", "Aoife", "Sarah", "Niamh", "Emma", "Rachel",
                                                        "Rebecca", "Lauren", "Megan", "Amy", "Laura", "Katie",
                                                        "Emily", "Shauna", "Nicole", "Roisin", "Sophie", "Kate",
                                                        "Shannon", "Maire", "Abigail", "Alannah", "Aoibheann",
                                                        "Caoimhe", "Cara","Rosie", "Janet", "Maria", "Michelle",
                                                        "Tina", "Claire", "Fiona", "Oonagh", "Oorla", "Ciara",
                                                        "Liz", "Eva", "Frida", "Hannah", "Tracy", "Lily", "Deirdre",
                                                        "Ava", "Amelia", "Mia", "Saoirse", "Olivia", "Ruth",
                                                        "Clodagh", "Isabella"};

    public static List<String> femaleList = Arrays.asList(femaleNames);

    public static String[] maleNames = new String[]   {"Conor", "Sean", "Jack", "James", "Adam", "Michael", "David",
                                                        "Aaron", "Daniel", "Dylan", "Shane", "Cian", "Ryan", "Luke",
                                                        "John", "Eoin", "Mark", "Patrick", "Thomas", "Liam", "Fionn",
                                                        "Ciaran", "Adam", "Charlie", "Oisin", "Alex", "Harry", "Darragh",
                                                        "Cillian", "Jamie", "Jake", "Aaron", "Aidan", "Barry", "Matthew",
                                                        "Shane", "Ben", "Oliver", "Nathan", "Evan", "Joseph", "Zach",
                                                        "Callum", "Max", "Ethan", "Martin", "Terry", "Chris", "Bart",
                                                        "Eddie"};

    public static String[] surnames = new String[]    {"Murphy", "Kelly", "Byrne", "Ryan", "O'Brien", "Walsh", "O'Sullivan",
                                                        "O'Conner", "Doyle", "McCarthy", "O'Neill", "Lynch", "O'Reilly",
                                                        "Dunne", "McDonagh", "Brennan", "Fitzgerald", "Daly", "Kavanagh",
                                                        "Nolan", "McGowan", "Smith", "Gallagher", "Doherty", "Kennedy",
                                                        "Murray", "Quinn", "Moore", "McLaughlin", "O'Carroll", "Connolly",
                                                        "Daly", "O'Connell", "Wilson", "Burke", "Collins", "Campbell",
                                                        "Johnston", "Farrell", "Brown", "Martin", "O'Callaghan",
                                                        "Duffy", "Keating", "Boyle", "O'Mahoney", "Hogan", "Griffin",
                                                        "Curran", "McInerney"};

    public static String getName(Person myPerson) {
        String forename;


        if(myPerson.getGender()=='M')
            forename = maleNames[randomNumberName(maleNames.length)];
        else
            forename = femaleNames[randomNumberName(femaleNames.length)];

        return  forename + " " +  surnames[randomNumberName(surnames.length)];
    }

    public static int randomNumberName(int i)
    {
        return (int)(Math.random()*(i-1))+1;
    }
}