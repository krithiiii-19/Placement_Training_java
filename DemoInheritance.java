import java.util.Arrays;

class Store {
    String[] feedbacks={};
    public void viewAllFeedBacks(){
        System.out.println(Arrays.toString(feedbacks));
    }
}
class JavaBatch extends Store{
    String expertName="";
    public JavaBatch(int size){
        feedbacks=new String[size];
    }
    public void addFeedBack(String comments){
        for(int index=0;index<feedbacks.length;index++)
            if(feedbacks[index]==null|feedbacks[index]==""){
                feedbacks[index]=comments;
                System.out.println("Feedback noted");return;
            }
            System.out.println("Buffer is full can't add your feedback");
            }
    }
    class SoftskillBatch extends Store{
        public SoftskillBatch(){
            feedbacks=new String[]{
                "Training is good","Body language learned","Need to slow the pace"};
            }
            public void read(int index){
                if(index<0||index>=feedbacks.length)
                    System.out.println("Invalid Feedback");
                else
                    System.out.println(feedbacks[index]);
            }
        }
        public class DemoInheritance {
            public static void main(String[] args) {
                JavaBatch java=new JavaBatch(2);
                java.expertName="Razak Mohamed";
                java.addFeedBack("Expected Foundations not Advanced");
                java.addFeedBack("Need more time to write code");
                java.addFeedBack("Array concept quite difficult");
                java.viewAllFeedBacks();
                SoftskillBatch soft = new SoftskillBatch();
                soft.read(9);
                soft.viewAllFeedBacks();


            }
        }   