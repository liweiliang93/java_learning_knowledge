package entity;

import java.util.Random;

/**
 * @author Firstname Lastname
 * @create 2023-05-22 23:58:22
 * @description
 *          1.此类是用于实现模拟空战的战机类, 每个飞机都有其对应的唯一标识和最大往返次数, 超过这个上限，
 *            战机不能继续参战:故设置战机属性id、maxAttackCount
 *
 *          2.判断攻击目标是否被摧毁,并且设置当战机被损毁时,被攻击目标是否受到伤害,概率设置为50%
 */
public class Target {

    private final int id;     //设置唯一标识标记攻击目标
    private int maxAttackedCount = 2;   //设置攻击目标的最大承受次数
    private int targetLocationX;  //设置攻击目标的位置X
    private int targetLocationY;  //设置攻击目标的位置\Y
    private int attackedCount;  //设置当前攻击目标的被攻击次数


    public Target(int id,int targetLocationX,int targetLocationY) {//与基地类构造器类似,初始化目标类所具有的属性
        this.id = id;
        this.targetLocationX = targetLocationX;
        this.targetLocationY = targetLocationY;
        this.attackedCount = 0;
    }

    public int getId() {    //获取目标的id,为以后大战做准备,作为标识和进行计算
        return id;
    }

    public int getAttackedCount() { //当前被攻击数量
        return attackedCount;
    }


    public int getTargetLocationX() {
        return targetLocationX;
    }

    public int getTargetLocationY() {
        return targetLocationY;
    }

    public void incrementAttackCount() {    //设置+1函数
        attackedCount++;
    }

    public boolean isDestroyed() {  //判断攻击目标是否被摧毁
        return attackedCount >= maxAttackedCount;
    }

    public boolean isInjuried(){
        boolean isInjuried;
        Random random = new Random();
        int randomNumber = random.nextInt(100); // 生成0到99之间的随机数
        if(randomNumber < 50){
            return true;
        }
        return false;
    }

}