public class challenge2 {



    public static void main(String[] argv){
        // Initialize three linked lists
        int[] nums1 = {1,4,5};
        int[] nums2 = {1,3,4};
        int[] nums3 = {2,6};
        ChallengeNode head1 = new ChallengeNode(nums1);
        ChallengeNode head2 = new ChallengeNode(nums2);
        ChallengeNode head3 = new ChallengeNode(nums3);

        //Merge
        ChallengeNode n = head1;

        while(head2.hasNext() || head3.hasNext()) {
            if(head2.hasNext()){
               head2 = head2.getNext(); // Move to next node
               n.setNext(head2.getPrevious()); // Move previous node to other list
               n = n.getNext(); //Advance pointer
            }
            if(head3.hasNext()){
               head3 = head3.getNext(); // Move to next node
               n.setNext(head3.getPrevious()); // Move previous node to other list
               n = n.getNext(); //Advance pointer
            }
        }
        n.setNext(head2);
        n = n.getNext();
        n.setNext(head3);
        n = n.getNext();

        n = head1;
        while(n.hasNext()) {
            System.out.println(n.value);
            n = n.getNext();
        }
        System.out.println(n.value);
        System.out.println("Merged");
            
        
        head1.sortFromHere();
        n = head1;
        while(n.hasNext()) {
            System.out.println(n.value);
            n = n.getNext();
        }
        System.out.println(n.value);

    }
}
