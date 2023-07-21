package bootcoding.jdbc.hospital;

import util.RandomDateGenerator;

import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class PatientService {

    public List<Patient> buildRecord(int size)
    {
        RandomDateGenerator previousDate = new RandomDateGenerator();
        List<Patient>patients= new ArrayList<>();
        for(int i=0;i<size;i++)
        {
            Patient patient= new Patient();
            patient.setId(i);
            patient.setName(getName());
            patient.setDisease(getDiseaseName());
            patient.setCity(getCityName());
            patient.setMobile_number(getMobileNumber());
            patient.setEmail_id(getEmailId(getName()));
            patient.setAdmission_date(previousDate.getDate());
            patient.setDischarge_date(previousDate.getDate());
            patient.setIs_cure(getis_cure());
            patients.add(patient);

        }
        return patients;

    }



    // Method to generate and set a random date to the myDate variable
//    public Calendar generateRandomDate() {
//         Random random = new Random();
//       Calendar startDate = new GregorianCalendar(2020, Calendar.JANUARY, 1); // Set your desired start date
//        int daysToAdd = random.nextInt(365 * 3); // Generate a random number of days between 0 and 365*20 (20 years)
//        startDate.add(Calendar.DAY_OF_YEAR, daysToAdd); // Add the random number of days to the start date
//         return startDate;
//    }


    private static int getMobileNumber()
    {
        int max=134526893;
        int min=10000000;
        Random random= new Random();
       int num = random.nextInt(max-min);
       return num;
    }


    private static boolean getis_cure()
    {
        boolean isCure[]={true,false};
        Random random = new Random();
        int index =random.nextInt(isCure.length);
        return isCure[index];
    }

    private static final String EMAIL_SUFFIX = "@gmail.com";
    private static final Random random = new Random();
    private static final int MIN = 2000;
    private static final int MAX = 2022;

    public static String getEmailId(String name) {
        int randomNumber = random.nextInt(MAX - MIN);
        int year = MIN + randomNumber;
        String emailId =getName() +year + EMAIL_SUFFIX;
        //System.out.println("Email ID : " + emailId);
        return emailId;
    }


    private static String getCityName()
    {
        String cityName[]={"Pune","Mumbai","jabalpur","shegaon","hingoli","nashik","bhandara","umred"};
        Random random= new Random();
        int index=random.nextInt(cityName.length);
        return cityName[index];
    }


    private static String diseasename[]={"fever","tb","cancer",
            "heartattack","Diphtheria","Pneumonia","cholera"," bubonic plague"};
    private static String getDiseaseName()
    {
        Random random= new Random();
        int index=random.nextInt(diseasename.length);
        return diseasename[index];
    }


    private static String patientName[]={"reena","rutuja","savi",
            "jiya","shubham","gaurav","suhas","mayur"};

    private static String getName()
    {
        Random random= new Random();
        int index=random.nextInt(patientName.length);
        return patientName[index];
    }

}
