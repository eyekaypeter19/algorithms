package MergeIntervals;

import java.util.*;

class Job {
    int start;
    int end;
    int cpuLoad;

    public Job(int start, int end, int cpuLoad) {
        this.start = start;
        this.end = end;
        this.cpuLoad = cpuLoad;
    }
};

class MaximumCPULoad {

    public static int findMaxCPULoad(List<Job> jobs) {
        if(jobs == null || jobs.size() == 0)
            return 0;
        if (jobs.size() == 1) {
            return jobs.get(0).cpuLoad;
        }
        int maximumCPULoad = Integer.MIN_VALUE;

        jobs.sort((a,b) -> Integer.compare(a.start, b.start));
        ListIterator<Job> jobIterator = jobs.listIterator();
        Job firstJob = jobIterator.next();
        int currentCpuLoad = firstJob.cpuLoad;
        while(jobIterator.hasNext()) {
           Job currentJob = jobIterator.next();
           //does this job intersect with the former one
           if(firstJob.end < currentJob.start) {
                currentCpuLoad -= firstJob.cpuLoad;
                currentCpuLoad += currentJob.cpuLoad;
                firstJob = currentJob;
               maximumCPULoad = Math.max(maximumCPULoad, currentCpuLoad);
           } else {
               //The jobs intersect and we need to add the cpu loads
               currentCpuLoad += currentJob.cpuLoad;
               maximumCPULoad = Math.max(currentCpuLoad, maximumCPULoad);
               firstJob.start = Math.min(firstJob.start, currentJob.start);
               firstJob.end = Math.max(firstJob.start, currentJob.end);
               firstJob.cpuLoad = firstJob.cpuLoad + currentJob.cpuLoad;
           }
        }
        return maximumCPULoad;
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
