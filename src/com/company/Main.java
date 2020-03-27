package com.company;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.filter.ElementFilter;
import org.jdom2.input.SAXBuilder;

import javax.swing.plaf.IconUIResource;
import java.io.*;
import java.util.*;
import java.util.List;

import static javax.script.ScriptEngine.FILENAME;

/**
 * The class processes input data
 */
public class Main {
    // private static Queue<StudyGroup> StudyGroupPriorityQueue;
    public static void main(Queue<StudyGroup> StudyGroupPriorityQueue) throws Exception {

//name,35,yes,full time,5,bor,170,76,red,23,45
        // команды и их обработка
        //  AllCmd.add("name","b5","yes","full time","5","name2","23","45","red","5","6",StudyGroupPriorityQueue);
        Scanner scanner1 = new Scanner(System.in);
        String cmd = "";
        while (cmd.equalsIgnoreCase("exit") != true) {
            cmd = scanner1.nextLine();
            cmd = cmd.trim();
            if (cmd.equalsIgnoreCase("help") == true) {
                AllCmd.help();
            } else {
                if (cmd.equalsIgnoreCase("info") == true) {
                    AllCmd.info(StudyGroupPriorityQueue);
                } else {
                    if (cmd.lastIndexOf("add") != -1) {
                        cmd.replace(" ", "");
                        //  int index1=cmd.lastIndexOf("{");
                        // int index2=cmd.lastIndexOf("}");
                        // String str=cmd.substring(index1,index2);
                        //  System.out.println("Введите через запятую в нужном порядке следующие данные: имя, номер, отчислен ли студент(yes/no), форма обучения(full time, evening, distance), номер сместра(5,6,7,8), имя админа группы" +
                        //         ", высоту, вес, цвет глаз(red, black brown, orange), X, Y");
                        String substr[] = new String[12];
                        Scanner scanner = new Scanner(System.in);

                        System.out.println("Введите имя");
                        substr[0] = scanner.nextLine();
                        System.out.println("Введите номер");

                        substr[1] = scanner.nextLine();
                        long check;
                        while (true) {
                            try {
                                check = Long.parseLong(substr[1]);
                                break;
                            } catch (NumberFormatException e) {
                                System.out.println("неправильный ввод,попробуем еще раз");
                                substr[1] = scanner.nextLine();
                            }
                        }

                        System.out.println("Введите отчислен ли студент(yes/no)");
                        substr[2] = scanner.nextLine();
                        substr[2] = substr[2].trim();
                        while (true) {
                            if (substr[2].equalsIgnoreCase("yes")) break;
                            else {
                                if (substr[2].equalsIgnoreCase("no")) break;
                                else System.out.println("неправильный ввод,попробуем еще раз");
                                substr[2] = scanner.nextLine();
                            }
                        }
                        System.out.println("Введите форму обучения(full time, evening, distance)");
                        substr[3] = scanner.nextLine();
                        substr[3] = substr[3].trim();
                        while (true) {
                            if (substr[3].equalsIgnoreCase("full time")) break;
                            else {
                                if (substr[3].equalsIgnoreCase("evening")) break;
                                else {
                                    if (substr[3].equalsIgnoreCase("distance")) break;
                                    else System.out.println("неправильный ввод,попробуем еще раз");
                                    substr[3] = scanner.nextLine();
                                }
                            }
                        }
                        System.out.println("Введите номер семестра");
                        substr[4] = scanner.nextLine();
                        substr[4] = substr[4].trim();
                        while (true) {
                            try {
                                int check1 = Integer.parseInt(substr[4]);
                                if (check1 >= 5 & check1 <= 8) break;
                                else {
                                    System.out.println("неправильный ввод,попробуем еще раз");
                                    substr[4] = scanner.nextLine();
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("неправильный ввод,попробуем еще раз");
                                substr[4] = scanner.nextLine();
                            }
                        }
                        System.out.println("Введите имя админа группы");
                        substr[5] = scanner.nextLine();
                        System.out.println("Введите высоту");
                        substr[6] = scanner.nextLine();
                        substr[6] = substr[6].trim();
                        while (true) {
                            try {
                                Double check2 = Double.parseDouble(substr[6]);
                                break;
                            } catch (NumberFormatException e) {
                                System.out.println("неправильный ввод,попробуем еще раз");
                                substr[6] = scanner.nextLine();
                            }
                        }
                        System.out.println("Введите вес");
                        substr[7] = scanner.nextLine();
                        while (true) {
                            try {
                                Integer check3 = Integer.parseInt(substr[7]);
                                break;
                            } catch (NumberFormatException e) {
                                System.out.println("неправильный ввод,попробуем еще раз");
                                substr[7] = scanner.nextLine();
                            }
                        }
                        System.out.println("Введите цвет глаз(red, black, brown, orange)");
                        substr[8] = scanner.nextLine();
                        substr[8].trim();
                        while (true) {
                            if (substr[8].equalsIgnoreCase("red")) break;
                            else {
                                if (substr[8].equalsIgnoreCase("black")) break;
                                else {
                                    if (substr[8].equalsIgnoreCase("brown")) break;
                                    else {
                                        if (substr[8].equalsIgnoreCase("orange")) break;
                                        else System.out.println("неправильный ввод,попробуем еще раз");
                                        substr[8] = scanner.nextLine();
                                    }
                                }
                            }
                        }
                        System.out.println("Введите X");
                        substr[9] = scanner.nextLine();
                        substr[9] = substr[9].trim();
                        while (true) {
                            try {
                                Float check4 = Float.parseFloat(substr[9]);
                                break;
                            } catch (NumberFormatException e) {
                                System.out.println("неправильный ввод,попробуем еще раз");
                                substr[9] = scanner.nextLine();
                            }
                        }
                        System.out.println("Введите Y");
                        substr[10] = scanner.nextLine();
                        substr[10] = substr[10].trim();
                        while (true) {
                            try {
                                long check5 = Long.valueOf(substr[10]);
                                break;
                            } catch (NumberFormatException e) {
                                System.out.println("неправильный ввод,попробуем еще раз");
                                substr[10] = scanner.nextLine();
                            }
                        }

                        AllCmd.add(substr[0], substr[1], substr[2], substr[3], substr[4], substr[5], substr[6], substr[7], substr[8], substr[9], substr[10], StudyGroupPriorityQueue);
                    } else {
                        if (cmd.equalsIgnoreCase("show") == true) AllCmd.show(StudyGroupPriorityQueue);
                        else {
                            if (cmd.lastIndexOf("remove_by_id") != -1) {
                                String id;
                                int index1 = cmd.lastIndexOf(" ");
                                id = cmd.substring(index1 + 1);
                                id = id.trim();
                                while (true) {
                                    try {
                                        Integer check = Integer.valueOf(id);
                                        AllCmd.remove_by_id(StudyGroupPriorityQueue, id);
                                        break;
                                    } catch (NumberFormatException e) {
                                        System.out.println("Введите id");
                                        id = scanner1.nextLine();
                                    }
                                }
                            } else {
                                if (cmd.equalsIgnoreCase("clear") == true) AllCmd.clear(StudyGroupPriorityQueue);
                                else {
                                    if (cmd.equalsIgnoreCase("save") == true) {
                                        System.out.println("Введите имя файла");
                                        String path = scanner1.nextLine();
                                        path = path.trim();
                                        AllCmd.save(StudyGroupPriorityQueue, path);
                                    } else {
                                        if (cmd.equalsIgnoreCase("head") == true) AllCmd.head(StudyGroupPriorityQueue);
                                        else {
                                            if (cmd.equalsIgnoreCase("remove_head") == true)
                                                AllCmd.remove_head(StudyGroupPriorityQueue);
                                            else {
                                                if (cmd.lastIndexOf("update") != -1) {
                                                    String id = null;
                                                    int index1 = cmd.lastIndexOf(" ");
                                                    try {
                                                        id = cmd.substring(index1);
                                                        id = id.trim();
                                                    } catch (StringIndexOutOfBoundsException e) {
                                                        System.out.println("Введите id");
                                                        while (true) {
                                                            try {

                                                                id = scanner1.nextLine();
                                                                Integer check = Integer.parseInt(id);
                                                                break;
                                                            } catch (NumberFormatException ex) {
                                                                System.out.println("Неправильный ввод, попробуем еще раз");
                                                            }
                                                        }
                                                    } catch (NumberFormatException e2) {
                                                        System.out.println("Неправильный ввод, попробуем еще раз");
                                                    }


                                                    //System.out.println("Введите через запятую в нужном порядке следующие данные: имя, номер, отчислен ли студент(yes/no), форма обучения(full time, evening, distance), номер сместра(5,6,7,8), имя админа группы" +
                                                    //       ", высоту, вес, цвет глаз(red, black brown, orange), X, Y");

                                                    Scanner scanner = new Scanner(System.in);
                                                    //  String string = scanner.toString();
                                                    String substr[] = new String[12];
                                                    //  Scanner scanner = new Scanner(System.in);

                                                    System.out.println("Введите имя");
                                                    substr[0] = scanner.nextLine();
                                                    System.out.println("Введите номер");

                                                    substr[1] = scanner.nextLine();
                                                    long check;
                                                    while (true) {
                                                        try {
                                                            check = Long.parseLong(substr[1]);
                                                            break;
                                                        } catch (NumberFormatException e) {
                                                            System.out.println("неправильный ввод,попробуем еще раз");
                                                            substr[1] = scanner.nextLine();
                                                        }
                                                    }

                                                    System.out.println("Введите отчислен ли студент(yes/no)");
                                                    substr[2] = scanner.nextLine();
                                                    substr[2] = substr[2].trim();
                                                    while (true) {
                                                        if (substr[2].equalsIgnoreCase("yes")) break;
                                                        else {
                                                            if (substr[2].equalsIgnoreCase("no")) break;
                                                            else
                                                                System.out.println("неправильный ввод,попробуем еще раз");
                                                            substr[2] = scanner.nextLine();
                                                        }
                                                    }
                                                    System.out.println("Введите форму обучения(full time, evening, distance)");
                                                    substr[3] = scanner.nextLine();
                                                    substr[3] = substr[3].trim();
                                                    while (true) {
                                                        if (substr[3].equalsIgnoreCase("full time")) break;
                                                        else {
                                                            if (substr[3].equalsIgnoreCase("evening")) break;
                                                            else {
                                                                if (substr[3].equalsIgnoreCase("distance")) break;
                                                                else
                                                                    System.out.println("неправильный ввод,попробуем еще раз");
                                                                substr[3] = scanner.nextLine();
                                                            }
                                                        }
                                                    }
                                                    System.out.println("Введите номер семестра");
                                                    substr[4] = scanner.nextLine();
                                                    substr[4] = substr[4].trim();
                                                    while (true) {
                                                        try {
                                                            int check1 = Integer.parseInt(substr[4]);
                                                            if (check1 >= 5 & check1 <= 8) break;
                                                            else {
                                                                System.out.println("неправильный ввод,попробуем еще раз");
                                                                substr[4] = scanner.nextLine();
                                                            }
                                                        } catch (NumberFormatException e) {
                                                            System.out.println("неправильный ввод,попробуем еще раз");
                                                            substr[4] = scanner.nextLine();
                                                        }
                                                    }
                                                    System.out.println("Введите имя админа группы");
                                                    substr[5] = scanner.nextLine();
                                                    System.out.println("Введите высоту");
                                                    substr[6] = scanner.nextLine();
                                                    substr[6] = substr[6].trim();
                                                    while (true) {
                                                        try {
                                                            Double check2 = Double.parseDouble(substr[6]);
                                                            break;
                                                        } catch (NumberFormatException e) {
                                                            System.out.println("неправильный ввод,попробуем еще раз");
                                                            substr[6] = scanner.nextLine();
                                                        }
                                                    }
                                                    System.out.println("Введите вес");
                                                    substr[7] = scanner.nextLine();
                                                    while (true) {
                                                        try {
                                                            Integer check3 = Integer.parseInt(substr[7]);
                                                            break;
                                                        } catch (NumberFormatException e) {
                                                            System.out.println("неправильный ввод,попробуем еще раз");
                                                            substr[7] = scanner.nextLine();
                                                        }
                                                    }
                                                    System.out.println("Введите цвет глаз(red, black, brown, orange)");
                                                    substr[8] = scanner.nextLine();
                                                    substr[8].trim();
                                                    while (true) {
                                                        if (substr[8].equalsIgnoreCase("red")) break;
                                                        else {
                                                            if (substr[8].equalsIgnoreCase("black")) break;
                                                            else {
                                                                if (substr[8].equalsIgnoreCase("brown")) break;
                                                                else {
                                                                    if (substr[8].equalsIgnoreCase("orange")) break;
                                                                    else
                                                                        System.out.println("неправильный ввод,попробуем еще раз");
                                                                    substr[8] = scanner.nextLine();
                                                                }
                                                            }
                                                        }
                                                    }
                                                    System.out.println("Введите X");
                                                    substr[9] = scanner.nextLine();
                                                    substr[9] = substr[9].trim();
                                                    while (true) {
                                                        try {
                                                            Float check4 = Float.parseFloat(substr[9]);
                                                            break;
                                                        } catch (NumberFormatException e) {
                                                            System.out.println("неправильный ввод,попробуем еще раз");
                                                            substr[9] = scanner.nextLine();
                                                        }
                                                    }
                                                    System.out.println("Введите Y");
                                                    substr[10] = scanner.nextLine();
                                                    substr[10] = substr[10].trim();
                                                    while (true) {
                                                        try {
                                                            long check5 = Long.valueOf(substr[10]);
                                                            break;
                                                        } catch (NumberFormatException e) {
                                                            System.out.println("неправильный ввод,попробуем еще раз");
                                                            substr[10] = scanner.nextLine();
                                                        }
                                                    }
                                                    AllCmd.update(StudyGroupPriorityQueue, id, substr[0], substr[1], substr[2], substr[3], substr[4], substr[5], substr[6], substr[7], substr[8], substr[9], substr[10]);
                                                } else {
                                                    if (cmd.equalsIgnoreCase("remove_lower") == true) {
                                                        System.out.println("Введите номер в списке (count)");
                                                        Scanner scanner = new Scanner(System.in);
                                                        String string = scanner.nextLine();
                                                        long count;
                                                        while (true) {
                                                            try {
                                                                count = Long.valueOf(string);
                                                                break;
                                                            } catch (NumberFormatException e) {
                                                                System.out.println("Номер введен неправильно, попробуем еще раз");
                                                                string = scanner.nextLine();
                                                            }
                                                        }
                                                        for (StudyGroup student : StudyGroupPriorityQueue) {
                                                            if (student.getStudentsCount() == count) {
                                                                System.out.println("Хотите удалить все элементы меньшие чем:");
                                                                System.out.println("Имя: " + student.getName() + " Номер:" + student.getStudentsCount() + " " + student.getexp() + " Форма обучения: " + student.getFormOfEducation() + " Id: " + student.getId()
                                                                        + " Рост админа: " + student.getHeight() + " Вес админа: " + student.getWeight() + " Цвет глаз админа: " + student.getColor() + " Координата X: " + student.getCoordinatesX() + " Координата Y: " + student.getCoordinatesY());
                                                                System.out.println("Введите yes\\no");
                                                                Scanner scanner2 = new Scanner(System.in);
                                                                String answer = scanner2.nextLine();
                                                                answer = answer.trim();
                                                                if (answer.equalsIgnoreCase("yes") == true)
                                                                    AllCmd.remove_lover(StudyGroupPriorityQueue, count);
                                                                else {
                                                                    if (answer.equalsIgnoreCase("no") == true)
                                                                        System.out.println("Ничего не удаляем,введите следующую команду");
                                                                    else
                                                                        System.out.println("Что-то пошло не так, введите следующую команду");
                                                                }
                                                            }
                                                        }
                                                    } else {
                                                        if (cmd.lastIndexOf("remove_any_by_form_of_education") != -1) {
                                                            String form;
                                                            int index1 = cmd.lastIndexOf(" ");
                                                            form = cmd.substring(index1 + 1);
                                                            AllCmd.remove_any_by_form_of_education(StudyGroupPriorityQueue, form);
                                                        } else {
                                                            if (cmd.lastIndexOf("filter_starts_with_name") != -1) {
                                                                String name;
                                                                int index1 = cmd.lastIndexOf(" ");
                                                                name = cmd.substring(index1 + 1);
                                                                AllCmd.filter_starts_with_name(StudyGroupPriorityQueue, name);
                                                            } else {
                                                                if (cmd.lastIndexOf("filter_greater_than_students_count") != -1) {
                                                                    String count;
                                                                    int index1 = cmd.lastIndexOf(" ");
                                                                    count = cmd.substring(index1 + 1);
                                                                    while (true) {
                                                                        try {
                                                                            long cou = Long.parseLong(count);
                                                                            AllCmd.filter_greater_than_students_count(StudyGroupPriorityQueue, cou);
                                                                            break;
                                                                        } catch (NumberFormatException e) {
                                                                            System.out.println("Введите номер");
                                                                            Scanner scanner = new Scanner(System.in);
                                                                            count = scanner.nextLine();
                                                                        }
                                                                    }
                                                                } else {
                                                                    if (cmd.lastIndexOf("execute_script") != -1) {
                                                                        String path;

                                                                        while (true)
                                                                            try {
                                                                                int index1 = cmd.lastIndexOf(" ");
                                                                                path = cmd.substring(index1);
                                                                                AllCmd.execute_script(StudyGroupPriorityQueue, path);
                                                                                break;
                                                                            } catch (StringIndexOutOfBoundsException e) {
                                                                                System.out.println("Введите имя файла");
                                                                                cmd = " " + scanner1.nextLine();
                                                                            }

                                                                    } else {
                                                                        if (cmd.equalsIgnoreCase("exit") != true)
                                                                            System.out.println("Команда введена неправильно");
                                                                    }

                                                                }
                                                            }
                                                        }
                                                    }

                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}