import java.util.Random;
public class Main {
    public static void main(String[] args) {
        // สร้างเธรด 3 ตัว
        Thread t1 = new Thread(new NumberPrinter(1));
        Thread t2 = new Thread(new NumberPrinter(2));
        Thread t3 = new Thread(new NumberPrinter(3));

        t1.start();
        t2.start();
        t3.start();
    }
}
//ข้อมูลบางส่วนขออ้างอิงจาก internet นะครับ
// Java ใช้ Thread Scheduling ของ JVM ซึ่งทำให้เธรดสามารถทำงานพร้อมกันได้
// การสลับการทำงานของเธรดขึ้นอยู่กับตัวจัดการเธรดของระบบปฏิบัติการ
// ดังนั้นทุกครั้งที่รันโปรแกรม มีความเป็นไปได้ว่าจะได้ผลลัพธ์ที่แตกต่างกันขึ้นอยู่กับการจัดสรรเธรดในขณะนั้น จริงๆง่ายๆก็คือ มัน random
