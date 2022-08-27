
    /**
     * Create linked list node class
     */
    public class ChallengeNode {
        public int value;
        
        protected ChallengeNode previous = null;
        protected ChallengeNode next = null;

        public ChallengeNode(int v){
            value = v;
        }

        public ChallengeNode(int[] v){
            value = v[0];
            next = new ChallengeNode(v[1]);
            next.previous = this;
            ChallengeNode n = next;
            for(int i=2; i<v.length; i++){
                n.setNext(new ChallengeNode(v[i]));
                n = n.getNext();
            }
        }

        public boolean hasPrevious(){
            return previous != null;
        }
        public ChallengeNode getPrevious(){
            return previous;
        }
        public void setPrevious(ChallengeNode n){
            //Excise for previous list
            if(n.hasPrevious()) n.previous.next = n.next;
            if(n.hasNext()) n.next.previous = n.previous;
            if(this.hasPrevious()){
                this.previous.next = n;
            }
            n.previous = this.previous;
            n.next = this;
            this.previous = n;
        }

        public boolean hasNext(){
            return next != null;
        }
        public ChallengeNode getNext(){
            return next;
        }
        public void setNext(ChallengeNode n){
            //Excise from previous list
            if(n.hasPrevious()) n.previous.next = n.next;
            if(n.hasNext()) n.next.previous = n.previous;
            if(this.hasNext()){
                this.next.previous = n;
            }
            n.previous = this;
            n.next = this.next;
            this.next = n;
        }

        public void sortFromHere(){
            if(this.hasNext()) this.sortRight();
            if(this.hasPrevious()) this.sortLeft();
        }
        public void sortRight(){
            if(!this.hasNext()) return;//End of list
            ChallengeNode right = this.getNext();
            ChallengeNode lowest = this.getNext();
            // Strategy, find the smallest value on the right and then compare
            // To this and put it as either previous or next
            while(right.hasNext()){
                right = right.getNext();
                if(right.value < lowest.value) lowest = right;
            }
            if(lowest.value < this.value) {
                this.setPrevious(lowest);
                this.sortRight();
            } else {
                this.setNext(lowest);
                lowest.sortRight();
            }
        }
        public void sortLeft(){
            if(!this.hasPrevious()) this.sortRight();//Start of list, Since sortLeft is called last we can do this without an infinite loop.  Just for confirmation.
            ChallengeNode left = this.getPrevious();
            ChallengeNode highest = this.getPrevious();
            // Strategy, find the largest value on the left and then compare
            // To this and put it as either previous or next
            while(left.hasPrevious()){
                left = left.getPrevious();
                if(left.value > highest.value) highest = left;
            }
            if(highest.value > this.value) {
                this.setNext(highest);
                this.sortLeft();
            } else {
                this.setPrevious(highest);
                highest.sortLeft();
            }

        }
    }
