package exercises.entity;

import lombok.Data;

/**
 * @author xunmi
 * @ClassName Writer
 * @Description ����ʵ����
 * @Date 2020/1/23
 * @Version 1.0
 **/
@Data
public class Writer {

    private Integer id;
    private String writer;

    /**
     * ע�⣺ �˴����ֶ����Ʊ�������ݿ���е��ֶ����Ʊ���һ�£�
     *       ��ʹ���»������ַ�!!!
     */

    private String writer_introduce;
    private String avatar;

}
