public class NotDataException extends Exception{
    public NotDataException(){
    }
    public void notDataException(String str){
        System.out.println("Exception: Введенные данные не соответствуют формату");
        System.out.printf("Это не правильный вид: %s", str);
        System.out.println();
    }
}
