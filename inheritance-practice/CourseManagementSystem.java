class Course {
    protected String courseName;
    protected int duration;

    public Course(String courseName, int duration) {
        this.courseName = courseName;
        this.duration = duration;
    }

    public void displayDetails() {
        System.out.println("Course: " + courseName);
        System.out.println("Duration: " + duration + " weeks");
    }
}


class OnlineCourse extends Course {
    protected String platform;
    protected boolean isRecorded;

    public OnlineCourse(String courseName, int duration, String platform, boolean isRecorded) {
        super(courseName, duration);
        this.platform = platform;
        this.isRecorded = isRecorded;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Platform: " + platform);
        System.out.println("Recorded: " + (isRecorded ? "Yes" : "No"));
    }
}

class PaidOnlineCourse extends OnlineCourse {
    private double fee;
    private double discount;

    public PaidOnlineCourse(String courseName, int duration, String platform, boolean isRecorded, double fee, double discount) {
        super(courseName, duration, platform, isRecorded);
        this.fee = fee;
        this.discount = discount;
    }

    public double getDiscountedFee() {
        return fee - (fee * discount / 100);
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Course Fee: " + fee);
        System.out.println("Discount: " + discount + "%");
        System.out.println("Final Price After Discount: $" + getDiscountedFee());
    }
}

public class CourseManagementSystem {
    public static void main(String[] args) {
        Course basicCourse = new Course("Java Basics", 4);
        OnlineCourse onlineCourse = new OnlineCourse("Advanced Java", 6, "Udemy", true);
        PaidOnlineCourse paidCourse = new PaidOnlineCourse("Full-Stack Web Development", 12, "Coursera", true, 299.99, 20);

        System.out.println("Course Details:\n");
        basicCourse.displayDetails();
        System.out.println();
        onlineCourse.displayDetails();
        System.out.println();
        paidCourse.displayDetails();
    }
}
