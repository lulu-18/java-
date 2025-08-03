package test.practice;

import java.util.Random;

public class Test {
    public static void main(String[] args) {
        //新建一个数组
        int[] ArrTest = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        //遍历数组，得到每一个元素，拿这个元素和随机指引上的元素进行交换
        Random rand = new Random();
        for(int i=0;i<ArrTest.length;i++){
            int t=rand.nextInt(ArrTest.length);
            int temp=ArrTest[i];
            ArrTest[i]=ArrTest[t];
            ArrTest[t]=temp;
        }
        //遍历数组
        for(int i=0;i<ArrTest.length;i++){
            System.out.print(ArrTest[i]+" ");

        }
        System.out.println();
        //创建二维数组
        int[][] Arr2=new int[4][4];
        int num=0;
        for(int i=0;i< Arr2.length;i++){
            for(int j=0;j<Arr2[i].length;j++) {
                Arr2[i][j] = ArrTest[num];
                num++;
            }
        }

    }
}
