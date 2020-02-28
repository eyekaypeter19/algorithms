package MergeIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

//implementation with priority queue
public class MaximumCPULoad2 {

    public static int findMaxCPULoad(List<Job> jobs) {
        if (jobs == null  || jobs.isEmpty())
            return 0;
        if (jobs.size() == 1)
            return jobs.get(0).cpuLoad;

        int maximumCpuLoad = 0;
        int currentCPULoad = 0;
        jobs.sort((a, b) -> Integer.compare(a.start, b.start));
        PriorityQueue<Job> jobQueue = new PriorityQueue<>((a,b) -> Integer.compare(a.end, b.end));
        for(Job job : jobs) {
            //all the meetings that have ended
            while(!jobQueue.isEmpty() && jobQueue.peek().end > job.start) {
                currentCPULoad -= jobQueue.poll().cpuLoad;
            }
            jobQueue.offer(job);
            currentCPULoad += job.cpuLoad;
            maximumCpuLoad = Math.max(maximumCpuLoad, currentCPULoad);
        }
        return maximumCpuLoad;
    }

    public static void main(String[] args) {
        List<Job> input = new ArrayList<Job>(Arrays.asList(new Job(1, 4, 3), new Job(2, 5, 4), new Job(7, 9, 6)));
        System.out.println("Maximum CPU load at any time: " + MaximumCPULoad.findMaxCPULoad(input));

        input = new ArrayList<Job>(Arrays.asList(new Job(6, 7, 10), new Job(2, 4, 11), new Job(8, 12, 15)));
        System.out.println("Maximum CPU load at any time: " + MaximumCPULoad.findMaxCPULoad(input));

        input = new ArrayList<Job>(Arrays.asList(new Job(1, 4, 2), new Job(2, 4, 1), new Job(3, 6, 5)));
        System.out.println("Maximum CPU load at any time: " + MaximumCPULoad.findMaxCPULoad(input));
    }
}
