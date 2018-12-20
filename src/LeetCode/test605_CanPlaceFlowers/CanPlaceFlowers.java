package LeetCode.test605_CanPlaceFlowers;

public class CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(flowerbed == null || flowerbed.length == 0)
            return false;

        int count = 0;
        for(int i = 0; i < flowerbed.length; i++){
            if(flowerbed[i] == 1)
                continue;
            int pre = i == 0 ? 0 : flowerbed[i - 1];
            int next = i == flowerbed.length - 1 ? 0 : flowerbed[i + 1];
            if(pre == 0 && next == 0){
                count++;
                flowerbed[i] = 1;
            }
        }
        return count >= n;
    }
}
