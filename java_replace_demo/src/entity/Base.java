package entity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Firstname Lastname
 * @create 2023-05-22 23:54:14
 * @description
 *      1.此类是用于实现模拟空战的基地类,每个基地有若干战机.基于Java面向对象,可以很轻松的
 *        将战机类和基地类组合在一起,将战机和基地分别设置为不同的类
 *
 *      2.Java语言中,分别有Set集合和List集合,由于List集合存储有序的、可重复的数据,Set集合存
 *        储无序的、不可重复的数据,由于需要模仿空战演习,每一架飞机都需要有确定的编号，故在此使用List集合
 *        来承装飞机。
 *
 *      3.基地的位置彼此之间也要不同,在构造器造对象的时候我们自己来控制方位
 */
public class Base {

    private final int id;   //此处使用id作为唯一标识标记基地,并且设置为不可更改、

    private int baseLocationX;   //基地位置:可使用坐标表示

    private int baseLocationY;   //基地位置:可使用坐标表示

    private List<Airplane> airplanes; //使用List集合来作为飞机集合,注此处使用泛型来约束集合内只能存储飞机类

    public Base(int id,int locationX,int locationY) {   //基地类构造函数,每个基地类都包含一个唯一标识id和飞机集合,位置
        this.id = id;
        this.baseLocationX = locationX;
        this.baseLocationY = locationY;
        this.airplanes = new ArrayList<Airplane>();
    }

    public int getId() { //获取基地的id,为以后大战做准备,作为标识和进行计算
        return id;
    }

    public List<Airplane> getAirplanes() {  //获取基地的飞机集合
        return airplanes;
    }

    public int getBaseLocationX() { //获取基地的位置x
        return baseLocationX;
    }

    public int getBaseLocationY() { //获取基地的位置y
        return baseLocationY;
    }

    public void addWarplane(Airplane airplane) {  //基地添加飞机
        airplanes.add(airplane);
    }

    public boolean isLimitedBase(){     //判断飞机集合是否为空
        if(airplanes.size() == 0){
            return true;
        }
        return false;
    }

}
