public class challenge1 {
    public static void main(String[] argv){
        int[] nums1 = {1,2};
        int[] nums2 = {3,4};
        int[] nums3 = new int[1000];


        int i = 0;
        int j = 0;
        int k = 0;

        /**
         * Walk through all the arrays at the same time
         */
        while(i<nums1.length || j<nums2.length){
            if(i<nums1.length && j<nums2.length){
               if(nums1[i] <= nums2[j]) {
                  nums3[k] = nums1[i];
                  i++;
               }else {
                  nums3[k] = nums2[j];
                  j++;
               }
               k++;
            } else if(i<nums1.length){
                nums3[k]=nums1[i];
                i++;
                k++;
            }else {
                nums3[k] = nums2[j];
                j++;
                k++;
            }
        }

        // Collect the median

        float median = 0;
        if(k%2 == 0){
            System.out.println("even length"+k);
            median = (float)(nums3[(k/2)-1] + nums3[k/2])/2;
        }else median = nums3[k/2];

        // Output the results
        for(int n = 0; n<k; n++) System.out.println("New array is:"+nums3[n]);

        System.out.println("Median is: "+median);
    }
}
