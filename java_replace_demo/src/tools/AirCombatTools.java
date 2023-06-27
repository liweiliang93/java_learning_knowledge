package tools;

import entity.Airplane;
import entity.Base;
import entity.Target;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.lang.Thread.sleep;

/**
 * @author Firstname Lastname
 * @create 2023-05-23 00:48:52
 * @description 1.此为飞机大战的辅助工具类, 飞机大战代码逻辑中的方法都可通过此方法来调用, 比如在此代码内定义随机生
 *                成基地数量、随机生成战机数量函数.还有战机攻击函数、攻击目标被攻击函数等
 *
 *              2.我会给出以下代码实现的详细注释,同时逻辑可参考代码逻辑.txt文件
 */
public class AirCombatTools {

    //生成坐标的X轴地址函数
    private static int generateLocationX() {
        int locationX = new Random().nextInt(5) + 20;
        return locationX;
    }

    //生成坐标的Y轴地址函数
    private static int generateLocationY() {
        int locationY = new Random().nextInt(20) + 40;
        return locationY;
    }

    //成3-5个随机的飞机,通过List集合来盛放
    private static List<Airplane> generateRandomAirplane(Base base) {
        Random random = new Random();
        int randomNumber = random.nextInt(2) + 3;
        List<Airplane> airplanes = new ArrayList<>();
        for (int i = 1; i <= randomNumber; i++) {
            int locationX = generateLocationX();
            int locationY = generateLocationY();
            Airplane airplane = new Airplane(i);
            airplane.setBaseId(base.getId());
            airplanes.add(airplane);
        }
        return airplanes;
    }

    //生成3-5个随机的基地,通过List集合来盛放,并调用随机生成飞机函数生成飞机并加入到基地中
    public static List<Base> generateRandomBase() throws InterruptedException {
        Random random = new Random();
        int randomNumber = random.nextInt(2) + 3;
        List<Base> bases = new ArrayList<>();

        System.out.println("-----------------开始随机生成基地----------------");
        System.out.println("此次模拟空战演习共生成" + randomNumber + "个基地：");

        for (int i = 1; i <= randomNumber; i++) {
            int locationX = generateLocationX(); // 生成基地的位置，这里使用一个自定义的方法
            int locationY = generateLocationY();
            Base base = new Base(i, locationX, locationY); // 创建基地对象

            //输出创建基地信息
            System.out.println("基地" + i + "坐标为(" + locationX + "," + locationY + ")");

            //延时
            sleep(1000);

            //将生成的飞机都加入到基地中
            base.getAirplanes().addAll(generateRandomAirplane(base));

            // 将基地对象添加到List集合
            bases.add(base);
        }
        return bases;
    }

    // 生成2-3个随机的攻击目标，通过List集合来盛放
    public static List<Target> generateRandomTargets() throws InterruptedException {
        Random random = new Random();
        int randomNumber = random.nextInt(2) + 2;

        System.out.println("-----------------开始随机生成攻击目标----------------");
        System.out.println("此次模拟空战演习共生成" + randomNumber + "个攻击目标：");

        List<Target> targets = new ArrayList<>();
        for (int i = 1; i <= randomNumber; i++) {
            int maxAttacks = random.nextInt(4) + 2;
            int targetLocationX = generateLocationX();
            int targetLocationY = generateLocationY();

            //输出生成的攻击目标信息
            System.out.println("攻击目标" + i + "坐标为(" + targetLocationX + "," + targetLocationY + ")");

            sleep(1000); //延时

            //将目标对象添加到List集合
            Target target = new Target(i, targetLocationX, targetLocationY);
            targets.add(target);
        }
        return targets;
    }

    // 此方法从基地和飞机中随机选择一个飞机,同时此时应该进行判断基地的情况
    public static Airplane choseRandomPlane(List<Base> bases) throws InterruptedException {
        if (bases.isEmpty()) {  //首先基地有可能为空.此时要退出.
            System.out.println("当前并没有可选择的基地！所有的飞机均不可使用!");
            return null;
        }

        // 随机选择一个基地索引
        Random random = new Random();
        int baseIndex = random.nextInt(bases.size());
        Base base = bases.get(baseIndex);

        //如果基地还有但是,没有可用的战斗机,则切换其他的基地,并将这个基地移除
        List<Airplane> airplanes = base.getAirplanes();
        if (airplanes.isEmpty()) {

            System.out.println("坐标为(" + base.getBaseLocationX() + "," + base.getBaseLocationY()
                    + ")" + "基地 " + base.getId() + " 没有可用的战斗机，正在切换到其他基地！请等待----");

            sleep(2000);

            bases.remove(base);
            choseRandomPlane(bases); // 递归调用，切换基地进行攻击
        }

        // 随机选择一个战斗机索引
        int airplaneIndex = random.nextInt(airplanes.size());
        Airplane airplane = airplanes.get(airplaneIndex);
        return airplane;
    }


    public static void airCombat(List<Base> bases, List<Target> targets) throws InterruptedException {
        System.out.println("----------------------模拟空战演习开始---------------------");
        Airplane airplane;
        while (true) {
            //随机选择一个攻击目标
            Random random = new Random();
            //如果目标全部清除则退出,并返回true,否则就选择随机目标
            if (targets.isEmpty()) { //如果目标集合为空,则退出
                System.out.println("模拟空战演习结束--------------");
                break;
            } else {

                //基地内没有飞机,即基地类集合为空
                if (bases.isEmpty()) {
                    break;
                }

                //随机选择一个目标
                int targetIndex = random.nextInt(targets.size());
                Target target = targets.get(targetIndex);
                airplane = AirCombatTools.choseRandomPlane(bases);

                if (airplane.isDestroyed()) {   //如果飞机被击毁,此时随机判断目标是否受伤害+1
                    sleep(1000);

                    Base base = bases.get(airplane.getBaseId() - 1);

                    //输出飞机被击毁信息
                    System.out.println("坐标为(" + base.getBaseLocationX() + "," + base.getBaseLocationY()
                            + ")" + "基地" + airplane.getBaseId() + "发动战机 " +
                            airplane.getId() + " 被" + "位于" + "(" + target.getTargetLocationX() + "," +
                            target.getTargetLocationY() + ")" + "目标" + target.getId() + "击毁！请求总部支援!!");

                    base.getAirplanes().remove(airplane);
                    if (target.isInjuried()) {
                        target.incrementAttackCount();
                    }
                } else {
                    sleep(1000);
                    Base base = bases.get(airplane.getBaseId() - 1);

                    //输出飞机攻击安全返回信息
                    System.out.println("坐标为(" + base.getBaseLocationX() + "," + base.getBaseLocationY()
                            + ")" + "基地" + airplane.getBaseId() + "发动战机 " + airplane.getId()
                            + "对" + "位于" + "(" + target.getTargetLocationX() + "," + target.getTargetLocationY()
                            + ")" + "攻击目标" + target.getId() + " 进行攻击,并且安全返航！");

                    //飞机往返次数增加和攻击目标受伤害次数增加
                    airplane.incrementCurrentRoundTripCount();
                    target.incrementAttackCount();
                }

                if (target.isDestroyed()) {
                    targets.remove(target);
                }
            }

        }
    }

}