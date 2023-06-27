package entity;

import java.util.Random;

/**
 * @author Firstname Lastname
 * @create 2023-05-22 23:59:29
 * @description
 *      1.此类是用于实现模拟空战的战机类,每个飞机都有其对应的唯一标识和最大往返次数,超过这个上限，
 *      战机不能继续参战:故设置战机属性id、maxAttackCount
 *
 *      2.设置每次往返记录的当前往返次数,并在构造器的参数中设置初始值0
 *
 *      3.设置战机每次攻击目标后进行currentRoundTripCount自动+1的操作
 */
public class Airplane {

    private final int id;     //此处使用id作为唯一标识标记飞机,并且设置为不可更改
    private int maxRoundTripCount = 2;      //飞机对应的最大往返次数
    private int currentRoundTripCount;     //每次攻击后的往返次数
    private int baseId;     //基地id,由于飞机一定要属于某个基地,所以设置此属性进行记录

    public Airplane(int id) {    //构造器
        this.id = id;
        this.currentRoundTripCount = 0;
    }

    public int getId() {
        return id;
    }

    public int getMaxRoundTripCount() { //获取最大的往返次数
        return maxRoundTripCount;
    }

    public int getCurrentRoundTripCount() { //获取当前的往返次数
        return currentRoundTripCount;
    }

    public void incrementCurrentRoundTripCount() {  //设置+1函数
        currentRoundTripCount++;
    }

    public int getBaseId() {    //获取基地id
        return baseId;
    }

    public void setBaseId(int baseId) { //设置基地id
        this.baseId = baseId;
    }

    //判断飞机是否被击毁,并且通过生成随机数的方式设置战机是否被击落,概率设置为40%
    public boolean isDestroyed() {
        boolean isDestroyed;
        Random random = new Random();
        int randomNumber = random.nextInt(100); // 生成0到99之间的随机数
        if(randomNumber < 40){
            return true;
        }
        return false;
    }

    public boolean isActivated() {  //判断战机是否达到最大往返次数
        return currentRoundTripCount < maxRoundTripCount;
    }

}