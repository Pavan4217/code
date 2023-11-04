import java.util.Scanner;
class CourseException extends Exception{
    CourseException(String msg){
        super(msg);
    }
    CourseException(){
        super("CourseException");
    }
}
class Course{
    //c-> courses in all variables
    String cdept;
    int cnum=0;
    double ccredits=0;
    Course(String a,int b,double c){
        cdept=a;
        cnum=b;
        ccredits=c;
    }
}
public class CourseExceptionTest {
    public static void main(String[]args){
        Scanner s=new Scanner(System.in);
        Course[] carr=new Course[6];
        for (int i=0;i<carr.length;i++){
            try {
                System.out.print("Enter the Course Department : ");
                String name = s.next();
                try {
                    if (name.length() != 3) {
                        throw new CourseException("Course Name should be of length 3 only.");
                    }
                } catch (CourseException ce) {
                    while(name.length()!=3) {
                        System.out.println("Course Exception " + ce.getMessage());
                        System.out.print("Enter the Course Department : ");
                        name = s.next();
                    }
                }
                System.out.println("Enter Course Number :");
                int num=s.nextInt();
                try{
                    if (num<1001 ||num>9999){
                        throw new CourseException("Course Number should lie between 1001 and 9999 ");
                    }
                }catch(CourseException ce){
                    while(num<1001 || num>9999) {
                        System.out.println("Course Exception " + ce.getMessage());
                        System.out.println("Enter Course Number :");
                        num = s.nextInt();
                    }
                }
                System.out.println("Enter course credits : ");
                double cred=s.nextDouble();
                try{
                    if (cred<1 ||cred>6){
                        throw new CourseException("Credits should be lie in range of 1 to 6 only");
                    }
                }catch(CourseException ce){
                    while(cred<1 ||cred>6) {
                        System.out.println("Course Exception " + ce.getMessage());
                        System.out.println("Enter course credits : ");
                        cred = s.nextDouble();
                    }
                }
                carr[i]= new Course(name,num,cred);
                System.out.println("Course object successfully created.");
                System.out.println("------------------------------------------------------");
            }catch(Exception e){
                System.out.println("Exception Handled"+e);
            }
        }
        for(int j=0;j<carr.length;j++){
            if (carr[j]!=null) {
                System.out.println("Course Name : " + carr[j].cdept);
                System.out.println("Course Number : " + carr[j].cnum);
                System.out.println("Course Credits : " + carr[j].ccredits);
                System.out.println("------------------------------------------------------");
            }
            else {
                break;
            }
        }
        System.out.println("I am here bro");
    }
}
