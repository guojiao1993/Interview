package netease.P811;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class T3 {
    public static List<List<Character>> permuteUnique(char[] nums) {
        List<List<Character>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), nums, new boolean[nums.length]);
        return list;
    }

    private static void backtrack(List<List<Character>> list, List<Character> tempList, char [] nums, boolean [] used){
        if(tempList.size() == nums.length){
            list.add(new ArrayList<>(tempList));
        } else{
            for(int i = 0; i < nums.length; i++){
                if(used[i] || i > 0 && nums[i] == nums[i-1] && !used[i - 1]) {
                    continue;
                }
                used[i] = true;
                tempList.add(nums[i]);
                backtrack(list, tempList,	 nums, used);
                used[i] = false;
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String[] split = str.split(" ");
        int lena = Integer.valueOf(split[0]);
        int lenb = Integer.valueOf(split[1]);
        int k = Integer.valueOf(split[2]);
        int len = lena + lenb;
        char[] ch = new char[len];
        for(int i = 0; i < lena;i++) {
            ch[i] = 'a';
        }
        for(int i = 0; i < lenb; i++) {
            ch[i + lena] = 'z';
        }
        List<List<Character>> list = permuteUnique(ch);
        int size = list.size();
        if(k>size) {
            System.out.println(-1);
        }else {
            List<Character> list2 = list.get(k-1);
            StringBuilder sb = new StringBuilder();
            for(char c : list2) {
                sb.append(c);
            }
            System.out.println(sb.toString());
        }
    }
}