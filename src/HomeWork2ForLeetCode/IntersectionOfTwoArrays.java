package HomeWork2ForLeetCode;

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> result=new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i=0,j=0;
        while(i<nums1.length && j<nums2.length){
            if(nums1[i]==nums2[j]){
                result.add(nums1[i]);
                i++;
                j++;
            }else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        int[] inter=new int[result.size()];
        for (int k = 0; k < result.size(); k++) {
            inter[k] = result.get(k);
        }

        return inter;
    }
}
