import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadJobDetailsDataSet {
    private static final int NUMBER_OF_COLUMNS = 8;
    private List<JobDetails> jobDetailsList;
    private String path;
    public ReadJobDetailsDataSet(){
        jobDetailsList = new ArrayList<JobDetails>();
    }
    public List<JobDetails> ReadCSVFile(String FileName) {
        path = FileName;
        try (BufferedReader br = new BufferedReader(new FileReader(getPath()))) {
            // read the first line from the text file which will be head column
            String line = br.readLine();
            // loop until all lines are read
            if (line != null) {
                line = br.readLine(); // the first real data
            }
            while (line != null) {
                String[] l = line.split(",");
                String[] attributes = cleanAttribute(l);

                JobDetails pyr = createJobDetails(attributes);
                jobDetailsList.add(pyr);

                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return getJobDetailsList();
    }
    public void setPath(String path) {
        this.path = path;
    }
    private JobDetails createJobDetails(String[] attributes) {
        var jobDetails = new JobDetails();
        jobDetails.setTitle(attributes[0]);
        jobDetails.setCompany(attributes[1]);
        jobDetails.setLocation(attributes[2]);
        jobDetails.setType(attributes[3]);
        jobDetails.setLevel(attributes[4]);
        jobDetails.setYearsExp(attributes[5]);
        jobDetails.setCountry(attributes[6]);
        jobDetails.setSkills(attributes[7]);
        return jobDetails;
    }
    private String[] cleanAttribute(String[] arr){
        String[] result = new String[NUMBER_OF_COLUMNS];
        for (int i = 0; i < 7; i++) {
            result[i] = arr[i];
        }
        result[7] = "";
        for (int i = 7; i < arr.length; i++) {
            result[7] += arr[i];
        }
        return result;
    }
    public List<JobDetails> getJobDetailsList() {
        return jobDetailsList;
    }
    private String getPath() {
        return this.path;
    }
}
