import java.util.HashMap;
import java.util.Objects;

public class ParseData {
    public HashMap<String, Object> parsData(){
        ReadData readData = new ReadData();
        String[] data = readData.readData();
        HashMap<String, Object> dictData = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        for (String i : data) {
            if (i.length() == 1) {
                if (i.equals("женский") || i.equals("мужской")) {
                    dictData.put("sex", i);
                } else{
                    try {
                        throw new NotSexException();
                    } catch (NotSexException e) {
                        e.notSexException(i);
                    }
                }
            } else if (i.matches("\\d{1,2}\\.\\d{1,2}\\.\\d{4}")) {
                String[] arrayDate = i.split("\\.");
                boolean flag = true;
                if (Integer.parseInt(arrayDate[0]) < 0 ||
                        Integer.parseInt(arrayDate[0]) > 31 || Integer.parseInt(arrayDate[1]) < 0 ||
                        Integer.parseInt(arrayDate[1]) > 12 || Integer.parseInt(arrayDate[2]) < 0 ||
                        Integer.parseInt(arrayDate[1]) > 2022) {
                    try {
                        throw new NotDateException();
                    } catch (NotDateException e) {
                        e.notDateException(i);
                    }
                } else {
                    if (Integer.parseInt(arrayDate[2]) % 4 == 0) {
                        if (Integer.parseInt(arrayDate[1]) == 1 ||
                                Integer.parseInt(arrayDate[1]) == 3 ||
                                Integer.parseInt(arrayDate[1]) == 5 ||
                                Integer.parseInt(arrayDate[1]) == 7 ||
                                Integer.parseInt(arrayDate[1]) == 9 ||
                                Integer.parseInt(arrayDate[1]) == 10 ||
                                Integer.parseInt(arrayDate[1]) == 12) {
                            if (Integer.parseInt(arrayDate[0]) < 32) {
                                flag = false;
                            }
                        } else if (Integer.parseInt(arrayDate[1]) == 2) {
                            if (Integer.parseInt(arrayDate[0]) < 30) {
                                flag = false;
                            }
                        } else if (Integer.parseInt(arrayDate[1]) == 4 ||
                                Integer.parseInt(arrayDate[1]) == 6 ||
                                Integer.parseInt(arrayDate[1]) == 8 ||
                                Integer.parseInt(arrayDate[1]) == 11) {
                            if (Integer.parseInt(arrayDate[0]) < 31) {
                                flag = false;
                            }
                        }
                    } else {
                        if (Integer.parseInt(arrayDate[1]) == 1 ||
                                Integer.parseInt(arrayDate[1]) == 3 ||
                                Integer.parseInt(arrayDate[1]) == 5 ||
                                Integer.parseInt(arrayDate[1]) == 7 ||
                                Integer.parseInt(arrayDate[1]) == 9 ||
                                Integer.parseInt(arrayDate[1]) == 10 ||
                                Integer.parseInt(arrayDate[1]) == 12) {
                            if (Integer.parseInt(arrayDate[0]) < 32) {
                                flag = false;
                            }
                        } else if (Integer.parseInt(arrayDate[2]) == 2) {
                            if (Integer.parseInt(arrayDate[0]) < 29) {
                                flag = false;
                            }
                        } else if (Integer.parseInt(arrayDate[1]) == 4 ||
                                Integer.parseInt(arrayDate[1]) == 6 ||
                                Integer.parseInt(arrayDate[1]) == 8 ||
                                Integer.parseInt(arrayDate[1]) == 11) {
                            if (Integer.parseInt(arrayDate[0]) < 31) {
                                flag = false;
                            }
                        }

                    }
                    if (!flag) {
                        dictData.put("date", i);
                    } else try {
                        throw new NotDataException();
                    } catch (NotDataException e) {
                        e.notDataException(i);
                    }
                }

            } else if (i.matches("[0-9]+")) {
                dictData.put("tel", i);
            } else if (i.matches("[A-Za-z]+")) {
                sb.append(i + " ");
            } else {
                try {
                    throw new NotDataException();
                } catch (NotDataException e) {
                    e.notDataException(i);
                }
            }
        }
        String[] fullName = String.valueOf(sb).split(" ");
        if (fullName.length == 3) {
            dictData.put("firstName", fullName[1]);
            dictData.put("lastName", fullName[0]);
            dictData.put("patronymic", fullName[2]);
        }
        return dictData;
    }
}
