package test2_Variant_1;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Tasks {
    public static List<MotherData> data;

    public Tasks() throws IOException {
        DataReader r = new DataReader("src/test2_Variant_1/BirthsKingCounty2001.txt");
        r.collectData();
        data = r.getData();
    }

    public void task1() {
        Map<Byte, int []> averEdOfParity = new TreeMap<>();

        for (MotherData dt : data) {
            byte parity = dt.getParity();
            if (!averEdOfParity.containsKey(parity)) {
                int [] allEdAndCount = new int[] {dt.getEducation(), 1};
                averEdOfParity.put(parity, allEdAndCount);
            } else {
                int [] allEdAndCount = averEdOfParity.get(parity);
                allEdAndCount[0] += dt.getEducation();
                allEdAndCount[1]++;
                averEdOfParity.put(parity, allEdAndCount);
            }
        }

        for (Map.Entry<Byte, int []> pair : averEdOfParity.entrySet()) {
            int [] dt = pair.getValue();
            System.out.println("Среднее значение продолжительности образования при " + pair.getKey() + " детей составялет " + (float) dt[0] / dt[1]);
        }
    }

    public void task2() {
        double hasHusband = data.stream().filter(MotherData::isMarried).collect(Collectors.averagingDouble(MotherData::getGestation));
        double hasNotHusband = data.stream().filter(birthday -> !birthday.isMarried()).collect(Collectors.averagingDouble(MotherData::getGestation));

        boolean answer = hasHusband < hasNotHusband;

        System.out.println("Замужем: " + hasHusband);
        System.out.println("Не замужем: " + hasNotHusband);

        if (answer) {
            System.out.println("Утверждение из 2 задания верно!");
        } else {
            System.out.println("Утверждение из 2 задания неверно!");
        }
    }


    public static void main(String[] args) throws IOException {
        Tasks tasks = new Tasks();
        System.out.println("Task 1");
        tasks.task1();
        System.out.println();
        System.out.println("Task 2");
        tasks.task2();
    }
}
