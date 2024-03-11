import java.util.Scanner;

public class ReadData {
    public String[] readData(){
        Scanner scan = new Scanner(System.in);
        while(true){
            System.out.println("Введите ФИО, дата рождения, номер телефона и пол разделенные пробелом (Иванов Иван " +
                    "Иванович 01.01.2000 9009991122 муж)");
            String data = scan.nextLine();
            String[] arrData = data.split(" ");
            if (arrData.length == 6) {
                return arrData;
            }
            else if (arrData.length < 6){
                System.out.println("Вы ввели мало данных.");
            }
            else {
                System.out.println("Вы ввели данных больше, чем нужно.");
            }
        }
    }

}
