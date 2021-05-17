import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class JobsDataService {
    public static void main(String[] args) {

    }

    /**
     * This function iterates throw the jobs, then calculates
     * the frequency of a job title, then prints every title and
     * its frequency.
     * @param jobs list of jobs
     */
    public static void FilterByTitle(List<JobDetails> jobs){
        var jobsMap = new HashMap<String, Integer>();
        jobs.forEach(job -> {
            String title =  job.getTitle();
            jobsMap.put(title, jobsMap.containsKey(title) ? jobsMap.get(title)+1 : 1);
        });

        var i = jobsMap.entrySet().iterator();
        while (i.hasNext()){
            var item = i.next();
            System.out.println(item.getKey() + " : " + item.getValue());
        }
    }

    /**
     * This function iterates throw the jobs, then calculates
     * the frequency of a jobs inside the country,
     * then prints every country and its job frequency.
     * @param jobs
     */
    public static void FilterJobsByCountry(List <JobDetails> jobs){

        var jobsMap = new HashMap<String, Integer>();
        jobs.forEach(job -> {
            String country =  job.getCountry();
            jobsMap.put(country, jobsMap.containsKey(country) ? jobsMap.get(country)+1 : 1);
        });

        var i = jobsMap.entrySet().iterator();
        while (i.hasNext()){
            var item = i.next();
            System.out.println(item.getKey() + " : " + item.getValue());
        }
    }

    public static void FilterJobsByLevel(List <JobDetails> jobs){
        var jobsMap = new HashMap<String, Integer>();
        jobs.forEach(job -> {
            String level =  job.getLevel();
            jobsMap.put(level, jobsMap.containsKey(level) ? jobsMap.get(level)+1 : 1);
        });

        var i = jobsMap.entrySet().iterator();
        while (i.hasNext()){
            var item = i.next();
            System.out.println(item.getKey() + " : " + item.getValue());
        }
    }

    public static LinkedHashMap<String, Long> sortMap(Map<String, Long> map){
        var linkedHashMap = new LinkedHashMap<String, Long>(map);
        linkedHashMap.entrySet().stream().sorted(Map.Entry.comparingByValue());
        return  linkedHashMap;
    }

    public static void FilterJobsByYearsExp(List <JobDetails> jobs){
        var jobsMap = new HashMap<String, Integer>();
        jobs.forEach(job -> {
            String yearsExp =  job.getYearsExp();
            jobsMap.put(yearsExp, jobsMap.containsKey(yearsExp) ? jobsMap.get(yearsExp)+1 : 1);
        });
        var sortedJobsMap = sortMap((Map)jobsMap);
        System.out.println(sortedJobsMap);
    }
}
