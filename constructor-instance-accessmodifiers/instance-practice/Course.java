public class Course {
    private String coursename;
    private String duration;
    private double fee;
    private static String institutename="ABC";

    Course(String coursename,String duration,double fee){
        this.coursename=coursename;
        this.duration=duration;
        this.fee=fee;
    }
    
    public void displayCourseDetails(){
        System.out.println("Course Name: "+coursename);
        System.out.println("Duration: "+duration);
        System.out.println("Fee: "+fee);
        System.out.println("Institute name: "+institutename);
    }

    public void updateInstituteName(String name){
        institutename=name;
    }
    public static void main(String[] args) {
        Course obj=new Course("CSE","4 years",80000);
        obj.displayCourseDetails();
        obj.updateInstituteName("AB");

    }
}
