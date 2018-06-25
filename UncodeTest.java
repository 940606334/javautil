package cn.yearcon.sport.util;

import org.junit.Test;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author ayong
 * @create 2018-06-24 13:59
 **/
public class UncodeTest {



    public String convert(String code){
        String reg="&#\\d+;";
        Pattern pattern = Pattern.compile(reg);
        try {
            Matcher matcher = pattern.matcher(code);
            while (matcher.find()){
                String test=matcher.group();
                String a=test.substring(2,test.length()-1);
                char c=(char)Integer.parseInt(a);
                code=code.replaceAll(test,String.valueOf(c));
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(code);
        }

        return code;
    }

    @Test
    public void test2() throws IOException {
        String fileName="H:\\test.txt";

        StringBuffer sb= new StringBuffer("");
        InputStreamReader reader = new InputStreamReader(
                new FileInputStream(fileName)); // 建立一个输入流对象reader
        BufferedReader br = new BufferedReader(reader); // 建立一个对象，它把文件内容转成计算机能读懂的语言
        String line = "";
        line = br.readLine();
        /* 写入Txt文件 */
        File writename = new File("H:\\output.txt"); // 相对路径，如果没有则要建立一个新的output。txt文件
        writename.createNewFile(); // 创建新文件
        BufferedWriter out = new BufferedWriter(new FileWriter(writename));
        while (line != null) {
            line = br.readLine(); // 一次读入一行数据
            if(line!=null){
                line=convert(line);
                out.write(line);
            }
            //sb.append(line);
        }
        br.close();
        reader.close();
        //out.write(sb.toString());
        out.flush(); // 把缓存区内容压入文件
        out.close(); // 最后记得关闭文件

    }

}
