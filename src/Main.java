import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        ParseData parsData = new ParseData();
        String newFileName = null;
        WriteFile writeFile = new WriteFile();
        HashMap<String, Object> data = parsData.parsData();
        while (data.size() != 6) {
            try {
                throw new NotDataException();
            } catch (NotDataException e) {
                data = parsData.parsData();
            }
        }

        newFileName = data.get("lastName") + ".txt";
        StringBuilder sb = new StringBuilder();
        for (String str : data.keySet()) {
            sb.append(data.get(str));
            sb.append(" ");
        }

        System.out.println(data);
        String filePath = newFileName;
        System.out.println(filePath);
        writeFile.writeData(String.valueOf(sb), filePath);

    }
}