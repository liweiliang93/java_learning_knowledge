package com.itweiliang.educoder.objectoriented;

import java.util.Scanner;

/**
 * @author ASUS
 * @time 2023-03-19 11:01:49
 * @description TODO
 */
public class AddressBook {

    int number = 0;

    static Scanner scan = new Scanner(System.in);

    private Person[] persons = new Person[20];

    public void selectAll(){
        if(number == 0 || persons == null){
            System.out.println("暂时没有数据!!!");
        }else{
            System.out.println("编号 "+'\t'+"姓名"+'\t'+"性别"+'\t'+"电话"+'\t'+'\t'+'\t'+"地址");
            for (int i = 0;i < number;i++) {
                if(persons[i] != null){
                    System.out.println((i+1)+""+'\t'+'\t'+persons[i].getName() + '\t' + persons[i].getSex() + '\t'+'\t'
                            + persons[i].getTelephone() + '\t'+'\t' + persons[i].getAddress());
                }
            }
        }
    }

    public void add(){
        System.out.println("-------------------------------");
        System.out.println("请输入要添加人的信息:");
        System.out.print("姓名:");
        String name = AddressBookUtils.getName();
        System.out.print("性别:");
        String sex = AddressBookUtils.getSex();
        System.out.print("电话:");
        String telephone = AddressBookUtils.getTelephone();
        System.out.print("地址:");
        String address = scan.next();
        Person person = new Person(name,sex,telephone,address);
        for(int i = 0;i < persons.length;i++){
            if(persons[i] == null){
                persons[i] = person;
                number++;
                break;
            }
        }
        System.out.println("添加成功");
    }

    public void delete(){
        System.out.print("请输入你想删除人的姓名：");
        String name = scan.next();
        Person person;
        for (int i = 0;i < persons.length;i++) {
            if(persons[i] != null){
                if(name.equals(persons[i].getName())){
                    persons[i] = null;
                    number--;
                    System.out.println("删除成功!!");
                }
            }
        }

    }

    public void modify(){
        System.out.print("请输入你想修改人的姓名:");
        String name = scan.next();
        for (Person value : persons) {
            if (name.equals(value.getName())) {
                System.out.println("请选择你想修改什么属性:");
                System.out.println("1.姓名 2.性别 3.电话 4.通信地址");
                int choice = scan.nextInt();
                if(choice == 1){
                    value.setName(AddressBookUtils.getName());
                } else if (choice == 2) {
                    value.setSex(AddressBookUtils.getSex());
                }else if(choice == 3){
                    value.setTelephone(AddressBookUtils.getTelephone());
                }else if (choice == 4){
                    value.setAddress(scan.next());
                }
                System.out.println("修改成功!!!");
                System.out.println("--------------------");
                break;
            }
        }
    }

    public void select(){
        System.out.println("请输入你想查询人的姓名或电话:");
        String selectByAttribute = scan.next();
        for(int i = 0;i < persons.length;i++){
            if(persons[i] != null) {
                if (selectByAttribute.equals(persons[i].getName())) {
                    System.out.println("编号 " + '\t' + "姓名" + '\t' + "性别" + '\t' + "电话" + '\t' + '\t' + '\t' + "地址");
                    System.out.println((i + 1) + "" + '\t' + '\t' + persons[i].getName() + '\t' + persons[i].getSex() + '\t' + '\t'
                            + persons[i].getTelephone() + '\t' + '\t' + persons[i].getAddress());
                }
                if(selectByAttribute.equals(persons[i].getTelephone())){
                    System.out.println("编号 " + '\t' + "姓名" + '\t' + "性别" + '\t' + "电话" + '\t' + '\t' + '\t' + "地址");
                    System.out.println((i + 1) + "" + '\t' + '\t' + persons[i].getName() + '\t' + persons[i].getSex() + '\t' + '\t'
                            + persons[i].getTelephone() + '\t' + '\t' + persons[i].getAddress());
                }
            }
        }

    }

    public Person[] getPersons() {
        return persons;
    }

    public void setPersons(Person[] persons) {
        this.persons = persons;
    }
}

class AddressBookUtils{
    static Scanner scan = new Scanner(System.in);
    public static String getName(){
        String name = scan.next();
        String ifContinue;
        while (name.length() > 4) {
            System.out.print("姓名不符合正常逻辑,是否确认?(y确认/n重新输入):");
            ifContinue = scan.next();
            if("y".equals(ifContinue)){
                break;
            }else if("n".equals(ifContinue)){
                name = scan.next();
            }
        }
        return name;
    }

    public static String getSex(){
        String sex = scan.next();
        while(true){
            if("男".equals(sex)){
                break;
            }else if("女".equals(sex)){
                break;
            }else{
                System.out.print("只能选择男女,请重新输入:");
                sex = scan.next();
            }
        }
        return sex;
    }

    public static String getTelephone() {
        String telephone = scan.next();
        while(true){
            if(telephone.length() != 11 || telephone.charAt(0) != '1'){
                System.out.println("号码输入不规范,请重新输入:");
                telephone = scan.next();
            }else{
                break;
            }
        }
        return telephone;
    }
}

class Person{
    private String name;
    private String sex;
    private String telephone;
    private String address;

    public Person() {
    }

    public Person(String name, String sex, String telephone, String address) {
        this.name = name;
        this.sex = sex;
        this.telephone = telephone;
        this.address = address;
    }

    public void setName(String name) {
        name = name;
    }

    public void setSex(String sex) {
        sex = sex;
    }

    public void setTelephone(String telephone) {
        telephone = telephone;
    }

    public void setAddress(String address) {
        address = address;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getAddress() {
        return address;
    }
}

class AddressBookTest{
    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook();
        Scanner scan = new Scanner(System.in);
        int number;
        while(true){
            System.out.println("-----电话簿管理-------");
            System.out.println("1.添加联系人");
            System.out.println("2.删除联系人");
            System.out.println("3.修改联系人信息");
            System.out.println("4.查询单个联系人");
            System.out.println("5.查询所有联系人");
            System.out.print("请输入你想进行的操作:");
            number = scan.nextInt();
            if (number == 1){
                addressBook.add();
            }else if(number == 2){
                addressBook.delete();
            }else if(number == 3){
                addressBook.modify();
            }else if(number == 4){
                addressBook.select();
            }else if(number == 5){
                System.out.println("---------电话簿--------");
                addressBook.selectAll();
                System.out.println("--------------------------");
            }else{
                System.out.println("请重新输入:");
            }
        }
    }
}