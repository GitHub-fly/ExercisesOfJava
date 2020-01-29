package exercises.multithreading.GUIMultiThread;

import com.mrsoft.music.AudioPlayWave;
import exercises.util.StringUtil;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * @author xunmi
 * @ClassName IndexFrame
 * @Description ��ҳ����ƣ��ڰ���ͬ����ʾϵͳʱ�䡢�������֡�ͼƬ�ֲ�����
 * @Date 2020/1/29
 * @Version 1.0
 **/
public class IndexFrame extends JFrame {

    private static final long serialVersionUID = 1L;

    private JPanel contentPane;
    public static JLabel currentDate = new JLabel("", JLabel.CENTER);
    public static JLabel countDown = new JLabel("", JLabel.CENTER);
    public static AudioPlayWave audioPlayWave = new AudioPlayWave("F:\\Idea_Java\\homework\\src\\main\\resources\\music\\��ϲ.wav");
    public static JLabel imageLabel = new JLabel("", JLabel.CENTER);


    public IndexFrame() {
        // �������Զ���
        setTitle("���߳�ʵ�ֲ�ͬ����Ч��");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int width = screenSize.width;
        int height = screenSize.height;
        setBounds((width - 1100) / 2, (height - 700) / 2, 1100, 700);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setLayout(new GridLayout(2, 2, 10, 10));
        // ���������ڱ߾�
        contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
        setContentPane(contentPane);
        Font font = new Font("��������", Font.BOLD, 40);

        for (int i = 0; i < 4; i++) {
            JPanel panel = new JPanel();
            panel.setBorder(BorderFactory.createTitledBorder("���" + i));
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
                JLabel label = new JLabel("��л���ڴ˳����л���ʱ��", JLabel.CENTER);
                label.setFont(new Font("΢���ź�", Font.BOLD, 40));
                panel.add(label, JLabel.CENTER);
            }
            contentPane.add(panel);
        }
    }
}

/**
 * ��ȡ��ǰʱ����߳�
 */
class CurrentDateThread implements Runnable {
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
                IndexFrame.currentDate.setText(StringUtil.getCurrentDate());
            } catch (InterruptedException e) {
                System.out.println("�����������쳣");
            }
        }
    }
}

/**
 * �������ֲ��ŵ��߳�
 */
class MusicThread implements Runnable {

    private static int i = 3;

    @Override
    public void run() {
        while (true) {
            try {
                IndexFrame.countDown.setText("���ŵ���ʱ: " + i--);
                Thread.sleep(1000);
                if (i == 0) {
                    IndexFrame.countDown.setText("�������ֲ�����");
                    IndexFrame.audioPlayWave.start();
                    return;
                }
            } catch (InterruptedException e) {
                System.out.println("��ʱ�������쳣");
            }
        }
    }
}

/**
 * �ֲ�ͼ���߳�
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
                System.out.println("��ʱ�������쳣");
            }
        }
    }
}