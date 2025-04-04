import java.util.Date;
import java.text.SimpleDateFormat;

public class Hello {
    public static void main(String[] args) throws InterruptedException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        while (true){
            Thread.sleep(1000);
            System.out.println(dateFormat.format(new Date()));
        }
    }
}