import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class TwitterSolution2 {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        TwitterSolution2 s = new TwitterSolution2();
        s.compute();
    }

    private void compute() throws ParseException {
        Scanner in = new Scanner(System.in);

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM");

        String input = in.nextLine();
        String[] dates=input.split(",");
        Date startDate,endDate;
        startDate= formatter.parse(dates[0]);
        endDate= formatter.parse(dates[1]);
        if(startDate.after(endDate)){
            Date temp = startDate;
            startDate=endDate;
            endDate=temp;
        }

        in.nextLine();
        TreeMap<Date,TreeMap<String,Integer>> map = new  TreeMap<Date,TreeMap<String,Integer>>(Collections.reverseOrder());
        while(in.hasNextLine()){
            input = in.nextLine();
            String[] inputData=input.split(",");
            Date date = formatter.parse(inputData[0]);

            if(map.containsKey(date)){
                TreeMap<String,Integer> values = map.get(date);
                if(values.containsKey(inputData[1])){
                    int newRes=values.get(inputData[1])+Integer.parseInt(inputData[2].substring(1));
                    values.put(inputData[1],newRes);

                }else{
                    TreeMap<String,Integer> newMap = map.get(date);
                    newMap.put(inputData[1],Integer.parseInt(inputData[2].substring(1)));
                    map.put(date,newMap);

                }
            }else{
                TreeMap<String,Integer> newMap = new TreeMap<String,Integer>();
                newMap.put(inputData[1],Integer.parseInt(inputData[2].substring(1)));

                map.put(date,newMap);

            }


        }

        for(Iterator<Date> it = map.keySet().iterator(); it.hasNext();) {
            Date key = it.next();
            if(!key.before(startDate) && !key.after(endDate)){
                TreeMap<String,Integer> valueMap = map.get(key);
                System.out.print(""+new SimpleDateFormat("yyyy-MM").format(key));
                for(Iterator<String> it1 = valueMap.keySet().iterator(); it1.hasNext();) {
                    String type = it1.next();


                    System.out.print(","+type+", "+valueMap.get(type));

                }
                System.out.println();
            }


        }

    }
}