package com.ambition.test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class ArithmeticQuizGenerator extends JFrame {
    private JLabel questionLabel; // 问题标签
    private JRadioButton optionARadioButton; // 选项A单选按钮
    private JRadioButton optionBRadioButton; // 选项B单选按钮
    private JRadioButton optionCRadioButton; // 选项C单选按钮
    private JRadioButton optionDRadioButton; // 选项D单选按钮
    private JButton submitButton; // 提交按钮
    private ButtonGroup buttonGroup; // 选项按钮组
    private JLabel resultLabel; // 回答结果标签
    private JLabel scoreLabel; // 得分标签

    private int totalQuestions; // 题目总数
    private int currentQuestion; // 当前问题数
    private int correctAnswers; // 正确答案数

    private Random random; // 随机数生成器
    private int correctOptionIndex; // 保存正确选项索引

    public ArithmeticQuizGenerator(int totalQuestions) {
        this.totalQuestions = totalQuestions;
        this.currentQuestion = 1;
        this.correctAnswers = 0;
        this.random = new Random(); // 初始化随机数生成器

        setTitle("小朋友算术练习题生成器");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout()); // 设置布局为网格包布局

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(10, 10, 10, 10);

        questionLabel = new JLabel(); // 创建问题标签
        questionLabel.setHorizontalAlignment(JLabel.CENTER); // 文字居中对齐
        add(questionLabel, gbc); // 添加到界面

        gbc.gridy = 1;
        gbc.gridwidth = 1;

        optionARadioButton = new JRadioButton("A"); // 创建选项A单选按钮
        optionBRadioButton = new JRadioButton("B"); // 创建选项B单选按钮
        optionCRadioButton = new JRadioButton("C"); // 创建选项C单选按钮
        optionDRadioButton = new JRadioButton("D"); // 创建选项D单选按钮

        buttonGroup = new ButtonGroup(); // 创建按钮组
        buttonGroup.add(optionARadioButton); // 添加选项A到按钮组
        buttonGroup.add(optionBRadioButton); // 添加选项B到按钮组
        buttonGroup.add(optionCRadioButton); // 添加选项C到按钮组
        buttonGroup.add(optionDRadioButton); // 添加选项D到按钮组

        add(optionARadioButton, gbc); // 添加选项A单选按钮到界面

        gbc.gridx = 1;
        add(optionBRadioButton, gbc); // 添加选项B单选按钮到界面

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(optionCRadioButton, gbc); // 添加选项C单选按钮到界面

        gbc.gridx = 1;
        add(optionDRadioButton, gbc); // 添加选项D单选按钮到界面

        gbc.gridy = 3;
        gbc.gridx = 0;
        gbc.gridwidth = 2;

        submitButton = new JButton("提交"); // 创建提交按钮
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                submitAnswer(); // 提交答案
            }
        });

        add(submitButton, gbc); // 添加提交按钮到界面

        gbc.gridy = 4;

        resultLabel = new JLabel(); // 创建回答结果标签
        resultLabel.setHorizontalAlignment(JLabel.CENTER); // 文字居中对齐
        add(resultLabel, gbc); // 添加回答结果标签到界面

        gbc.gridy = 5;

        scoreLabel = new JLabel(); // 创建得分标签
        scoreLabel.setHorizontalAlignment(JLabel.CENTER); // 文字居中对齐
        add(scoreLabel, gbc); // 添加得分标签到界面

        generateQuestion(); // 生成第一道题目

        pack(); // 界面自适应大小
        setLocationRelativeTo(null); // 窗口居中显示
        setVisible(true); // 显示界面
    }

    private void generateQuestion() { // 生成题目和选项
        buttonGroup.clearSelection(); // 清除选项选择状态

        int num1 = random.nextInt(101); // 随机生成两个加减数
        int num2 = random.nextInt(101);
        int operator = random.nextInt(2); // 0表示加法，1表示减法

        String operatorString;
        int answer;
        if (operator == 0) { // 如果是加法则保存运算符为+，否则保存为-
            operatorString = "+";
            answer = num1 + num2; // 计算正确答案
        } else {
            operatorString = "-";
            answer = num1 - num2;
        }

        questionLabel.setText(num1 + " " + operatorString + " " + num2 + " ="); // 显示问题

        // 随机生成正确选项的索引
        correctOptionIndex = random.nextInt(4);

        // 生成选项列表
        String[] options = generateOptions(answer); // 生成选项

        optionARadioButton.setText("A. " + options[0]); // 设置选项A显示文字
        optionBRadioButton.setText("B. " + options[1]); // 设置选项B显示文字
        optionCRadioButton.setText("C. " + options[2]); // 设置选项C显示文字
        optionDRadioButton.setText("D. " + options[3]); // 设置选项D显示文字
    }

    private String[] generateOptions(int answer) { // 生成选项
        String[] options = new String[4];

        // 在正确选项索引处插入正确答案
        options[correctOptionIndex] = String.valueOf(answer);

        // 生成干扰项
        for (int i = 0; i < 4; i++) {
            if (i != correctOptionIndex) { // 如果该选项不是正确答案
                int option = generateRandomOption(answer); // 随机生成干扰项
                options[i] = String.valueOf(option); // 保存到选项列表中
            }
        }

        return options;
    }

    private int generateRandomOption(int answer) { // 生成干扰项
        int option;
        do {
            option = random.nextInt(100) + 1; // 随机生成1-100的数字
        } while (option == answer); // 直到不等于正确答案

        return option; // 返回干扰项
    }

    private void submitAnswer() { // 提交答案
        if (buttonGroup.getSelection() == null) { // 如果未选择选项
            JOptionPane.showMessageDialog(this, "请选择一个选项！", "提示", JOptionPane.WARNING_MESSAGE); // 提示用户选择
            return;
        }

        if (currentQuestion < totalQuestions) { // 如果还没完成所有问题
            if (isAnswerCorrect()) { // 如果答案正确
                correctAnswers++; // 增加正确答案数量
                resultLabel.setText("回答正确！"); // 显示回答结果为正确
            } else { // 如果答案错误
                resultLabel.setText("回答错误！"); // 显示回答结果为错误
            }

            currentQuestion++; // 增加当前问题数
            scoreLabel.setText("当前得分：" + correctAnswers + "/" + currentQuestion); // 显示得分

            generateQuestion(); // 生成下一道题目
        } else { // 如果已完成所有问题
            if (isAnswerCorrect()) { // 如果最后一题也答对了
                correctAnswers++; // 增加正确答案数量
            }

            calculateScore(); // 计算得分和评价
            showResult(); // 显示答题结果
            System.exit(0); // 关闭程序
        }
    }

    private boolean isAnswerCorrect() { // 判断答案是否正确
        int selectedOptionIndex = getSelectedOptionIndex(); // 获取选中选项的索引
        return selectedOptionIndex == correctOptionIndex; // 返回是否与正确选项相同
    }

    private int getSelectedOptionIndex() { // 获取选中选项的索引
        if (optionARadioButton.isSelected()) {
            return 0;
        } else if (optionBRadioButton.isSelected()) {
            return 1;
        } else if (optionCRadioButton.isSelected()) {
            return 2;
        } else {
            return 3;
        }
    }

    private void calculateScore() { // 计算得分和评价
        int incorrectAnswers = totalQuestions - correctAnswers; // 计算错误答案数
        double score = (double) correctAnswers / totalQuestions * 100; // 计算得分百分比
        String comment;

        if (score == 100) { // 如果得分为100分
            comment = "你太棒了，答对了所有题目！";
        } else if (score >= 90) { // 如果得分在90-100之间
            comment = "非常好，你的成绩很优秀！";
        } else if (score >= 80) { // 如果得分在80-90之间
            comment = "不错，继续努力，你离满分只有一步之遥！";
        } else if (score >= 60) { // 如果得分在60-80之间
            comment = "还需要加强，继续努力哦！";
        } else { // 如果得分低于60分
            comment = "你需要更多的练习了！";
        }

        scoreLabel.setText("本次得分：" + correctAnswers + "/" + totalQuestions + "，错误数：" + incorrectAnswers); // 显示得分和错误数
        resultLabel.setText(comment); // 显示评价
    }

    private void showResult() { // 显示答题结果
        JOptionPane.showMessageDialog(this, "答题结束！", "提示", JOptionPane.INFORMATION_MESSAGE);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ArithmeticQuizGenerator(5); // 创建界面
            }
        });
    }
}
