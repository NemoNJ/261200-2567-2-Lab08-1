import java.util.Random;
class NumberPrinter implements Runnable {
    private int threadNumber;
    private static final int MAX_NUMBER = 50;
    private static final Random random = new Random();

    public NumberPrinter(int threadNumber) {
        this.threadNumber = threadNumber;
    }

    @Override
    public void run() {
        for (int i = 1; i <= MAX_NUMBER; i++) {
            System.out.println("Thread #" + threadNumber + ": " + i);
            try {
                // ถ้าเราสังเกตก่อนเพิ่ม Thread.sleep() แต่ละ thread จะได้เร็วมากเหมือนไม่ใส่ delay เลย
                // เห็นได้ว่าตัวเลขจากแต่ละ  thread มันจะพิมพ์ติดกันเป็นพวงๆ รวมถึงการทำงานของ  thread ดูเหมือนจะไม่สลับกันชัดเจน
                Thread.sleep(random.nextInt(500)); // เราจะดีเลย์แบบสุ่มเพื่อจำลองการทำงานของเธรดยื่งdelay มากการกระจายจะดีมากขึ้น
                // จากการพบว่าสังเกตหลังจากเพิ่ม Thread.sleep() พบว่าลำดับการพิมพ์ของ thread เปลี่ยนไป
                // ถ้าสังเกคดีๆเห็นได้ว่าเลขของแต่ละ thread จะสลับกันมากขึ้น เนื่องจากมีการหยุดพักจาก sleep แบบสุ่มระหว่างการทำงาน
                // มันดูล้ายกับระบบที่มีการดำเนินงานแบบขนาน (parallelism)
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
