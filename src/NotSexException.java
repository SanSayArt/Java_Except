public class NotSexException extends Exception{
    public NotSexException(){
    }
    public void notSexException(String str){
        System.out.println("Exception: Пол указан не правильно");
        System.out.printf("Это не правильный вид: %s", str);
        System.out.println();
    }
}
