import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<String> fileData = getFileData("src/Input.txt");
        ArrayList<String> sortLeft = new ArrayList<>();
        ArrayList<String> sortRight = new ArrayList<>();

        for(int i =0; i < fileData.size(); i++){
            String[] currentData = fileData.get(i).split("   ");
            for (int k=0; k < currentData.length-1; k++){
                sortLeft.add(currentData[k]);
                sortRight.add(currentData[k+1]);
            }
        }

        // for (int i = 0; i < sortRight.size()-1; i++){
        //      if(Integer.parseInt(sortRight.get(i)) > Integer.parseInt(sortRight.get(i+1))){
        //         String normal = sortRight.get(i);
        //         sortRight.set(i,sortRight.get(i+1));
        //        sortRight.set(i+1,normal);
        //        i=0;

        //    }
        //   }
        // System.out.println(sortRight);
        Collections.sort(sortRight);
        System.out.println(sortRight);
        Collections.sort(sortLeft);
        System.out.println(sortLeft);
        int sum =0;

        for(int i =0; i < sortLeft.size(); i++){
            int amt = 0;
            for(int k =0; k < sortRight.size(); k++){
                if (sortLeft.get(i).equals(sortRight.get(k))){
                    amt++;
                }
            }
            int total = amt * Integer.parseInt(sortLeft.get(i));
            sum += total;
        }
        System.out.println(sum);
    }

    public static ArrayList<String> getFileData(String fileName) {
        ArrayList<String> fileData = new ArrayList<String>();
        try {
            File f = new File(fileName);
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                if (!line.equals(""))
                    fileData.add(line);
            }
            return fileData;
        }
        catch (FileNotFoundException e) {
            return fileData;
        }
    }
}