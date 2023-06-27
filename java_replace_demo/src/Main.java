import entity.Base;
import entity.Target;
import tools.AirCombatTools;

import java.util.List;

/**
 * @author Firstname Lastname
 * @create 2023-05-22 23:58:22
 * @description 模拟空战测试
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {

        //调用AirCombatTools内的generateRandomBase生成随机个基地和随机个战斗机
        List<Base> bases = AirCombatTools.generateRandomBase();

        //调用AirCombatTools内的generateRandomTargets生成随机个目标
        List<Target> targets = AirCombatTools.generateRandomTargets();

        //调用AirCombatTools内的airCombat函数实现模拟空战
        AirCombatTools.airCombat(bases,targets);

    }

}