package exercises.entity;

import lombok.Data;

/**
 * @author xunmi
 * @ClassName Writer
 * @Description 作者实体类
 * @Date 2020/1/23
 * @Version 1.0
 **/
@Data
public class Writer {

    private Integer id;
    private String writer;

    /**
     * 注意： 此处的字段名称必须和数据库表中的字段名称保持一致，
     *       请使用下划线连字符!!!
     */

    private String writer_introduce;
    private String avatar;

}
