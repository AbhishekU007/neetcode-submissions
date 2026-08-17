class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] A = nums1;
        int[] B = nums2;

        if(A.length > B.length){
            int[] temp = A;
            A = B;
            B = temp;
        }

        int m = A.length;
        int n = B.length;
        int total = m + n;

        int left = 0, right = m;
        while(left <= right){
            int i = left + (right - left) / 2;
            int j = (m + n + 1) / 2 - i;

            int Aleft = i > 0 ? A[i-1] : Integer.MIN_VALUE;
            int Aright = i < A.length ? A[i] : Integer.MAX_VALUE;
            int Bleft = j > 0 ? B[j-1] : Integer.MIN_VALUE;
            int Bright = j < B.length ? B[j] : Integer.MAX_VALUE;

            if(Aleft > Bright) right = i-1;
            else if(Bleft > Aright) left = i+1;
            else if(Aleft <= Bright && Bleft <= Aright){
                if(total % 2 != 0){
                    return Math.max(Aleft, Bleft);
                } else return (Math.max(Aleft, Bleft) + Math.min(Aright, Bright))/2.0;
            }
        }
        return -1;
    }
}
