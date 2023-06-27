package com.itweiliang.educoder.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
// 创建一个继承JFrame类并实现ActionListener接口的CalculatorGUI类
public class CalculatorGUI extends JFrame implements ActionListener {

    private JLabel  labelTitle,label1, label2, label3;  // 定义三个JLabel类型的变量
    private JTextField textField1, textField2, textField3;// 定义三个JTextField类型的变量
    private JButton addButton, subButton, clearButton; // 定义三个JButton类型的变量

    public CalculatorGUI() {

        //设置窗口标题
        setTitle("简易计算器");
        setSize(218, 268);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);


        //创建一个文本JLabel组件，并将其赋值给变量label
        labelTitle = new JLabel("简易计算器");
        label1 = new JLabel("运算数一:");
        label2 = new JLabel("运算数二:");
        label3 = new JLabel("运算结果:");

        //创建一个宽度为10的JTextField组件，并将其赋值给变量textField
        textField1 = new JTextField(10);
        textField2 = new JTextField(10);
        textField3 = new JTextField(10);
        textField3.setEditable(false);//将textField设置为不可编辑


        // 创建一个文本为"xxx"的JButton组件，并将其赋值给变量xxxButton
        addButton = new JButton("相加");
        subButton = new JButton("相减");
        clearButton = new JButton("清零");

        //添加按钮点击事件监听器
        addButton.addActionListener(this);
        subButton.addActionListener(this);
        clearButton.addActionListener(this);

        // 创建一个JPanel组件，并使用GridBagLayout布局管理器将其布局
        JPanel panel = new JPanel(new GridBagLayout());

        //设置布局管理器
        setLayout(new FlowLayout(FlowLayout.CENTER));

        JPanel jPanelTitle = getJPanel();
        jPanelTitle.add(labelTitle);
        add(jPanelTitle);

        JPanel jPanelFirst = getJPanel();
        jPanelFirst.add(label1);
        jPanelFirst.add(textField1);
        add(jPanelFirst);

        JPanel jPanelSecond = getJPanel();
        jPanelSecond.add(label2);
        jPanelSecond.add(textField2);
        add(jPanelSecond);

        JPanel jPanelThird = getJPanel();
        jPanelThird.add(label3);
        jPanelThird.add(textField3);
        add(jPanelThird);

        JPanel jPanelAddAndSub = getJPanel();
        jPanelAddAndSub.add(addButton);
        jPanelAddAndSub.add(subButton);
        add(jPanelAddAndSub);

        JPanel jPanelClear = getJPanel();
        jPanelClear.add(clearButton);
        add(jPanelClear);
        setVisible(true); // 显示窗口
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            try {
                double op1 = Double.parseDouble(textField1.getText());
                double op2 = Double.parseDouble(textField2.getText());
                double result = op1 + op2;
                textField3.setText(String.valueOf(result));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "请输入数字后重试", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == subButton) {
            try {
                double op1 = Double.parseDouble(textField1.getText());
                double op2 = Double.parseDouble(textField2.getText());
                double result = op1 - op2;
                textField3.setText(String.valueOf(result));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "请输入数字后重试", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == clearButton) {
            textField1.setText("");
            textField2.setText("");
            textField3.setText("");
        }
    }

    public static JPanel getJPanel(){
        return new JPanel(new FlowLayout(FlowLayout.CENTER));
    }

    public static void main(String[] args) {
        new CalculatorGUI();
    }
}
