package exercises.multithreading.GUIMultiThread;

import com.mrsoft.music.AudioPlayWave;
import exercises.util.StringUtil;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * @author xunmi
 * @ClassName IndexFrame
 * @Description 主页面设计，内包含同步显示系统时间、播放音乐、图片轮播功能
 * @Date 2020/1/29
 * @Version 1.0
 **/
public class IndexFrame extends JFrame {

    private static final long serialVersionUID = 1L;

    private JPanel contentPane;
    public static JLabel currentDate = new JLabel("", JLabel.CENTER);
    public static JLabel countDown = new JLabel("", JLabel.CENTER);
    public static AudioPlayWave audioPlayWave = new AudioPlayWave("F:\\Idea_Java\\homework\\src\\main\\resources\\music\\讨喜.wav");
    public static JLabel imageLabel = new JLabel("", JLabel.CENTER);


    public IndexFrame() {
        // 基本属性定义
        setTitle("多线程实现不同功能效果");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int width = screenSize.width;
        int height = screenSize.height;
        setBounds((width - 1100) / 2, (height - 700) / 2, 1100, 700);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setLayout(new GridLayout(2, 2, 10, 10));
        // 设置容器内边距
        contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
        setContentPane(contentPane);
        Font font = new Font("华文琥珀", Font.BOLD, 40);

        for (int i = 0; i < 4; i++) {
            JPanel panel = new JPanel();
            panel.setBorder(BorderFactory.createTitledBorder("面板" + i));
            panel.setLayout(new BorderLayout());
            if (i == 0) {
                Thread dateThread = new Thread(new CurrentDateThread());
                dateThread.start();
                currentDate.setFont(font);
                panel.add(currentDate, BorderLayout.CENTER);
            } else if (i == 1) {
                Thread musicThread = new Thread(new MusicThread());
                musicThread.start();
                countDown.setFont(font);
                panel.add(countDown, BorderLayout.CENTER);
            } else if (i == 2) {
                Thread pictureThread = new Thread(new PictureThread());
                pictureThread.start();
                panel.add(imageLabel, BorderLayout.CENTER);
            } else {
                JLabel label = new JLabel("感谢您在此程序中花费时间", JLabel.CENTER);
                label.setFont(new Font("微软雅黑", Font.BOLD, 40));
                panel.add(label, JLabel.CENTER);
            }
            contentPane.add(panel);
        }
    }
}

/**
 * 获取当前时间的线程
 */
class CurrentDateThread implements Runnable {
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
                IndexFrame.currentDate.setText(StringUtil.getCurrentDate());
            } catch (InterruptedException e) {
                System.out.println("计数器出现异常");
            }
        }
    }
}

/**
 * 背景音乐播放的线程
 */
class MusicThread implements Runnable {

    private static int i = 3;

    @Override
    public void run() {
        while (true) {
            try {
                IndexFrame.countDown.setText("播放倒计时: " + i--);
                Thread.sleep(1000);
                if (i == 0) {
                    IndexFrame.countDown.setText("背景音乐播放中");
                    IndexFrame.audioPlayWave.start();
                    return;
                }
            } catch (InterruptedException e) {
                System.out.println("计时器出现异常");
            }
        }
    }
}

/**
 * 轮播图的线程
 */
class PictureThread implements Runnable {
    ImageIcon[] imageIcons = {
            new ImageIcon("F:\\Idea_Java\\homework\\src\\main\\resources\\picture\\1.1.png"),
            new ImageIcon("F:\\Idea_Java\\homework\\src\\main\\resources\\picture\\1.2.png"),
            new ImageIcon("F:\\Idea_Java\\homework\\src\\main\\resources\\picture\\1.3.png"),
            new ImageIcon("F:\\Idea_Java\\homework\\src\\main\\resources\\picture\\1.4.png"),
    };

    @Override
    public void run() {
        int index = 0;
        while (true) {
            try {
                Thread.sleep(1000);
                IndexFrame.imageLabel.setIcon(imageIcons[index]);
                if (index == 3) {
                    index = 0;
                } else {
                    index++;
                }
            } catch (InterruptedException e) {
                System.out.println("计时器出现异常");
            }
        }
    }
}