package Shift;

//循环左移
public class LoopLeftShift {
    public static void main(String[] args) {
        int a=0xD6485F0F;//转为2进制是32位
        //循环左移7位
        int temp=a<<7|a>>>(32-7);//这里注意右移用的是无符号右移
        System.out.println(Integer.toHexString(temp));//正确答案是0x242F87EB

        //循环右移7位
        temp=a>>>7|a<<(32-7);//这里注意右移用的是无符号右移
        System.out.println(Integer.toHexString(temp));//正确答案是0x1fac90be
    }
}
