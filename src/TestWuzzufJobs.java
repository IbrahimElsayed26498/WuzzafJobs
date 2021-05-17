public class TestWuzzufJobs {
    public static void main(String[] args) {
        test();
    }
    public static void test(){
        // test filter by title
        JobsDataService.FilterByTitle(new ReadJobDetailsDataSet().ReadCSVFile("Wuzzuf_Jobs.csv"));
        // test filter by Country
        JobsDataService.FilterJobsByCountry(
                new ReadJobDetailsDataSet().ReadCSVFile("Wuzzuf_Jobs.csv"));
        // test filter by Level
        JobsDataService.FilterJobsByLevel(
                new ReadJobDetailsDataSet().ReadCSVFile("Wuzzuf_Jobs.csv"));
        // test filter by years of experience
        JobsDataService.FilterJobsByYearsExp(
                new ReadJobDetailsDataSet().ReadCSVFile("Wuzzuf_Jobs.csv"));
    }
}

