package com.company;

import java.io.*;
import java.util.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Reading data from a file
 */
public class XMLreader {
   //private static final String FILENAME = "src\\com\\company\\list";


    public static void main(String[] args) throws Exception {
        System.out.println("Введите имя файла");
        Scanner scanner=new Scanner(System.in);
        String FILENAME=scanner.nextLine();

        // Получение фабрики, чтобы после получить билдер документов.
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        // Получили из фабрики билдер, который парсит XML, создает структуру Document в виде иерархического дерева.
        DocumentBuilder builder = factory.newDocumentBuilder();
        FileInputStream fileInputStream=null;
        while (true) {
            try {
                fileInputStream = new FileInputStream(FILENAME);
                break;

            } catch (FileNotFoundException e) {
                System.out.println("Файл не найден, введите имя заново");
                FILENAME = scanner.nextLine();
                if (FILENAME.equalsIgnoreCase("exit"))System.exit(0);
            } catch (Exception ex) {
                System.out.println("Кажется у нас ошибка доступа, программа заканчивает работу");
                System.exit(0);
            }
        }

        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        // Запарсили XML, создав структуру Document. Теперь у нас есть доступ ко всем элементам, каким нам нужно.
        Document document=null;
        while (true) {
            try {
                document = builder.parse(bufferedInputStream);
                break;
            } catch (Exception e) {
                System.out.println("Введите имя заново или введите \"exit\"");
                FILENAME=scanner.nextLine();
                FILENAME=FILENAME.trim();
                if (FILENAME.equalsIgnoreCase("exit"))System.exit(0);
                try {

                    fileInputStream = new FileInputStream(FILENAME);
                    bufferedInputStream=new BufferedInputStream(fileInputStream);
                }
                catch (Exception exx){
                    System.out.println("Файл не может быть обработан или не найден");
                }

            }
        }
        // Получение списка всех элементов Student внутри корневого элемента (getDocumentElement возвращает ROOT элемент XML файла).
        Queue<StudyGroup> StudyGroupPriorityQueue=null;
        try {

            NodeList studentElements = document.getDocumentElement().getElementsByTagName("Student");


           StudyGroupPriorityQueue = new PriorityQueue<>(studentElements.getLength(), countComparator);
            // Перебор всех элементов Student
            for (int i = 0; i < studentElements.getLength(); i++) {
                Node student = studentElements.item(i);

                // Получение атрибутов каждого элемента
                NamedNodeMap attributes = student.getAttributes();


                // Добавление студента. Атрибут - Node, потому нам нужно получить значение атрибута с помощью метода getNodeValue()
                StudyGroupPriorityQueue.add(new StudyGroup(StudyGroupPriorityQueue, attributes.getNamedItem("name").getNodeValue(), attributes.getNamedItem("count").getNodeValue(), attributes.getNamedItem("exp").getNodeValue(),
                        attributes.getNamedItem("form").getNodeValue(), attributes.getNamedItem("semester").getNodeValue(), attributes.getNamedItem("groupAdmin").getNodeValue(), attributes.getNamedItem("height").getNodeValue(),
                        attributes.getNamedItem("weight").getNodeValue(), attributes.getNamedItem("eyeColor").getNodeValue(),
                        attributes.getNamedItem("X").getNodeValue(), attributes.getNamedItem("Y").getNodeValue()));


            }
        }catch (Exception e){
            System.out.println("Файл не может быть обработан, программа заканчивает работу");
            System.exit(0);
        }

Main.main(StudyGroupPriorityQueue);
    }


    //метод для обработки данных очереди
    static Comparator<StudyGroup>
            countComparator = new Comparator<StudyGroup>() {

        @Override
        public int compare(StudyGroup c1, StudyGroup c2) {
            return (int) (c1.getStudentsCount() - c2.getStudentsCount());
        }
    };


    public static  void pollDataFromQueue(Queue<StudyGroup> StudyGroupPriorityQueue) {

        for (StudyGroup student:StudyGroupPriorityQueue)
           System.out.println("Имя: " + student.getName() + " Номер:" + student.getStudentsCount() + " " + student.getexp() + " Форма обучения: " + student.getFormOfEducation() + " Id: " + student.getId()+" Имя админа: "+ student.getAdminName()
                  + " Рост админа: " + student.getHeight() + " Вес админа: " + student.getWeight() + " Цвет глаз админа: " + student.getColor() + " Координата X: " + student.getCoordinatesX() + " Координата Y: " + student.getCoordinatesY());
        }

    }




