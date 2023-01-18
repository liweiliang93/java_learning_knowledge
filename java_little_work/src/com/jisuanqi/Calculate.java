package com.jisuanqi;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculate {
    public static void main(String[] args) {
        myFrame frame = new myFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭窗口
        frame.setVisible(true);
    }
}

class myFrame extends JFrame {
    public myFrame() {
        setTitle("Calculator");
        add(new myPanel());
        pack();
    }
}

class myPanel extends JPanel {
    //显示计算器按钮的值和计算后的值
    JTextField display;
    JPanel panel1;//面板1
    JPanel panel2;//面板2
    String nowButton;//当前按下的

    public myPanel() {

        setLayout(new BorderLayout());

        //把文本框加在上面north里
        display = new JTextField("");
        display.setEnabled(true);
        add(display, BorderLayout.NORTH);

        //监听操作按钮
        ActionListener command = new commandAction();

        //panel1是中间16个按钮的布局，放到布局管理器的center里
        panel1 = new JPanel();
        panel1.setLayout(new GridLayout(4, 4));

        addButton1("7", command);
        addButton1("8", command);
        addButton1("9", command);
        addButton1("+", command);
        addButton1("4", command);
        addButton1("5", command);
        addButton1("6", command);
        addButton1("-", command);
        addButton1("1", command);
        addButton1("2", command);
        addButton1("3", command);
        addButton1("*", command);
        addButton1(".", command);
        addButton1("0", command);
        addButton1("=", command);
        addButton1("/", command);

        add(panel1, BorderLayout.CENTER);


        //panel2是下面的backspace和c的2个的布局，放到布局管理器的south里
        panel2 = new JPanel();
        panel2.setLayout(new GridLayout(1, 2));

        addButton2("BackSace", command);
        addButton2("C", command);

        add(panel2, BorderLayout.SOUTH);

    }

    //注册事件监听器方法（panel1的）
    public void addButton1(String label ,ActionListener listener) {
        JButton button = new JButton(label);
        button.addActionListener(listener);
        panel1.add(button);
    }

    //注册监听器方法（panel2的）
    private void addButton2(String label, ActionListener listener) {
        // TODO 自动生成的方法存根
        JButton button = new JButton(label);
        button.addActionListener(listener);
        panel2.add(button);
    }

    //单击按钮执行命令的监听器
    class commandAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            // TODO 自动生成的方法存根
            nowButton = event.getActionCommand();

            if (nowButton != "BackSace" && nowButton != "=") {
                //如果是回退和=就不打印这个了
                display.setText(display.getText() + nowButton);
            }

            if (nowButton.equals("=")) {
                //如果是等于号，就计算结果
                display.setText(jisuan1(display.getText()));
            }

            if (nowButton.equals("BackSace")) {
                //回退一个字符
                StringBuffer sb = new StringBuffer(display.getText());
                display.setText(sb.substring(0, sb.length()-1));
            }
            if (nowButton.equals("C")) {
                //清空
                display.setText("");
            }
        }
    }

    //用来计算的方法
    public String jisuan1(String string) {
        StringBuffer sb = new StringBuffer(string);
        int commandCount = 0;//符号数量

        int j = 0;//计数器
        //计算有多少个运算符，就有n+1个数字
        for (j = 0; j < sb.length(); j++) {
            if (sb.charAt(j) <= '9' && sb.charAt(j) >= '0' || sb.charAt(j) == '.') {
                continue;
            }else {
                commandCount++;
            }
        }

        //初始化符号数组
        char[] command = new char[commandCount];
        //初始化数字数组（用字符串表示）
        String[] num = new String[commandCount+1];
        for (j = 0; j < num.length; j++) {
            num[j] = "";
        }

        //遍历一遍，吧每个数字存进数字数组，每个符号存进符号数组
        int k = 0;
        for (j = 0; j < sb.length(); j++) {
            if (sb.charAt(j) <= '9' && sb.charAt(j) >= '0' || sb.charAt(j) == '.') {
                num[k] += sb.charAt(j);
                continue;
            }else {
                command[k] = sb.charAt(j);
                k++;
            }
        }

        //计算结果
        double result = 0;
        for (int i = 0; i < commandCount; i++) {

            //取前两个数，和第一个操作符，运算
            double num1 = Double.parseDouble(num[i]);
            double num2 = Double.parseDouble(num[i+1]);
            char cc = command[i];

            //计算
            switch (cc) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
                default:
                    break;
            }
            num[i+1] = String.valueOf(result);
        }

        return String.valueOf(result);
    }
}