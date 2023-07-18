package bootcoding.jdbc.projector.service;

import bootcoding.jdbc.projector.model.Projector;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ProjectorService {

    public List<Projector> buildRecord(int size) {
        List<Projector> projectors = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            Projector projector = new Projector();
            projector.setCompanyName(getCompanyName());
            projector.setPrice(getPrice());
            projector.setColour(getColor());
            projectors.add(projector);
        }
        return projectors;

    }

    private static String colour[]={"Black","White","Gray"};
    private static String getColor()
    {
        Random random= new Random();
        int index=random.nextInt(colour.length);
        return colour[index];
    }
    private static String companyName[]={"Canon","Epson","Hitachi","InFocus","LG","BenQ"};
    private static String getCompanyName()
    {
        Random random=new Random();
        int index =random.nextInt(companyName.length);
        return companyName[index];
    }
    public int getPrice()
    {
        Random random= new Random();
        int min=20000;
        int max=60000;
        int number =random.nextInt(max - min);
        return number;
    }



}
