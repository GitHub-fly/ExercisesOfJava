package exercises.multithreading.GUIMultiThread;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;


/**
 * @author xunmi
 * @ClassName MainFrame
 * @Description ���GUI�Ͷ��̣߳�ʵ�֣�
 * 1. ͬ����ʾϵͳʱ��
 * 2. ��������
 * 3. ͼƬ�ֲ�
 * ����ÿ�����ֱܷ�Ӧ��һ���߳�
 * @Date 2020/1/29
 * @Version 1.0
 **/
public class MainFrame {

    public static void main(String[] args) {
        // ����Ƥ����
        try {
            BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.osLookAndFeelDecorated;
            BeautyEyeLNFHelper.launchBeautyEyeLNF();
        } catch (Exception e) {
            System.out.println("Set skin fail!");
        }

        new IndexFrame().setVisible(true);

    }
}
