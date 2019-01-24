public class Remove_Duplicates_from_Sorted_Array {
    public int removeDuplicates(int[] nums) {
        if(nums.length==1)
            return 1;
        int index=0;
        for (int i = 0; i < nums.length; i++) {
            if(i!=0 && nums[index-1]==nums[i])
                continue;
            else
                nums[index++]=nums[i];
        }
        return index;
    }
}
