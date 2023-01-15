package com.jisuanqi;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.*;

public class Jisuanqi extends JFrame implements ActionListener{

    //设置成员变量
    JPanel jpanel1,jpanel2;
    JTextField text1,text2;

    public Jisuanqi() {
        //设置框架大小、位置、关闭方式、标题名称
        super("这是一个计算器");
        this.setSize(600, 450);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        //为按钮开辟空间并且为按钮的文字进行定义
        String[] str= {"0","1","2","3","4","5","6","7","8","9","+","-","*","/","√￣","AC","<-","^","=","close"};
        JButton[] button=new JButton[20];
        //实例两个面板并将其布局设置为网格布局
        jpanel1=new JPanel(new GridLayout(2,1));
        jpanel2=new JPanel(new GridLayout(5,4));
        //设置文本框内文字的字体大小
        Font font = new Font("Verdana", Font.BOLD, 15);
        //设置两个文本框长度，高度，添加监听，设置为不可编辑,并设置字体颜色
        text1=new JTextField();
        text2=new JTextField();
        text1.setPreferredSize(new Dimension (20,40));
        text1.setHorizontalAlignment(SwingConstants.RIGHT);
        text1.setFont(font);
        text2.setFont(font);
        text1.addActionListener(this);
        text2.addActionListener(this);
        text1.setEnabled(false);
        text1.setDisabledTextColor(Color.BLUE);
        //将各个组件添加到面板上
        jpanel1.add(text1);
        jpanel1.add(text2);
        for(int i=0;i<str.length;i++) {
            button[i]=new JButton(str[i]);
            jpanel2.add(button[i]);
            button[i].addActionListener(this);
        }
        //将框架的布局设置为边布局，防止组件乱动，并将两个面板添加到窗口上
        this.setLayout(new BorderLayout());
        this.getContentPane().add(jpanel1,BorderLayout.NORTH);
        this.getContentPane().add(jpanel2,BorderLayout.CENTER);
        //设置可见
        this.setVisible(true);
    }

    public static void main(String[] args) {
        // 实例对象
        new Jisuanqi();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // 按键输入
        if(e.getSource() instanceof JButton) {
            text1.setText(text1.getText()+e.getActionCommand());
        }
        //取得结果,并将其设置为4为小数
        if(e.getActionCommand().equals("=")) {
            String a=text1.getText();
            Yunsuan2 yunsuan2=new Yunsuan2(a);
            double result1=yunsuan2.result;
            if(yunsuan2.flag==0) {
                text2.setText("除数不可为0");
            }
            else {
                DecimalFormat df=new DecimalFormat("0.0000");
                text2.setText(df.format(result1));
            }
        }
        //清除功能
        if(e.getActionCommand().equals("AC")) {
            text1.setText("");
            text2.setText("");
        }
        //删除单个字符
        if(e.getActionCommand().equals("<-")) {
            String a=text1.getText();
            a=a.substring(0, a.length()-3);
            text1.setText(a);
        }
        //关闭计算器
        if(e.getActionCommand().equals("close")) {
            System.exit(0);
        }
    }
}
class Yunsuan2{
    String zhongzhui[]=new String[100];
    String houzhui[]=new String[100];
    String fuhao[]=new String[100];
    double Stack[]=new double[100];

    int x=0; //标记中缀字符串数组
    int y=0; //标记后缀字符串数组
    int z=0; //标记符号字符串数组
    int n=0;//标记计算栈字符串数组
    int flag=1;//标记输入是否合法
    double result=0;
    public Yunsuan2(String a) {
        if(a.charAt(0)=='√') {
            int i=2;
            for(;a.charAt(i)>='0'&&a.charAt(i)<='9';i++) {
            }
            //记录第一个数字的位置
            int j=i-1;
            if(a.charAt(i)=='=') {
                String first=a.substring(2, j+1);
                this.result=Math.sqrt(Double.parseDouble(first));
            }
        }
        else {
            this.Zhong(a);
            this.Hou();
            this.Suan();
        }

    }
    public void Zhong(String a) {
        //初始化字符串数组
        for(int i=0;i<zhongzhui.length;i++)
            zhongzhui[i]=new String();
        //将字符串存储为中缀表达式
        for(int i=0;i<a.length();i++) {
            char c=a.charAt(i);
            if(c>='0'&&c<='9') {
                int j=i;
                char c1=a.charAt(i);
                while(c1>='0'&&c1<='9') {
                    j++;
                    c1=a.charAt(j);
                }
                zhongzhui[x]=a.substring(i, j);
                x++;
                i=j-1;
            }
            if(c=='+'||c=='-'||c=='*'||c=='/'||c=='^') {
                zhongzhui[x]=String.valueOf(c);
                x++;
            }
        }
    }
    public void Hou() {
        //初始化字符串数组
        for(int i=0;i<houzhui.length;i++)
            houzhui[i]=new String();
        for(int i=0;i<fuhao.length;i++)
            fuhao[i]=new String();
        for(int i=0;i<this.x;i++) {
            if(zhongzhui[i].charAt(0)>='0'&&zhongzhui[i].charAt(0)<='9') {
                houzhui[y]=zhongzhui[i];
                y++;
            }
            if(zhongzhui[i].charAt(0)=='+'||zhongzhui[i].charAt(0)=='-'||zhongzhui[i].charAt(0)=='*'||zhongzhui[i].charAt(0)=='/'||zhongzhui[i].charAt(0)=='^') {
                if(z==0) {
                    fuhao[z]=zhongzhui[i];
                    z++;
                }
                else {
                    while(true) {
                        int a1,b1;//用来存储优先级别
                        a1=this.Pan(zhongzhui[i].charAt(0));//存储当前符号优先级
                        b1=this.Pan(fuhao[z-1].charAt(0));//存储栈顶符号优先级
                        if(a1>b1) {
                            fuhao[z]=zhongzhui[i];
                            z++;
                            break;
                        }
                        else {
                            houzhui[y]=fuhao[z-1];
                            y++;
                            if(z>1) {
                                z--;
                                continue;
                            }
                            else {
                                fuhao[z-1]=zhongzhui[i];
                                break;
                            }
                        }
                    }
                }
            }
        }
        z=z-1;
        while(z>=0) {
            houzhui[y]=fuhao[z];
            z--;
            y++;
        }
    }
    public int Pan(char b) {
        switch(b) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return 0;
        }
    }
    public void Suan() {
        for(int i=0;i<this.y;i++) {
            if(houzhui[i].charAt(0)>='0'&&houzhui[i].charAt(0)<='9') {
                Stack[n]=Double.parseDouble(houzhui[i]);
                n++;
            }
            if(houzhui[i].charAt(0)=='+') {
                double c=Stack[n-1]+Stack[n-2];
                Stack[n-2]=c;
                n=n-1;
            }
            if(houzhui[i].charAt(0)=='-') {
                double c=Stack[n-2]-Stack[n-1];
                Stack[n-2]=c;
                n=n-1;
            }
            if(houzhui[i].charAt(0)=='*') {
                double c=Stack[n-1]*Stack[n-2];
                Stack[n-2]=c;
                n=n-1;
            }
            if(houzhui[i].charAt(0)=='/') {
                if(Stack[n-1]==0)
                    flag=0;
                double c=Stack[n-2]/Stack[n-1];
                Stack[n-2]=c;
                n=n-1;
            }
            if(houzhui[i].charAt(0)=='^') {
                double c=Math.pow(Stack[n-2], Stack[n-1]);
                Stack[n-2]=c;
                n=n-1;
            }
        }
        this.result=Stack[n-1];
    }
}
