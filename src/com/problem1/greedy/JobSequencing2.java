package com.problem1.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by sowmyaparameshwara on 8/21/17.
 * http://www.geeksforgeeks.org/job-sequencing-using-disjoint-set-union/
 * Input:
 5
 a 2 100
 b 1 19
 c 2 27
 d 1 25
 e 3 15
 3
 */
public class JobSequencing2 {

    public static void main(String[] args){
        JobSequencing2 jobSequencing1 = new JobSequencing2();
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

        int maxDeadline = findMaxDeadline(jobs);
        DisjoinSet disjoinSet = new DisjoinSet(maxDeadline);
        for(int i=0;i<jobs.length;i++){
            Job job = jobs[i];
            int slot = disjoinSet.findParent(job.deadline);
            if(slot>0){
                disjoinSet.merge(disjoinSet.findParent(slot-1),slot);
                System.out.println("Executing job: "+job.name+" on slot: "+slot);
            }

        }

    }

    private int findMaxDeadline(Job[] jobs) {
        int max =1;
        for(Job job: jobs){
            max = Math.max(max,job.deadline);
        }
        return max;
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


    class DisjoinSet{

        int[] parent;

        DisjoinSet(int n){
            parent = new int[n+1];
            for(int i=0;i<=n;i++){
                parent[i] = i;
            }
        }

        int findParent(int s){
            if(s==parent[s]){
                return s;
            }
            return findParent(parent[s]);
        }

        void merge(int newParent, int child){
            parent[child] = newParent;
        }

    }


}
