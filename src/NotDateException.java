public class NotDateException extends Exception{
    public NotDateException(){
    }
    public void notDateException(String str){
        System.out.println("Exception: Ошибка при вводе даты");
        System.out.printf("Правильный вид: %s", str);
        System.out.println();
    }
}
