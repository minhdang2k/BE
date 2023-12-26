package Lab10b.Ex1;

import java.util.Scanner;

public class DictionaryApplication {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        Word<String,String>[] words = new Word[2];

           new Word<>("EngLish", "Tiếng Anh");
           new Word<>("Vietnamese", "Tiếng Viet");

        Dictionary<String,String> dictionary= new Dictionary<>(words);
        boolean isRunning= true;
        do {
            System.out.println("Nhập từ bạn muốn biết nghĩa");
            String language=scanner.nextLine();
            String result= dictionary.findword(language);
            if (result!=null){
                System.out.println(result);
            } else if (result.equals("quit")) {
                isRunning=false;
            } else {
                System.err.println("Chưa có dữ liệu về ngôn ngữ, hãy chọn từ khác");
            }
            System.out.println("Nhập quit để kết thúc");

        }while (isRunning);
        scanner.close();
    }
}
