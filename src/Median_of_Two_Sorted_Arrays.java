public class Median_of_Two_Sorted_Arrays {

    public static void main(String[] args) {
        int nums1[] = {1,3,6,7};
        int nums2[] = {2,4,5,8};
        System.out.println(findMedianSortedArrays(nums1,nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length==0 && nums2.length==0) {               //两数组长度全为0
            return 0;
        } else if (nums1.length==0 && nums2.length>=1){         //nums1长度为0，nums2长度大于等于1
            if (nums2.length%2==0)
                return (double) (nums2[nums2.length/2]+nums2[nums2.length/2-1])/2;
            else
                return nums2[nums2.length/2];
        } else if (nums2.length==0 && nums1.length >= 1){       //nums2长度为0，nums1长度大于等于1
            if (nums1.length%2==0)
                return (double) (nums1[nums1.length/2]+nums1[nums1.length/2-1])/2;
            else
                return nums1[nums1.length/2];
        } else if (nums1.length==1 && nums2.length==1){         //两数组长度全为1
            return (double) (nums1[0]+nums2[0])/2;
        } else if (nums1.length==1 && nums2.length>=1){         //nums1长度为1，nums2长度大于等于1
            if ((nums1.length+nums2.length)%2==0){      //(m+n)%2==0
                return 0;
            } else {                                    //(m+n)%2!=0
                return 0;
            }
        } else if (nums2.length==1 && nums1.length>=1){         //nums2长度为1，nums1长度大于等于1
            if ((nums1.length+nums2.length)%2==0){      //(m+n)%2==0
                return 0;
            } else {                                    //(m+n)%2!=0
                return 0;
            }
        } else if (nums1.length >=2 && nums2.length>=2){        //nums1与nums2长度同时大于等于2
            if (nums1[nums1.length-1]<=nums2[0]){         //max(nums1)<=min(nums2)
                return 0;
            } else if (nums2[nums2.length-1]<=nums1[0]){  //max(nums2)<=min(nums1)
                return 0;
            } else {
                //通常情况处理，且使得传入进入参数保持 A.length>=B.length
                if (nums1.length>nums2.length)
                    return (nums1.length+nums2.length)%2 ==0 ? getEvenReslut(nums1,nums2):getOddResult(nums1,nums2);
                else
                    return (nums1.length+nums2.length)%2 ==0 ? getEvenReslut(nums2,nums1):getOddResult(nums2,nums1);
            }
        }
        return -1;
    }

    /**
     * 前提：(m+n)%2==0
     * A.length>B.length 即为 m > n
     * A[m]: i
     * B[n]: j
     */
    public static double getEvenReslut(int[] A,int[] B){
        int i = A.length/2;
        int j = getRestriction(i,A.length,B.length);

        do {
            if (A[i-1]>B[j]){
                i--;
                j=getRestriction(i,A.length,B.length);
            } else if (B[j-1]>A[i]){
                i++;
                j=getRestriction(i,A.length,B.length);
            } else if (A[i-1]<=B[j] && B[j-1]<=A[i]){
                System.out.println(A[i]+" "+B[j]);
                return (double) (A[i]+B[j])/2;
            }
        } while (true);
    }

    /**
     * 前提：(m+n)%2!=0
     * A.length>B.length 即为 m > n
     * A[m]: i
     * B[n]: j
     */
    public static double getOddResult(int[] A,int[] B){
//        int i = A.length/2;
        int i = 1;
        int j = getRestriction(i,A.length,B.length);

        do {
            if (A[i-1]<=B[j] && A[i]>=B[j]){
                return (double) B[j];
            } else if (A[i]<=B[j] && A[i]>=B[j-1]){
                return (double) A[i];
            }
            i++;
            j = getRestriction(i,A.length,B.length);
        } while (true);
    }

    public static int getRestriction(int i,int m,int n){
        return (m+n-1)/2-i;
    }


}
