/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
       int left = 0;
       int right = n;
        while(left <= right){
            if(this.guess(left) == 0 ){
                return left;
            }
            if( this.guess(right) == 0){
                return right;
            }
            int mid = (left + right) /2;
            int res = this.guess(mid);
            if(res == 0){
                return mid;
            }else if(res == 1){
                left = mid +1;
            }else{
                right = mid - 1;
            }
        }
        return -1;
    }
}