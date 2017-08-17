/*
 *有一条彩色宝石项链，是由很多种不同的宝石组成的，包括红宝石，蓝宝石，钻石，翡翠，珍珠等。有一天国王把项链赏赐给了一个学者，并跟他说，你可以带走这条项链，但是王后很喜欢红宝石，蓝宝石，紫水晶，翡翠和钻石这五种，我要你从项链中截取连续的一小段还给我，这一段中必须包含所有的这五种宝石，剩下的部分你可以带走。如果无法找到则一个也无法带走。请帮助学者找出如何切分项链才能够拿到最多的宝石。
 * */
代码示例：
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
 
import javax.swing.event.ListSelectionEvent;
 
public class Main {
 
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String str=scanner.nextLine();
        System.out.println(getLong(str));
    }
    public static int getLong(String str){
        char[] charArray = str.toCharArray();
        for(int x=5;x<charArray.length;x++){ //至少取5个
            for(int y=0;y<charArray.length;y++){
                StringBuilder sb=new StringBuilder();
                for(int z=y;z<y+x;z++){
                    sb.append(charArray[z%charArray.length]); //因为是环的  考虑z%len
                }
                String temp=sb.toString();
                if(sb.toString().contains("A")&&sb.toString().contains("B")&&sb.toString().contains("C")&&sb.toString().contains("D")&&sb.toString().contains("E")){
                    return charArray.length-temp.length();
                }
            }
        }
        return -1;
    }
}
