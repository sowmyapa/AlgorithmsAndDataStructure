package com.problem1.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by sowmyaparameshwara on 8/21/17.
 * http://www.geeksforgeeks.org/job-sequencing-problem-set-1-greedy-algorithm/
 * Input:
 5
 a 2 100
 b 1 19
 c 2 27
 d 1 25
 e 3 15
 3
 */
public class JobSequencing1 {

    public static void main(String[] args){
        JobSequencing1 jobSequencing1 = new JobSequencing1();
        jobSequencing1.schedule();
    }

    private void schedule() {
        Scanner in = new Scanner(System.in);
        int numberOfJobs = in.nextInt();
        in.nextLine();
        Job[] jobs = new Job[numberOfJobs];
        for(int i=0;i<numberOfJobs;i++){
            jobs[i] = new Job(in.next(),in.nextInt(),in.nextInt());
            in.nextLine();
        }
        int[] jobSchedule = new int[numberOfJobs];
        Arrays.fill(jobSchedule,-1);
        Arrays.sort(jobs, new Comparator<Job>() {
            @Override
            public int compare(Job o1, Job o2) {
                return o2.value.compareTo(o1.value);
            }
        });
        for(int i=0;i<jobs.length;i++){
            Job job = jobs[i];
            for(int j=Math.min(numberOfJobs,job.deadline)-1; j>=0;j--){
                if(jobSchedule[j]==-1) {
                    jobSchedule[j] = i;
                    break;
                }
            }


        }

        for(int i = 0; i <jobSchedule.length;i++){
            if(jobSchedule[i]!=-1)
                System.out.println(" Job with deadline "+jobs[jobSchedule[i]].name);
        }
    }


    class Job{
        String name;
        Integer deadline;
        Integer value;

        Job(String name,int deadline,int value){
            this.name = name;
            this.deadline = deadline;
            this.value = value;
        }
    }


}
