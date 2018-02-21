package com.github.ruananswer.anomaly;

import java.io.File;
import java.io.FileNotFoundException;
import com.github.ruananswer.anomaly.DetectAnoms;
import java.util.Scanner;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.lang.*;

public class Main1 
   {
      public static void main (String[] args) 
          {
             DetectAnoms detector = new DetectAnoms(new DetectAnoms.Config());
             Queue<Long> timestamp = new LinkedList<>();
             Queue<Double> value = new LinkedList<>();
             String fileName= "/Users/gokul-pt1831/Downloads/sample_input.csv";
             File file= new File(fileName);
             Scanner inputStream;
             int i=0;
             int c=0;
             try{
                  inputStream = new Scanner(file);
                     while(inputStream.hasNext())
                         {
                           String line= inputStream.next();
                           timestamp.add(Long.valueOf(line.split(",")[0]));
                           value.add(Double.valueOf(line.split(",")[1]));
                           i++;
                         }
              c=--i;
             inputStream.close();
                }
             catch (FileNotFoundException e) {
                   e.printStackTrace();
                }

             fileName= "/Users/gokul-pt1831/Downloads/test1.csv";
             file= new File(fileName);
        
             try{
                   inputStream = new Scanner(file);
                       while(inputStream.hasNext())
                           {
                             String line= inputStream.next(); 
                             timestamp.remove() ;
                             timestamp.add(Long.valueOf(line.split(",")[0]));
                             value.remove();
                             value.add(Double.valueOf(line.split(",")[1])); 
                             Long[] timestamps = timestamp.toArray(new Long[timestamp.size()]);
                             Double[] values = value.toArray(new Double[timestamp.size()]);
                   
                             i=0;
       
                             long[] timestamps1 = new long[timestamp.size()];
                             double[] values1 = new double[timestamp.size()];
                            
                             for(Long temp:timestamps)
                                 {
                                   timestamps1[i++] = temp;
                                   if(i==c)
                                   break;
                                 }
i=0;
for(Double temp:values)
{ values1[i++]=temp;
  if(i==c)
      break;
}
int d=0;
    DetectAnoms.ANOMSResult result = detector.anomalyDetection(timestamps1, values1);
        long[] resIndex = result.getAnomsIndex();
        for ( i = 0; i < resIndex.length;i++)
                {
                            int j = (int) resIndex[i];
                                if(timestamps1[timestamps1.length-2]==timestamps1[j])
                                { System.out.println(timestamps1[timestamps1.length-2]+"   " +values1[timestamps1.length-2] + "  Anomaly");
                                 d=1;}
                }
           if(d==0)
            System.out.println(timestamps1[timestamps1.length-2]+"   " +values1[timestamps1.length-2] + "  Normal"); 
          long startTime =System.currentTimeMillis();
          long currentTime =startTime;
          while(currentTime<startTime+100){
                  currentTime =System.currentTimeMillis();
                  }
            }}catch (FileNotFoundException e) {e.printStackTrace(); }
    }
}
