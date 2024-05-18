package test2_Variant_1;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataReader {

    private String path;

    public DataReader(String path) {
        this.path = path;
    }

    private List<MotherData> arrayOfData;
    public void collectData() throws IOException {

        arrayOfData = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {

                String [] fields = line.split("\\s+");
                char gender = fields[0].charAt(0);
                byte plural = Byte.parseByte(fields[1]);
                byte age = Byte.parseByte(fields[2]);
                String race = fields[3];
                byte parity = Byte.parseByte(fields[4]);
                boolean married = (fields[5].equals("1"));
                short birthWeight = Short.parseShort(fields[6]);
                byte smokeN = Byte.parseByte(fields[7]);
                byte drinkN = Byte.parseByte(fields[8]);
                boolean firstep = (fields[5].equals("1"));
                boolean welfare = (fields[5].equals("1"));
                boolean smoker = (fields[5].equals("1"));
                boolean drinker = (fields[5].equals("1"));
                short wpre = Short.parseShort(fields[13]);
                short wgain = Short.parseShort(fields[14]);
                byte education = Byte.parseByte(fields[15]);
                byte gestation = Byte.parseByte(fields[16]);

                arrayOfData.add(new MotherData(gender, plural, age, race, parity, married, birthWeight, smokeN, drinkN, firstep, welfare, smoker, drinker, wpre, wgain, education, gestation));
            }
        }
    }

    public List<MotherData> getData() {
        return arrayOfData;
    }
}