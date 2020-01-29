package exercises.multithreading.GUIMultiThread;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;


/**
 * @author xunmi
 * @ClassName MainFrame
 * @Description 结合GUI和多线程，实现：
 * 1. 同步显示系统时间
 * 2. 播放音乐
 * 3. 图片轮播
 * 以上每个功能分别应对一个线程
 * @Date 2020/1/29
 * @Version 1.0
 **/
public class MainFrame {

    public static void main(String[] args) {
        // 导入皮肤包
        try {
            BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.osLookAndFeelDecorated;
            BeautyEyeLNFHelper.launchBeautyEyeLNF();
        } catch (Exception e) {
            System.out.println("Set skin fail!");
        }

        new IndexFrame().setVisible(true);

    }
}
