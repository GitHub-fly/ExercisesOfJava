package exercises.reflect;

import exercises.entity.Writer;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class WriterDaoTest {
    private WriterDao writerDao = new WriterDao();

    @Test
    public void selectAll() {
        System.out.println("*****���β�ѯ*****");
        String sql = "SELECT * FROM writer WHERE writer = ? ";
        Object[] params = {"��ë"};
        List<Writer> writers = writerDao.selectAll(sql, params);
        System.out.println(writers);
        System.out.println("*****�޲β�ѯ����*****");
        sql = "SELECT * FROM writer";
        writers = writerDao.selectAll(sql, null);
        writers.forEach(System.out::println);
    }
}