package com.javarush.test.level20.lesson02.task02;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* Читаем и пишем в файл: JavaRush
Реализуйте логику записи в файл и чтения из файла для класса JavaRush
В файле your_file_name.tmp может быть несколько объектов JavaRush
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
           // File your_file_name = File.createTempFile("your_file_name", null);
            String your_file_name="C:\\Users\\Алина\\Desktop\\qwe.txt";
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            JavaRush javaRush = new JavaRush();
            User users=new User();
            users.setFirstName("FirstName");
            users.setLastName("LastName");
            users.setBirthDate(new Date(02/02/1987));
            users.setMale(true);
            users.setCountry(User.Country.UKRAINE);
            javaRush.users.add(users);

            User user1=new User();
            users.setFirstName("Name");
            users.setLastName("Name");
            users.setBirthDate(new Date(03/02/1987));
            users.setMale(false);
            users.setCountry(User.Country.RUSSIA);
            javaRush.users.add(user1);

            User user2=new User();
            users.setFirstName("First");
            users.setLastName("Last");
            users.setBirthDate(new Date(04/02/1987));
            users.setMale(true);
            users.setCountry(User.Country.OTHER);
            javaRush.users.add(user2);
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            System.out.println(javaRush.equals(loadedObject));
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            SimpleDateFormat dateFormat=new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
            PrintWriter writer=new PrintWriter(outputStream);
           // String isGood=(!users.isEmpty() ? "yes":"no");
          //  writer.println(isGood);
            if(this.users !=null){
                for(User u:users){
                    writer.println(u.getFirstName());
                    writer.println(u.getLastName());
                    writer.println(dateFormat.format(u.getBirthDate()));
                    writer.println(u.isMale());
                    writer.println(u.getCountry().getDisplayedName());
                }

            }
            writer.close();
            //implement this method - реализуйте этот метод
        }

        public void load(InputStream inputStream) throws Exception {
            BufferedReader reader=new BufferedReader(new InputStreamReader(inputStream));
            SimpleDateFormat dateFormat=new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
           // String isgood=reader.readLine();
          //  if(isgood.equals("yes")){

                    while((reader.ready())){
                        User user=new User();
                        user.setFirstName(reader.readLine());
                        user.setLastName(reader.readLine());
                        user.setBirthDate(dateFormat.parse(reader.readLine()));
                        user.setMale(Boolean.parseBoolean(reader.readLine()));
                        String countries = reader.readLine();
                        switch (countries) {
                            case "Ukraine":
                                user.setCountry(User.Country.UKRAINE);
                                break;
                            case "Russia":
                                user.setCountry(User.Country.RUSSIA);
                                break;
                            default:
                                user.setCountry(User.Country.OTHER);
                                break;
                        }

                        this.users.add(user);
                    }
         //   }
            reader.close();
            //implement this method - реализуйте этот метод
        }
    }
}
